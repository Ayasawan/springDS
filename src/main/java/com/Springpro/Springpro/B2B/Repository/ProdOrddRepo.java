package com.Springpro.Springpro.B2B.Repository;

import com.Springpro.Springpro.B2B.Entity.ProdOrdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdOrddRepo extends JpaRepository<ProdOrdd, Long> {
    // Add custom queries or additional methods if needed
    List<ProdOrdd> findByOrderId(Long orderId);
}