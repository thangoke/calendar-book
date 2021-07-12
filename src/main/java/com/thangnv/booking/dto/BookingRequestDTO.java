package com.thangnv.booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thangnv.booking.entity.BookingAccessory;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

public class BookingRequestDTO {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("meeting_room_id")
    public Long meetingRoomId;

    @JsonProperty("num_of_attendance")
    public Integer numOfAttendance;

    @JsonProperty("from_time")
    public Date fromTime;

    @JsonProperty("to_time")
    public Date toTime;

    @OneToMany(mappedBy = "bookingSession")
    public Set<BookingAccessory> bookedAccessoryList;

    @JsonProperty("serve_water")
    public Boolean serveWater;

    @JsonProperty("serve_fast_food")
    public Boolean serveFastFood;

    @JsonProperty("serve_fruit")
    public Boolean serveFruit;
}
