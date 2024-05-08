package com.Springpro.Springpro.Controller;

import com.Springpro.Springpro.Entity.Customer;
import com.Springpro.Springpro.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getCustomerById/{id}")
    public Optional<Customer> getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }



    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Customer customer) {
        // يمكنك إجراء عمليات التحقق والتحقق من صحة بيانات التسجيل هنا

        if (customerService.isUsernameExists(customer.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("اسم المستخدم موجود بالفعل.");
        }

        if (customerService.isEmailExists(customer.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("البريد الإلكتروني موجود بالفعل.");
        }

        customerService.saveCustomer(customer);
        return ResponseEntity.ok("تم إنشاء حساب المستخدم بنجاح.");
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Customer customer) {
        // يمكنك إجراء عمليات التحقق والتحقق من صحة بيانات تسجيل الدخول هنا

        Customer authenticatedCustomer = customerService.authenticate(customer.getUsername(), customer.getPassword());
        if (authenticatedCustomer != null) {
            return ResponseEntity.ok("تم تسجيل الدخول بنجاح.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("فشل تسجيل الدخول.");
        }
    }

}
