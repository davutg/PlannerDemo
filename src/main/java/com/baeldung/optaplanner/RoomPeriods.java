package com.baeldung.optaplanner;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class RoomPeriods {

    private Integer roomNumber;
    private Integer period;
    private String sessionName="Calculated Session";
    
    public RoomPeriods(){
    	
    }
    
    public RoomPeriods(int roomNumber,int period) {
		this.roomNumber=roomNumber;
		this.period=period;
	}
    
    @PlanningVariable(valueRangeProviderRefs = {"availablePeriods"})
    public Integer getPeriod() {
        return period;
    }

    @PlanningVariable(valueRangeProviderRefs = {"availableRooms"})
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    @Override
    public String toString() {
    	return this.getRoomNumber()+" : "+ this.getPeriod();
    }

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

    
}
