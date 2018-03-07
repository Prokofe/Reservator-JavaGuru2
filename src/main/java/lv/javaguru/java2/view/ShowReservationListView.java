package lv.javaguru.java2.view;

import lv.javaguru.java2.Reservation;
import lv.javaguru.java2.database.ReservationDatabase;

public class ShowReservationListView implements View {

    private ReservationDatabase reservationDatabase;

    public ShowReservationListView(ReservationDatabase reservationDatabase) {
        this.reservationDatabase = reservationDatabase;
    }


    @Override
    public void execute() {
        System.out.println();
        System.out.println("Print all reservations: ");
        for (Reservation reservation : reservationDatabase.getAllReservations()){
            System.out.println(reservation);
        }
        System.out.println();
    }
}
