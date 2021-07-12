package com.thangnv.booking.entity;

import javax.persistence.*;

@Entity
public class BookingAccessory {
    @EmbeddedId
    private BookingAccessoryKey id;

    @ManyToOne
    @MapsId("bookingSessionId")
    @JoinColumn(name = "booking_session_id")
    private BookingSession bookingSession;

    @ManyToOne
    @MapsId("accessoryId")
    @JoinColumn(name = "accessory_id")
    private Accessory accessory;

    private Boolean approved;

    public BookingSession getBookingSession() {
        return bookingSession;
    }

    public void setBookingSession(BookingSession bookingSession) {
        this.bookingSession = bookingSession;
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public void setAccessory(Accessory accessory) {
        this.accessory = accessory;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}