package lv.javaguru.java2.view;

import lv.javaguru.java2.businesslogic.RemoveReservationService;
import lv.javaguru.java2.database.ReservationDatabase;

import java.util.Scanner;

public class RemoveReservationView implements View {

    private RemoveReservationService removeReservationService;

    public RemoveReservationView(ReservationDatabase reservationDatabase) {
        this.removeReservationService = new RemoveReservationService(reservationDatabase);
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Remove reservation from db: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter phoneNumber: ");
        final String phoneNumber = sc.nextLine();

        boolean isRemoved = removeReservationService.removeProduct(phoneNumber);

        if (isRemoved){
            System.out.println("Reservation with phone number " + phoneNumber + " was successfully removed!");
        } else {
            System.out.println("Reservation with phone number " + phoneNumber + " not found!");
        }
        System.out.println();
    }
}
