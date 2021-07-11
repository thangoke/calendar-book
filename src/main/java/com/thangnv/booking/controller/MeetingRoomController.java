package com.thangnv.booking.controller;

import com.thangnv.booking.dto.MeetingRoomDTO;
import com.thangnv.booking.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController("/api/meeting-room")
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @GetMapping("/list-all")
    List<MeetingRoomDTO> listAllMeetingRoom() {
        return meetingRoomService.listAllMeetingRoom();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    MeetingRoomDTO listAllMeetingRoom(@RequestParam String id) {
        MeetingRoomDTO result = meetingRoomService.getMeetingRoomById(id);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Room does not exist");
        }

        return result;
    }
}
