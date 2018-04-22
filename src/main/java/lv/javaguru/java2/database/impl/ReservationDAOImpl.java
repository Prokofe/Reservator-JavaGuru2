package lv.javaguru.java2.database.impl;

import lv.javaguru.java2.database.ReservationDAO;
import lv.javaguru.java2.domain.Reservation;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class ReservationDAOImpl extends ORMRepository
        implements ReservationDAO {

    @Override
    public Reservation save(Reservation reservation) {
        session().save(reservation);
        return (Reservation) session().get(Reservation.class, reservation.getId());
    }

    @Override
    public Set<Reservation> findByDate(LocalDateTime reservationTime) {
        LocalDate date = reservationTime.toLocalDate();
        Query query = session().createQuery("from reservations where DATE_FORMAT(startTime,'MM/dd/yyyy') = :date");
        query.setParameter("date", date);
        return new HashSet<>(query.list());
    }
}
