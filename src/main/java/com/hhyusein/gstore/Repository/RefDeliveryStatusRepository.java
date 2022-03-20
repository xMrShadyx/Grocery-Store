package com.hhyusein.gstore.Repository;

import com.hhyusein.gstore.model.RefDeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefDeliveryStatusRepository extends JpaRepository<RefDeliveryStatus, Long> {
}
