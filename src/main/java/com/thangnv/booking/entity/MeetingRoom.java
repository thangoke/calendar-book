package com.thangnv.booking.entity;

import com.thangnv.booking.entity.audit.AuditableEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "meeting_room")
public class MeetingRoom extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "sequence_name", value = "meeting_room_seq")}
    )
    private Long id;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "has_display_device")
    private Boolean hasDisplayDevice;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "active")
    private Boolean active;

    public Long getId() {
        return id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Boolean getHasDisplayDevice() {
        return hasDisplayDevice;
    }

    public void setHasDisplayDevice(Boolean hasDisplayDevice) {
        this.hasDisplayDevice = hasDisplayDevice;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
