package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.Contact;
import lv.javaguru.java2.database.ContactDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddContactValidator {

    private ContactDatabase contactDatabase;

    public AddContactValidator(ContactDatabase contactDatabase) {
        this.contactDatabase = contactDatabase;
    }

    public List<Error> validate (String name, String phoneNumber) {
        List<Error> errors = new ArrayList<>();
        validateName(name).ifPresent(errors::add);
        validatePhoneNumber(phoneNumber).ifPresent(errors::add);
        validateDuplicatePhoneNumber(phoneNumber).ifPresent(errors::add);
        return errors;

    }

    private Optional<Error> validateName(String name) {
        if (name == null || name.isEmpty()) {
            return Optional.of(new Error("Name", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return Optional.of(new Error("Phone Number", "Must not be empty"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<Error> validateDuplicatePhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            Optional<Contact> productOpt = contactDatabase.findByPhoneNumber(phoneNumber);
            if (productOpt.isPresent()) {
                return Optional.of(new Error("Phone Number", "Must not be repeated"));
            }
        }
        return Optional.empty();
    }



}
