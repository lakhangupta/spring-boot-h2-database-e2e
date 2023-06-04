package com.in5minutes.springbootjpaend2end.service;

import com.in5minutes.springbootjpaend2end.entity.Customer;
import com.in5minutes.springbootjpaend2end.model.CustomerData;
import com.in5minutes.springbootjpaend2end.repo.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("customerService")
public class DefaultCustomerService implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerData saveCustomer(CustomerData customer) {
        Customer customerModel = populateCustomerEntity(customer);
        return populateCustomerData(customerRepository.save(customerModel));
    }

    @Override
    public boolean deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }

    @Override
    public List<CustomerData> getAllCustomers() {
        List < CustomerData > customers = new ArrayList< >();
        List < Customer > customerList = customerRepository.findAll();
        customerList.forEach(customer -> {
                customers.add(populateCustomerData(customer));
        });
        return customers;
    }

    @Override
    public CustomerData getCustomerById(Long customerId) {
        return populateCustomerData(customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found")));
    }

    /**
     * Internal method to convert Customer JPA entity to the DTO object
     * for frontend data
     * @param customer
     * @return CustomerData
     */
    private CustomerData populateCustomerData(final Customer customer) {
        CustomerData customerData = new CustomerData();
        customerData.setId(customer.getId());
        customerData.setFirstName(customer.getFirstName());
        customerData.setLastName(customer.getLastName());
        customerData.setEmail(customer.getEmail());
        return customerData;
    }

    private Customer populateCustomerEntity(CustomerData customerData) {
        Customer customer = new Customer();
        customer.setFirstName(customerData.getFirstName());
        customer.setLastName(customerData.getLastName());
        customer.setEmail(customerData.getEmail());
        return customer;
    }
}
