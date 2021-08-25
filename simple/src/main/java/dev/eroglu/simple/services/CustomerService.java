package dev.eroglu.simple.services;

import dev.eroglu.simple.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer findCustomerById(Long id);
    List<Customer> findAllCustomers();
    void deleteCustomer(Long id);
    Customer saveCustomer(Customer customer);
}
