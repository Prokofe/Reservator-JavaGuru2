package lv.javaguru.java2.database;

import lv.javaguru.java2.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDatabase {

    void add(Contact contact);

    Optional<Contact> findByPhoneNumber(String phoneNumber);

    void remove(Contact contact);

    List<Contact> getAllContact();

}