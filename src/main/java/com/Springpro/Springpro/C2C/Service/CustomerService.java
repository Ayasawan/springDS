package com.Springpro.Springpro.C2C.Service;


import com.Springpro.Springpro.C2C.Entity.Customer;
import com.Springpro.Springpro.C2C.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;
import java.util.Optional;

@Service
public class CustomerService  {

    @Autowired
    private  CustomerRepo customerRepo;

    public Customer addDetails(Customer customer){

        return customerRepo.save(customer);
    }

    public Customer updateDetails(Customer customer) {
        return customerRepo.save(customer);
    }

    public void deleteDetails(Customer customer) {
        customerRepo.delete(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerRepo.findById(id);
    }



    public Customer saveCustomer(Customer customer) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        return customerRepo.save(customer);
    }

    public Customer authenticate(String username, String password) {
        Customer customer = customerRepo.findByUsername(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (customer != null && passwordEncoder.matches(password, customer.getPassword())) {
            return customer;
        } else {
            return null;
        }
    }

    public boolean isUsernameExists(String username) {
        return customerRepo.findByUsername(username) != null;
    }

    public boolean isEmailExists(String email) {
        return customerRepo.findByEmail(email) != null;
    }
}