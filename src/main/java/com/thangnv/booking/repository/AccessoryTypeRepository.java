package com.thangnv.booking.repository;

import com.thangnv.booking.entity.AccessoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoryTypeRepository extends JpaRepository<AccessoryType, String> {
}
