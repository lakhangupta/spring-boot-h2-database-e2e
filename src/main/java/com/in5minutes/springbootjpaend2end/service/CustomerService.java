package com.in5minutes.springbootjpaend2end.service;

import com.in5minutes.springbootjpaend2end.entity.Customer;
import com.in5minutes.springbootjpaend2end.model.CustomerData;

import java.util.List;

public interface CustomerService {
    public CustomerData saveCustomer(CustomerData customer);
    public boolean deleteCustomer(Long customerId);

    public List< CustomerData > getAllCustomers();

    public CustomerData getCustomerById(Long customerId);


}
