package com.in5minutes.springbootjpaend2end.controller;


import com.in5minutes.springbootjpaend2end.model.CustomerData;
import com.in5minutes.springbootjpaend2end.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerData> getCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     * Method to get the customer data based on the ID.
     * @param id
     * @return CustomerData
     */
    @GetMapping("/customer/{id}")
    public CustomerData getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    /**
     * Post request to create customer information int the system.
     * @param customerData
     * @return
     */
    @PostMapping("/customer")
    public CustomerData saveCustomer(final @RequestBody CustomerData customerData) {
        return customerService.saveCustomer(customerData);
    }

    /**
     * <p>Delete customer from the system based on the ID. The method mapping is like the getCustomer with difference of
     * @DeleteMapping and @GetMapping</p>
     * @param id
     * @return
     */
    @DeleteMapping("/customer/{id}")
    public Boolean deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }


}
