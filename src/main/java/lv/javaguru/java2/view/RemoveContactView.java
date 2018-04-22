package lv.javaguru.java2.view;

import lv.javaguru.java2.businesslogic.RemoveContactService;
import lv.javaguru.java2.database.ContactDatabase;

import java.util.Scanner;

public class RemoveContactView implements View {

    private RemoveContactService removeContactService;

    public RemoveContactView(ContactDatabase contactDatabase) {
        this.removeContactService = new RemoveContactService(contactDatabase);
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Remove Contact");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Phone Number name");
        final String phoneNumber = sc.nextLine();

        boolean isRemoved = removeContactService.removeContact(phoneNumber);

        if (isRemoved) {
            System.out.println("Contact with name " + phoneNumber + " was found and will be removed from list!");
        } else {
            System.out.println("Contact with name " + phoneNumber + " not found and not be removed from list!");
        }
        System.out.println("Remove Contact from list execution end!");
        System.out.println();
    }
}
