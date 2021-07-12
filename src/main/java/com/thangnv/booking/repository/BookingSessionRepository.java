package com.thangnv.booking.repository;

import com.thangnv.booking.entity.BookingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface BookingSessionRepository extends JpaRepository<BookingSession, Long> {

    @Query(value = " SELECT bs.* FROM " +
            " ( " +
            " SELECT bs.* FROM booking_session bs WHERE bs.active = true AND bs.from_time < :toTime " +
            " UNION " +
            " SELECT bs.* FROM booking_session bs WHERE bs.active = true AND bs.to_time > :fromTime " +
            " ) bs " +
            " ORDER BY bs.from_time ",
            nativeQuery = true)
    List<BookingSession> findAllByTimeRange(@Param("fromTime") Instant fromTime, @Param("toTime") Instant toTime);
}
