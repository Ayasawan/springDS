package com.Springpro.Springpro.Repository;


import com.Springpro.Springpro.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    // يمكنك إضافة طرق إضافية خاصة بالاستعلامات المخصصة هنا
    void deleteById(int id);

    Customer findByUsername(String username);

    Customer findByEmail(String email);
}
