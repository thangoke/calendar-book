package com.thangnv.booking.service;

import com.thangnv.booking.dto.MeetingRoomDTO;

import java.util.List;

public interface MeetingRoomService {
    List<MeetingRoomDTO> listAllMeetingRoom();

    MeetingRoomDTO getMeetingRoomById(Long id);

    MeetingRoomDTO addMeetingRoom(MeetingRoomDTO dto);

    MeetingRoomDTO modifyMeetingRoom(MeetingRoomDTO dto);

    void deleteMeetingRoom(Long id);
}
