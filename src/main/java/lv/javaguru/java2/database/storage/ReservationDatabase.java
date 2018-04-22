package lv.javaguru.java2.database.storage;

import lv.javaguru.java2.domain.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationDatabase {

    void add(Reservation reservation);

    Optional<Reservation> findByPhoneNumber(String phoneNumber);

    void remove(Reservation reservation);

    List<Reservation> getAllReservations();

}
