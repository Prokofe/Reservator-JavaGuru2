package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.Contact;
import lv.javaguru.java2.database.ContactDatabase;

import java.util.Optional;

public class RemoveContactService {
    private ContactDatabase contactDatabase;

    public RemoveContactService(ContactDatabase contactDatabase) {
        this.contactDatabase = contactDatabase;
    }

    public boolean removeContact(String phoneNumber) {
        Optional<Contact> foundContact = contactDatabase.findByPhoneNumber(phoneNumber);
        if (foundContact.isPresent()) {
            Contact contact = foundContact.get();
            contactDatabase.remove(contact);
            return true;
        } else {
            return false;
        }
    }
}
