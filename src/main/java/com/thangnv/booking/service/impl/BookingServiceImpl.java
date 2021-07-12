package com.thangnv.booking.service.impl;

import com.thangnv.booking.controller.exception.DataNotFoundException;
import com.thangnv.booking.controller.exception.MissingQueryParamException;
import com.thangnv.booking.dto.BookingRequestDTO;
import com.thangnv.booking.dto.BookingResponseDTO;
import com.thangnv.booking.entity.BookingSession;
import com.thangnv.booking.entity.MeetingRoom;
import com.thangnv.booking.repository.BookingSessionRepository;
import com.thangnv.booking.repository.MeetingRoomRepository;
import com.thangnv.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingSessionRepository bookingSessionRepository;

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    private BookingResponseDTO bookingSession2DTO(BookingSession bookingSession) {
        BookingResponseDTO dto = new BookingResponseDTO();
        dto.id = bookingSession.getId();
        dto.meetingRoomId = bookingSession.getMeetingRoom().getId();
        dto.fromTime = bookingSession.getFromTime();
        dto.toTime = bookingSession.getToTime();

        dto.numOfAttendance = bookingSession.getNumOfAttendance();
        dto.serveWater = bookingSession.getServeWater();
        dto.serveFastFood = bookingSession.getServeFastFood();
        dto.serveFruit = bookingSession.getServeFruit();

        dto.accessoryList = null;

        dto.active = bookingSession.getActive();

        return dto;
    }

    @Override
    public BookingResponseDTO book(BookingRequestDTO dto) {
        Objects.requireNonNull(dto);

        if (dto.meetingRoomId == null) {
            throw new MissingQueryParamException("Missing dto.meetingRoomId");
        }

        if (dto.fromTime == null) {
            throw new MissingQueryParamException("Missing dto.fromTime");
        }

        if (dto.toTime == null) {
            throw new MissingQueryParamException("Missing dto.toTime");
        }

        List<BookingSession> conflictBook = bookingSessionRepository.findAllByTimeRange(dto.fromTime, dto.toTime);

        if (conflictBook.size() > 0) {
            StringBuilder sb = new StringBuilder("This time range has already booked: ");
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            for (BookingSession bs : conflictBook) {
                sb.append(String.format(" [%s -> %s] ", sf.format(bs.getFromTime()), sf.format(bs.getToTime())));
            }

            throw new DataNotFoundException(sb.toString());

//            Instant min = null;
//            Instant max = null;
//
//            for (BookingSession bs : conflictBook) {
//                if (min == null) min = bs.getToTime();
//                if (max == null) max = bs.getFromTime();
//
//                if (min.compareTo(bs.getToTime()) > 0) {
//                    min = bs.getToTime();
//                }
//                if (max.compareTo(bs.getFromTime()) < 0) {
//                    max = bs.getFromTime();
//                }
//            }
//
//            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            throw new DataNotFoundException(String.format("This time range has already booked: [%s -> %s], or you can choose another time", sf.format(max), sf.format(min)));
        }

        if (dto.meetingRoomId == null) {
            throw new MissingQueryParamException("Missing dto.meetingRoomId");
        }

        Optional<MeetingRoom> optionalMeetingRoom = meetingRoomRepository.findById(dto.meetingRoomId);

        if (!optionalMeetingRoom.isPresent()) {
            throw new DataNotFoundException(String.format("Meeting room not found, id = [%s]", dto.meetingRoomId));
        }

        BookingSession bookingSession = new BookingSession();
        bookingSession.setActive(true);
        bookingSession.setMeetingRoom(optionalMeetingRoom.get());

        bookingSession.setFromTime(dto.fromTime);
        bookingSession.setToTime(dto.toTime);

        bookingSession.setNumOfAttendance(dto.numOfAttendance);
        bookingSession.setServeWater(dto.serveWater);
        bookingSession.setServeFastFood(dto.serveFastFood);
        bookingSession.setServeFruit(dto.serveFruit);

        return this.bookingSession2DTO(bookingSessionRepository.save(bookingSession));
    }

    @Override
    public BookingResponseDTO cancel(Long bookingId) {
        if (bookingId == null) {
            throw new MissingQueryParamException("Missing bookingId");
        }

        Optional<BookingSession> optionalBookingSession = bookingSessionRepository.findById(bookingId);

        if (!optionalBookingSession.isPresent()) {
            throw new DataNotFoundException(String.format("Booking session not found, id = [%s]", bookingId));
        }

        optionalBookingSession.get().setActive(false);

        return this.bookingSession2DTO(bookingSessionRepository.save(optionalBookingSession.get()));
    }
}
