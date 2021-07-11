package com.thangnv.booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeetingRoomDTO {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("room_name")
    public String roomName;

    @JsonProperty("has_display_device")
    public Boolean hasDisplayDevice;

    @JsonProperty("capacity")
    public Integer capacity;

    @JsonProperty("active")
    public Boolean active;
}
