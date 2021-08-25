package dev.eroglu.simple.services;

import dev.eroglu.simple.domain.Customer;
import dev.eroglu.simple.repositories.CustomerRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRespository customerRespository;

    public CustomerServiceImpl(CustomerRespository customerRespository){
        this.customerRespository = customerRespository;
    }

    @Override
    public Customer findCustomerById(Long id){
        return customerRespository.findById(id).get();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRespository.findAll();
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRespository.delete(findCustomerById(id));
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRespository.save(customer);
    }
}
