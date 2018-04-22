package lv.javaguru.java2.view;

import lv.javaguru.java2.businesslogic.AddContactResponse;
import lv.javaguru.java2.businesslogic.AddContactService;
import lv.javaguru.java2.database.ContactDatabase;

import java.util.Scanner;

public class AddContactView implements View{

    private AddContactService addContactService;

    public AddContactView(ContactDatabase contactDatabase) {
               this.addContactService = new AddContactService(contactDatabase);
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Add Contact to list");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Contacts name");
        String name = sc.nextLine();
        System.out.print("Enter Contacts phone number");
        String phoneNumber = sc.nextLine();

            AddContactResponse response = addContactService.addContact(name, phoneNumber);
        if (response.isSuccess()) {
            System.out.println("Contact successfully added to list!");
            System.out.println();
        } else {
            response.getErrors().forEach(error -> {
                System.out.println("Error field = " + error.getField());
                System.out.println("Error message = " + error.getErrorMessage());
            });
            System.out.println();
        }
    }
}
