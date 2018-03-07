package lv.javaguru.java2.database;

import lv.javaguru.java2.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationInMemoryDatabase implements  ReservationDatabase{

    private List<Reservation> reservations = new ArrayList<>();


    @Override
    public void add(Reservation reservation) {
        reservations.add(reservation);
    }

    @Override
    public Optional<Reservation> findByPhoneNumber(String phoneNumber) {
        return reservations.stream()
                .filter(p -> p.getPhoneNumber().equals(phoneNumber))
                .findFirst();
    }

    @Override
    public void remove(Reservation reservation) {
        reservations.remove(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> allReservations = new ArrayList<>();
        allReservations.addAll(reservations);
        return allReservations;
    }
}
