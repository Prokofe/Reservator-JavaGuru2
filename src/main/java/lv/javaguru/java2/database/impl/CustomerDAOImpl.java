package lv.javaguru.java2.database.impl;

import lv.javaguru.java2.database.CustomerDAO;
import lv.javaguru.java2.domain.Customer;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAOImpl extends ORMRepository
        implements CustomerDAO {

    @Override
    public Customer save(Customer customer) {
        session().save(customer);
        return (Customer) session().get(Customer.class, customer.getId());
    }

    @Override
    public Customer findByPhoneNumber(String phoneNumber) {
        return (Customer) session()
                .createCriteria(Customer.class)
                .add(Restrictions.eq("phoneNumber", phoneNumber))
                .uniqueResult();
    }
}
