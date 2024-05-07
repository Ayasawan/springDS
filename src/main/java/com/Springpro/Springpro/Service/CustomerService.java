package com.Springpro.Springpro.Service;


import com.Springpro.Springpro.Entity.Customer;
import com.Springpro.Springpro.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService  {

    @Autowired
    private  CustomerRepo customerRepo;

    public Customer saveDetails(Customer customer){

        return customerRepo.save(customer);
    }
}