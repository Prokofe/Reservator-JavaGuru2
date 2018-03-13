package lv.javaguru.java2.view;

import lv.javaguru.java2.Contact;
import lv.javaguru.java2.database.ContactDatabase;

public class ShowContactView implements View {

    private ContactDatabase contactDatabase;

    public ShowContactView(ContactDatabase contactDatabase) {
        this.contactDatabase = contactDatabase;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Print Contact List");
        for (Contact contact : contactDatabase.getAllContact()) {
            System.out.println(contact.getName() + "[" + contact.getPhoneNumber() + "]");
        }
        System.out.println("Contact list finished");
        System.out.println();
    }
}

