package com.thangnv.booking.service.impl;

import com.thangnv.booking.dto.MeetingRoomDTO;
import com.thangnv.booking.entity.MeetingRoom;
import com.thangnv.booking.repository.MeetingRoomRepository;
import com.thangnv.booking.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    @Override
    public List<MeetingRoomDTO> listAllMeetingRoom() {
        List<MeetingRoom> meetingRoomList = meetingRoomRepository.findAll();

        List<MeetingRoomDTO> result = new ArrayList<>();

        for (MeetingRoom meetingRoom : meetingRoomList) {
            MeetingRoomDTO dto = new MeetingRoomDTO();
            result.add(dto);
            dto.id = meetingRoom.getId();
            dto.roomName = meetingRoom.getRoomName();
            dto.capacity = meetingRoom.getCapacity();
            dto.hasDisplayDevice = meetingRoom.getHasDisplayDevice();
            dto.active = meetingRoom.getActive();
        }

        return result;
    }
}
