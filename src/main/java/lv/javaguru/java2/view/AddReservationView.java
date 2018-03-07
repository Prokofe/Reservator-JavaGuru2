package lv.javaguru.java2.view;

import lv.javaguru.java2.businesslogic.AddReservationService;
import lv.javaguru.java2.database.ReservationDatabase;

import java.util.Scanner;

public class AddReservationView implements View {

    private AddReservationService addReservationService;

    public AddReservationView(ReservationDatabase reservationDatabase) {
        this.addReservationService = new AddReservationService(reservationDatabase);
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Add new reservation: ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date: ");
        String date = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phoneNumber: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter person count: ");
        String personCount = sc.nextLine();


        addReservationService.addReservation(date, name, phoneNumber, personCount);
        System.out.println("New reservation added");
        System.out.println();
    }
}
