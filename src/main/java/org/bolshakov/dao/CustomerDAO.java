package org.bolshakov.dao;

import org.bolshakov.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomers(int theId);

    void deleteCustomer(int theId);
}
