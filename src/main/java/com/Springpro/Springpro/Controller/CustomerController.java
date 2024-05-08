package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Entity.Customer;
import com.Springpro.Springpro.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

   @PostMapping("/addCustomer")
   public Customer addCustomer(@RequestBody Customer customer) {
       return customerService.addDetails(customer);
   }

    @PostMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateDetails(customer);
    }

    @PostMapping("/deleteCustomer")
    public void deleteCustomer(@RequestBody Customer customer) {
        customerService.deleteDetails(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/getProductById/{id}")
    public Optional<Customer> getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }



    @PostMapping("/registerC")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @PostMapping("/loginC")
    public Customer loginCustomer(@RequestBody Customer customer) {
        return customerService.loginCustomer(customer.getUsername(), customer.getPassword());
    }

}
