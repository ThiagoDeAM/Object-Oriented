package Meeting;

import java.time.Duration;
import java.time.LocalTime;

public class Meeting {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private Schedule schedule;

    private Meeting(String description, LocalTime startTime, LocalTime endTime, Schedule schedule){
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.schedule = schedule;
    }

    public static Meeting createMeeting(String description, LocalTime startTime, LocalTime endTime, Schedule schedule){
        return new Meeting(description, startTime, endTime, schedule);
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int durationInMinutes(){
        return (int) Duration.between(startTime, endTime).toMinutes();
    }

    public String MeetingAsString(){
        return "Meeting{" +
                "description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime='" + endTime + '\'' +
                ", schedule='" + schedule.scheduleAsString() + '\'' +
                '}';
    }
}
