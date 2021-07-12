package com.thangnv.booking.controller;

import com.thangnv.booking.dto.BookingRequestDTO;
import com.thangnv.booking.dto.BookingResponseDTO;
import com.thangnv.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/book")
    BookingResponseDTO book(@RequestBody BookingRequestDTO dto) {
        return bookingService.book(dto);
    }

    @DeleteMapping("/cancel")
    void cancel(@RequestParam Long id) {
        bookingService.cancel(id);
    }
}
