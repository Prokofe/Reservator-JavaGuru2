package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Reservation;

import java.time.LocalDateTime;
import java.util.Set;

public interface ReservationDAO {

    Reservation save(Reservation reservation);

    Set<Reservation> findByDate(LocalDateTime reservationTime);

}
