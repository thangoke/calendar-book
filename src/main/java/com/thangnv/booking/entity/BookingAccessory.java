package com.thangnv.booking.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BookingAccessory implements Serializable {
    @Column(name = "booking_session_id")
    Long bookingSessionId;

    @Column(name = "accessory_id")
    Long accessoryId;

    @Override
    public int hashCode() {
        return bookingSessionId.intValue() << 16 | accessoryId.intValue();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof BookingAccessory) && this.hashCode() == obj.hashCode();
    }
}