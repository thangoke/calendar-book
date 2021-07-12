package com.thangnv.booking.service;

import com.thangnv.booking.dto.BookingRequestDTO;
import com.thangnv.booking.dto.BookingResponseDTO;
import com.thangnv.booking.entity.BookingSession;

public interface BookingService {
    BookingResponseDTO book(BookingRequestDTO dto);

    BookingResponseDTO cancel(Long bookingId);
}
