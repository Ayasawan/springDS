package com.Springpro.Springpro.B2B.Repository;

import com.Springpro.Springpro.B2B.Entity.ProdOrd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdOrdRepo extends JpaRepository<ProdOrd, Long> {
    // Add custom queries or additional methods if needed
}