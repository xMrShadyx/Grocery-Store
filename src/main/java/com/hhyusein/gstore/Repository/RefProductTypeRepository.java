package com.hhyusein.gstore.Repository;

import com.hhyusein.gstore.model.RefProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefProductTypeRepository extends JpaRepository<RefProductType, Long> {
}
