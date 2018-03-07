package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.Reservation;
import lv.javaguru.java2.database.ReservationDatabase;

import java.util.Optional;

public class RemoveReservationService {

    private ReservationDatabase reservationDatabase;

    public RemoveReservationService(ReservationDatabase reservationDatabase) {
        this.reservationDatabase = reservationDatabase;
    }

    public boolean removeProduct(String phoneNumber){
        Optional<Reservation> foundReservation = reservationDatabase.findByPhoneNumber(phoneNumber);
        if(foundReservation.isPresent()){
            Reservation reservation = foundReservation.get();
            reservationDatabase.remove(reservation);
            return true;
        } else {
            return false;
        }
    }

}
