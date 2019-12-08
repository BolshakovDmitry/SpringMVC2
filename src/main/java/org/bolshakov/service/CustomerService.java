package org.bolshakov.service;

import org.bolshakov.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    void saveCustomers(Customer theCustomer);

    Customer getCustomers(int theId);

    void deleteCustomer(int theId);
}
