package com.thangnv.booking.repository;

import com.thangnv.booking.entity.BookingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingSessionRepository extends JpaRepository<BookingSession, Long> {

    @Query(value = " SELECT bs.* FROM " +
            " ( " +
            " SELECT bs.* FROM booking_session bs WHERE bs.active = true AND bs.from_time < :toTime AND bs.to_time > :toTime" +
            " UNION " +
            " SELECT bs.* FROM booking_session bs WHERE bs.active = true AND bs.from_time < :fromTime AND bs.to_time > :fromTime " +
            " UNION " +
            " SELECT bs.* FROM booking_session bs WHERE bs.active = true AND bs.from_time = :fromTime " +
            " UNION " +
            " SELECT bs.* FROM booking_session bs WHERE bs.active = true AND bs.to_time = :to_time " +
            " ) bs " +
            " ORDER BY bs.from_time ",
            nativeQuery = true)
    List<BookingSession> findAllByTimeRange(@Param("fromTime") Date fromTime, @Param("toTime") Date toTime);
}
