package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Customer;

import java.util.List;

public interface CustomerBookDAO {

    List<Customer> findAll();
}
