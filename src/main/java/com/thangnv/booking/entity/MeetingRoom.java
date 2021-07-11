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

    @Column(name = "has_display_device")
    private Boolean hasDisplayDevice;

    @Column(name = "active")
    private Boolean active;

    public Boolean getHasDisplayDevice() {
        return hasDisplayDevice;
    }

    public void setHasDisplayDevice(Boolean hasDisplayDevice) {
        this.hasDisplayDevice = hasDisplayDevice;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
