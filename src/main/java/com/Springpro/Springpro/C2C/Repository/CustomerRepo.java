package com.Springpro.Springpro.C2C.Repository;


import com.Springpro.Springpro.C2C.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    // يمكنك إضافة طرق إضافية خاصة بالاستعلامات المخصصة هنا
    void deleteById(int id);

    Customer findByUsername(String username);

    Customer findByEmail(String email);
}
