package com.thangnv.booking.repository;

import com.thangnv.booking.entity.BookingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingSessionRepository extends JpaRepository<BookingSession, Long> {
}
