package com.thangnv.booking.service;

import com.thangnv.booking.dto.BookingRequestDTO;
import com.thangnv.booking.dto.BookingResponseDTO;

public interface BookingService {
    BookingResponseDTO book(BookingRequestDTO dto);

    void cancel(Long bookingId);
}
