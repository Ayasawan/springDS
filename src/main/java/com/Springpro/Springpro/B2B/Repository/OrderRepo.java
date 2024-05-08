package com.Springpro.Springpro.B2B.Repository;

import com.Springpro.Springpro.B2B.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByCompanyId(Long companyId);
}