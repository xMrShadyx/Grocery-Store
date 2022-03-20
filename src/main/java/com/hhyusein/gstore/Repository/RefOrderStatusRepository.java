package com.hhyusein.gstore.Repository;

import com.hhyusein.gstore.model.RefOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefOrderStatusRepository extends JpaRepository<RefOrderStatus, Long> {
}
