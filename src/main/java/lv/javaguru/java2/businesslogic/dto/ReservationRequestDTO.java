package lv.javaguru.java2.businesslogic.dto;

import java.time.LocalDateTime;

public class ReservationRequestDTO {

    private String phoneNumber;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int personCount;

    public ReservationRequestDTO(String phoneNumber, String name, LocalDateTime startTime, LocalDateTime endTime, int personCount) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.personCount = personCount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }
}
