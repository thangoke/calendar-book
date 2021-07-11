package com.thangnv.booking.entity;

import com.thangnv.booking.entity.audit.AuditableEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "meeting_room")
public class MeetingRoom extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
    private String id;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "has_display_device")
    private Boolean hasDisplayDevice;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "active")
    private Boolean active;

    public String getId() {
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
