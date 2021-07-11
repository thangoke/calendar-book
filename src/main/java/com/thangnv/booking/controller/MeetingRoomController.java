package com.thangnv.booking.controller;

import com.thangnv.booking.dto.MeetingRoomDTO;
import com.thangnv.booking.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/meeting-room")
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @GetMapping("/list-all-meeting-room")
    List<MeetingRoomDTO> listAllMeetingRoom() {
        return meetingRoomService.listAllMeetingRoom();
    }
}
