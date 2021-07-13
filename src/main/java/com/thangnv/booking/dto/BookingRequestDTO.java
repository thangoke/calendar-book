package com.thangnv.booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class BookingRequestDTO {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("meeting_room_id")
    public Long meetingRoomId;

    @JsonProperty("num_of_attendance")
    public Integer numOfAttendance;

    @JsonProperty("from_time")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    public String fromTime = "yyyy-MM-dd hh:mm:ss";

    @JsonProperty("to_time")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    public String toTime = "yyyy-MM-dd hh:mm:ss";

    @JsonProperty("accessory_list")
    public List<Long> accessoryList;

    @JsonProperty("serve_water")
    public Boolean serveWater;

    @JsonProperty("serve_fast_food")
    public Boolean serveFastFood;

    @JsonProperty("serve_fruit")
    public Boolean serveFruit;
}
