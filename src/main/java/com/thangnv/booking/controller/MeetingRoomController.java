package com.thangnv.booking.controller;

import com.thangnv.booking.controller.exception.DataNotFoundException;
import com.thangnv.booking.dto.MeetingRoomDTO;
import com.thangnv.booking.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    MeetingRoomDTO getById(@RequestParam Long id) {
        MeetingRoomDTO result = meetingRoomService.getMeetingRoomById(id);
        if (result == null) {
            throw new DataNotFoundException(String.format("Meeting room not found, id = [%s]", id));
        }

        return result;
    }

    @PostMapping("/add")
    MeetingRoomDTO addMeetingRoom(@RequestBody MeetingRoomDTO dto) {
        return meetingRoomService.addMeetingRoom(dto);
    }

    @PutMapping("/modify")
    MeetingRoomDTO modifyMeetingRoom(@RequestBody MeetingRoomDTO dto) {
        return meetingRoomService.modifyMeetingRoom(dto);
    }

    @DeleteMapping("/delete")
    void deleteMeetingRoom(@RequestParam Long id) {
        meetingRoomService.deleteMeetingRoom(id);
    }
}
