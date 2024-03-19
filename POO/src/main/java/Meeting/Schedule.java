package Meeting;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endTime;
    private Meeting[] meetings =  new Meeting[100];
    private int numberOfMeetings = 0;

    private Schedule(LocalDate day, LocalTime startTime, LocalTime endTime){
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static Schedule createSchedule(LocalDate day, LocalTime startTime, LocalTime endTime){
        return new Schedule(day, startTime, endTime);
    }
    public void addMeet(Meeting meeting){
        if(meeting.getStartTime().isAfter(meeting.getEndTime())){
            return;
        }
        if(meeting.getStartTime().isBefore(startTime) || meeting.getEndTime().isAfter(endTime)){
            return;
        }
        if(Duration.between(meeting.getStartTime(), meeting.getEndTime()).toMinutes() > Duration.between(startTime,endTime).toMinutes()){
            return;
        }
        for (int i = 0; i < numberOfMeetings; i++) {
            if(meeting.getStartTime().isBefore(meetings[i].getEndTime()) && meeting.getEndTime().isAfter(meetings[i].getStartTime())){
                return;
            }
        }
        if(numberOfMeetings >= meetings.length){
            return;
        }
        meetings[numberOfMeetings] = meeting;
        numberOfMeetings++;

    }
    public void removeMeet(Meeting meeting){
        for (int i = 0; i < numberOfMeetings; i++) {
            if(meetings[i].equals(meeting)){
                for (int j = i; j < numberOfMeetings - 1; j++) {
                    meetings[j] = meetings[j+1];
                }
                meetings[numberOfMeetings-1] = null;
                numberOfMeetings--;
                break;
            }
        }
    }

    private int totalMinutes(){
        return (int) Duration.between(startTime, endTime).toMinutes();
    }

    private int meetingMinutes(){
        int minutes = 0;
        for (int i = 0; i < numberOfMeetings; i++) {
            minutes += (int) Duration.between(meetings[i].getStartTime(), meetings[i].getEndTime()).toMinutes();

        }
        return minutes;
    }
    public double percentageSpentInMeetings(){
        if(totalMinutes() == 0)
            return 1;
        int totalMeetingMinutes = meetingMinutes();
        return 100.0 * totalMeetingMinutes / totalMinutes();

    }
    public String scheduleAsString(){
        StringBuilder sb = new StringBuilder();
        if(numberOfMeetings == 0){
            sb.append("No meetings scheduled for ").append(day);
        }else{
            sb.append("Meetings scheduled for ").append(day).append(":\n")
                    .append("Start Time: ").append(startTime)
                    .append(", End Time: ").append(endTime).append("\n");
            for (int i = 0; i < numberOfMeetings; i++) {
                Meeting meeting = meetings[i];
                sb.append("Meeting ").append(i + 1).append(": ")
                        .append(meeting.getDescription())
                        .append(", Start Time: ").append(meeting.getStartTime())
                        .append(", End Time: ").append(meeting.getEndTime())
                        .append("\n");
            }
        }
        return sb.toString();
    }

}
