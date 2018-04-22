package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.Contact;
import lv.javaguru.java2.database.ContactDatabase;

import java.util.List;

public class AddContactService {

    private ContactDatabase contactDatabase;
    private AddContactValidator addContactValidator;

    public AddContactService(ContactDatabase contactDatabase, AddContactValidator contactValidator) {
        this.contactDatabase = contactDatabase;
        this.addContactValidator = contactValidator;
    }

    public AddContactResponse addContact(String name, String phoneNumber) {
        List<Error> validationErrors = addContactValidator.validate(name, phoneNumber);
        if (!validationErrors.isEmpty()) {
            return new AddContactResponse(false, validationErrors);
        }
       Contact contact = new Contact();
       contact.setName(name);
       contact.setPhoneNumber(phoneNumber);
       contactDatabase.add(contact);

        return new AddContactResponse(true, null);
        }
}
