package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.Contact;
import lv.javaguru.java2.database.ContactDatabase;

import java.util.List;

public class AddContactService {

    private ContactDatabase contactDatabase;

    public AddContactService(ContactDatabase contactDatabase) {
        this.contactDatabase = contactDatabase;
    }

    public void addContact(String name, String phoneNumber) {
       Contact contact = new Contact();
       contact.setName(name);
       contact.setPhoneNumber(phoneNumber);
       contactDatabase.add(contact);
        }
}
