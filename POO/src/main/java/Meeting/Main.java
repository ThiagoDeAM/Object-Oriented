package Meeting;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalDate day = LocalDate.now();
        LocalTime startOfWork = LocalTime.of(8,0);
        LocalTime endOfWork = LocalTime.of(17,0);
        Schedule s1 = Schedule.createSchedule(day, startOfWork, endOfWork);

        LocalTime startOfMeet = LocalTime.of(9,0);
        LocalTime endOfMeet = LocalTime.of(9, 30);

        Meeting m1 = Meeting.createMeeting("Café", startOfMeet, endOfMeet, s1);
        Meeting m2 = Meeting.createMeeting("Consulta", startOfMeet.plusMinutes(30), endOfMeet.plusMinutes(30), s1);

        s1.addMeet(m1);
        s1.addMeet(m2);

        //System.out.println(m1.durationInMinutes());
        //System.out.println(s1.percentageSpentInMeetings());

        //System.out.println(m1.MeetingAsString());
        
        s1.removeMeet(m1);

        System.out.println(s1.scheduleAsString());
    }
}
