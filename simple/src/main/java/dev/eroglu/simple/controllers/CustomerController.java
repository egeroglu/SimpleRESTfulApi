package dev.eroglu.simple.controllers;

import dev.eroglu.simple.domain.Customer;
import dev.eroglu.simple.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getAllCustomers(){
        return customerService.findAllCustomers();
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.findCustomerById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{name}/{surName}")
    public Customer createPerson(@PathVariable String name,@PathVariable String surName){
        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setSurName(surName);
        return customerService.saveCustomer(newCustomer);
    }

    @GetMapping("/{id}/{name}/{surName}")
    public Customer uptadePerson(@PathVariable Long id, @PathVariable String name, @PathVariable String surName){
        customerService.findCustomerById(id).setName(name);
        customerService.findCustomerById(id).setSurName(surName);
        return customerService.saveCustomer(customerService.findCustomerById(id));
    }

    @GetMapping("/delete/{id}")
    public void deletePeople(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }

}
