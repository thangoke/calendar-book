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

import java.time.Instant;
import java.util.Date;
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
        dto.fromTime = Date.from(bookingSession.getFromTime());
        dto.toTime = Date.from(bookingSession.getToTime());

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

        List<BookingSession> conflictBook = bookingSessionRepository.findAllByTimeRange(dto.fromTime.toInstant(), dto.toTime.toInstant());

        if (conflictBook.size() > 0) {
            Instant min = null;
            Instant max = null;

            for (BookingSession bs : conflictBook) {
                if (min == null) min = bs.getToTime();
                if (max == null) max = bs.getFromTime();

                if (min.compareTo(bs.getToTime()) > 0) {
                    min = bs.getToTime();
                }
                if (max.compareTo(bs.getFromTime()) < 0) {
                    max = bs.getFromTime();
                }
            }

            throw new RuntimeException(String.format("This time range has already booked: From may be > %s, To may be < %s, or you can choose another time", min, max));
        }

        if (dto.meetingRoomId == null) {
            throw new MissingQueryParamException("Missing dto.meetingRoomId");
        }

        Optional<MeetingRoom> optionalMeetingRoom = meetingRoomRepository.findById(dto.meetingRoomId);

        if (!optionalMeetingRoom.isPresent()) {
            throw new DataNotFoundException(String.format("Meeting room not found, id = [%s]", dto.meetingRoomId));
        }

        BookingSession bookingSession = new BookingSession();
        bookingSession.setMeetingRoom(optionalMeetingRoom.get());

        bookingSession.setFromTime(dto.fromTime.toInstant());
        bookingSession.setToTime(dto.toTime.toInstant());

        return this.bookingSession2DTO(bookingSessionRepository.save(bookingSession));
    }

    @Override
    public void cancel(Long bookingId) {

    }
}
