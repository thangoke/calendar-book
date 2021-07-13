package com.thangnv.booking.initialize;

import com.thangnv.booking.entity.Accessory;
import com.thangnv.booking.entity.AccessoryType;
import com.thangnv.booking.entity.MeetingRoom;
import com.thangnv.booking.repository.AccessoryRepository;
import com.thangnv.booking.repository.AccessoryTypeRepository;
import com.thangnv.booking.repository.MeetingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInitData {

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    @Autowired
    AccessoryTypeRepository accessoryTypeRepository;

    @Autowired
    AccessoryRepository accessoryRepository;

    @PostConstruct
    private void initData() {

        // init meeting room
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setActive(true);
        meetingRoom.setRoomName("Hiphop meeting room");
        meetingRoom.setCapacity(99);
        meetingRoom.setHasDisplayDevice(true);
        meetingRoomRepository.save(meetingRoom);

        // init accessory type
        AccessoryType accessoryType = new AccessoryType();
        accessoryType.setCode("projector");
        accessoryType.setName("Projector");
        AccessoryType persistedProjector = accessoryTypeRepository.save(accessoryType);

        // init accessory type
        Accessory accessory = new Accessory();
        accessory.setCode("projector-01");
        accessory.setName("Projector 01");
        accessory.setAccessoryType(persistedProjector);
        accessoryRepository.save(accessory);

    }
}
