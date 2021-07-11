package com.thangnv.booking.service.impl;

import com.thangnv.booking.dto.MeetingRoomDTO;
import com.thangnv.booking.entity.MeetingRoom;
import com.thangnv.booking.repository.MeetingRoomRepository;
import com.thangnv.booking.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    private MeetingRoomDTO meetingRoom2DTO(MeetingRoom meetingRoom) {
        MeetingRoomDTO dto = new MeetingRoomDTO();
        dto.id = meetingRoom.getId();
        dto.roomName = meetingRoom.getRoomName();
        dto.capacity = meetingRoom.getCapacity();
        dto.hasDisplayDevice = meetingRoom.getHasDisplayDevice();
        dto.active = meetingRoom.getActive();

        return dto;
    }

    @Override
    public List<MeetingRoomDTO> listAllMeetingRoom() {
        List<MeetingRoom> meetingRoomList = meetingRoomRepository.findAll();

        List<MeetingRoomDTO> result = new ArrayList<>();

        for (MeetingRoom meetingRoom : meetingRoomList) {
            result.add(this.meetingRoom2DTO(meetingRoom));
        }

        return result;
    }

    @Override
    public MeetingRoomDTO getMeetingRoomById(String id) {
        Optional<MeetingRoom> optionalMeetingRoom = meetingRoomRepository.findById(id);
        return optionalMeetingRoom.map(this::meetingRoom2DTO).orElse(null);
    }
}
