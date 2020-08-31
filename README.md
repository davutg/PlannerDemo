# Setting up things based on know FACTS and expecting Planner Engine to schedule for us.





	public class PlannerTestCase {

		static RoomSchedule unsolvedCourseSchedule;

		// Setting up the environment based on KNOWN FACTS, rooms, session etc. 
		// There are 3 periods for 2 rooms. Problem could be more complicated. i.e. There could be days as well 
		
		@BeforeAll
		public static void setUp() {

			unsolvedCourseSchedule = new RoomSchedule();

			
		  // fixed periods I'm defining
			RoomPeriods fixedRoomPeriod1=new RoomPeriods(1, 1);
			fixedRoomPeriod1.setSessionName("Session Fixed 1");
			
			RoomPeriods fixedRoomPeriod2=new RoomPeriods(1, 2);
			fixedRoomPeriod2.setSessionName("Session Fixed 2");
			
		 // I'm adding fixed periods to schedule, these are known fixed schedule items
			unsolvedCourseSchedule.getLectureList().add(fixedRoomPeriod1);
			unsolvedCourseSchedule.getLectureList().add(fixedRoomPeriod2);    
			
		 /* I'm adding 10 more schedule items which are [null,null] , I'm expecting optoplanner assign period and room numbers. 
		  * [ THEY ARE LINKED with annotations, @PlanningVariable,	@ValueRangeProvider(id = "availablePeriods", @ProblemFactCollectionProperty]
		  */
			for(int i = 0; i < 10; i++){        	        	
				unsolvedCourseSchedule.getLectureList().add(new RoomPeriods());          
			}
			
		  // 
			unsolvedCourseSchedule.getPeriodList().addAll(Arrays.asList(new Integer[] { 1, 2, 3 }));
			unsolvedCourseSchedule.getRoomList().addAll(Arrays.asList(new Integer[] { 1, 2 }));
		}


	... RUN !