package lv.javaguru.java2.database;

import lv.javaguru.java2.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactInMemoryDatabase implements ContactDatabase{

    private List<Contact> contacts = new ArrayList<>();


    @Override
    public void add(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public Optional<Contact> findByPhoneNumber(String phoneNumber) {
        return contacts.stream()
                .filter(p -> p.getName().equals(phoneNumber))
                .findFirst();
    }

    @Override
    public void remove(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public List<Contact> getAllContact() {
        List<Contact> allContacts = new ArrayList<>();
        allContacts.addAll(contacts);
        return allContacts;
    }
}
