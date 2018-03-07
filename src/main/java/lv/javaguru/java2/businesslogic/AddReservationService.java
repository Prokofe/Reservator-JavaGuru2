package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.Reservation;
import lv.javaguru.java2.database.ReservationDatabase;

public class AddReservationService {

    private ReservationDatabase reservationDatabase;

    public AddReservationService(ReservationDatabase reservationDatabase) {
        this.reservationDatabase = reservationDatabase;
    }

    public void addReservation(String dateTime, String name, String phoneNumber, String personCount){
        Reservation reservation = new Reservation();
        reservation.setDateTime(dateTime);
        reservation.setName(name);
        reservation.setPhoneNumber(phoneNumber);
        reservation.setPersonCount(personCount);
        reservationDatabase.add(reservation);
    }
}
