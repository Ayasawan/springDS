package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Entity.Customer;
import com.Springpro.Springpro.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

   @PostMapping("/addCustomer")
   public Customer postDetails(@RequestBody Customer customer)
   {
       return customerService.saveDetails(customer);
   }

}
