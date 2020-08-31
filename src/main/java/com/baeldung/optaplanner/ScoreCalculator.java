package com.baeldung.optaplanner;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

import java.util.HashSet;

public class ScoreCalculator implements EasyScoreCalculator<RoomSchedule> {

	/*
	 * The rule says ; there shouldn't be be more than one schedule, for the same
	 * resource and for the same time
	 */

	@Override
	public Score<?> calculateScore(RoomSchedule courseSchedule) {
		int hardScore = 0;
		int softScore = 0;

		HashSet<String> occupiedRooms = new HashSet<>();
		for (RoomPeriods lecture : courseSchedule.getLectureList()) {
			if (lecture.getPeriod() != null && lecture.getRoomNumber() != null) {
				String roomInUse = lecture.getPeriod().toString() + ":" + lecture.getRoomNumber().toString();
				// System.out.println("roomInUse (period:room):"+roomInUse);
				if (occupiedRooms.contains(roomInUse)) {
					hardScore += -1;
				} else {
					occupiedRooms.add(roomInUse);
					softScore += 1;
				}
			} else {
				hardScore += -1;
			}
		}

		return HardSoftScore.valueOf(hardScore, softScore);
	}
}
