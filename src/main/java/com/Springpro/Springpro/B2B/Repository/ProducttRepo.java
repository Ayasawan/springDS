package com.Springpro.Springpro.B2B.Repository;

import com.Springpro.Springpro.B2B.Entity.Productt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducttRepo extends JpaRepository<Productt, Integer> {
    // يمكنك إضافة طرق إضافية خاصة بالاستعلامات المخصصة هنا
    void deleteById(int id);
}