package com.thangnv.booking.service.impl;

import com.thangnv.booking.dto.BookingRequestDTO;
import com.thangnv.booking.dto.BookingResponseDTO;
import com.thangnv.booking.repository.BookingSessionRepository;
import com.thangnv.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingSessionRepository bookingSessionRepository;

    @Override
    public BookingResponseDTO book(BookingRequestDTO dto) {
        return null;
    }

    @Override
    public void cancel(Long bookingId) {

    }
}
