package com.Springpro.Springpro.Service;


import com.Springpro.Springpro.Entity.Customer;
import com.Springpro.Springpro.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public Customer registerCustomer(Customer customer) {
        // يمكنك إجراء العمليات المطلوبة هنا لحفظ تفاصيل العميل الجديد في قاعدة البيانات
        // على سبيل المثال، يمكنك إضافة قواعد الصحة والتحقق من عدم تكرار اسم المستخدم
        // يمكنك تعيين قيمة افتراضية لحقل ID أو توليد قيمة فريدة جديدة
        customer.setId(0); // تعيين قيمة افتراضية للآن

        return customerRepo.save(customer);
    }

    public Customer loginCustomer(String username, String password) {
        // يمكنك إجراء العمليات المطلوبة هنا لتسجيل الدخول
        // يمكنك فحص اسم المستخدم وكلمة المرور في قاعدة البيانات
        // وإرجاع العميل إذا تطابقت المعلومات، وإلا يمكنك إرجاع قيمة null أو معالجة الخطأ بشكل مناسب
        return customerRepo.findByUsernameAndPassword(username, password);
    }
}