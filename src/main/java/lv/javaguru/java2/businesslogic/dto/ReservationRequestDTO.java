package lv.javaguru.java2.businesslogic.dto;

import java.time.LocalDateTime;

public class ReservationRequestDTO {

    private String phoneNumber;
    private String name;
    private LocalDateTime dateTime;
    private int personCount;

    public ReservationRequestDTO(String phoneNumber, String name, LocalDateTime dateTime, int personCount) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }
}
