package com.thangnv.booking.service.impl;

import com.thangnv.booking.controller.exception.DataNotFoundException;
import com.thangnv.booking.controller.exception.MissingQueryParamException;
import com.thangnv.booking.dto.MeetingRoomDTO;
import com.thangnv.booking.entity.MeetingRoom;
import com.thangnv.booking.repository.MeetingRoomRepository;
import com.thangnv.booking.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    public MeetingRoomDTO getMeetingRoomById(Long id) {
        Optional<MeetingRoom> optionalMeetingRoom = meetingRoomRepository.findById(id);
        return optionalMeetingRoom.map(this::meetingRoom2DTO).orElse(null);
    }

    @Override
    public MeetingRoomDTO addMeetingRoom(MeetingRoomDTO dto) {
        Objects.requireNonNull(dto);

        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setRoomName(dto.roomName);
        meetingRoom.setCapacity(dto.capacity);
        meetingRoom.setHasDisplayDevice(dto.hasDisplayDevice);
        meetingRoom.setActive(dto.active);

        MeetingRoom persisted = meetingRoomRepository.save(meetingRoom);
        return this.meetingRoom2DTO(persisted);
    }

    @Override
    public MeetingRoomDTO modifyMeetingRoom(MeetingRoomDTO dto) {
        Objects.requireNonNull(dto);

        if (dto.id == null) {
            throw new MissingQueryParamException("Missing dto.id");
        }

        Optional<MeetingRoom> optionalMeetingRoom = meetingRoomRepository.findById(dto.id);

        if (!optionalMeetingRoom.isPresent()) {
            throw new DataNotFoundException(String.format("Meeting room not found, id = [%s]", dto.id));
        }

        MeetingRoom meetingRoom = optionalMeetingRoom.get();
        meetingRoom.setRoomName(dto.roomName);
        meetingRoom.setCapacity(dto.capacity);
        meetingRoom.setHasDisplayDevice(dto.hasDisplayDevice);
        meetingRoom.setActive(dto.active);

        MeetingRoom persisted = meetingRoomRepository.save(meetingRoom);
        return this.meetingRoom2DTO(persisted);
    }

    @Override
    public void deleteMeetingRoom(Long id) {
        if (id == null) {
            throw new MissingQueryParamException("Missing id");
        }

        Optional<MeetingRoom> optionalMeetingRoom = meetingRoomRepository.findById(id);

        if (!optionalMeetingRoom.isPresent()) {
            throw new DataNotFoundException(String.format("Meeting room not found, id = [%s]", id));
        }

        meetingRoomRepository.delete(optionalMeetingRoom.get());
    }
}
