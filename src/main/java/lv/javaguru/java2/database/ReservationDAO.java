package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Reservation;

public interface ReservationDAO {

    Reservation save(Reservation reservation);

    void remove(Reservation reservation);


}
