package com.thangnv.booking.entity;

import javax.persistence.*;

@Entity
public class BookingAccessory {
    @EmbeddedId
    private BookingAccessoryKey id;

    @ManyToOne
    @MapsId("bookingSessionId")
    @JoinColumn(name = "booking_session_id")
    private BookingAccessory bookingAccessory;

    @ManyToOne
    @MapsId("accessoryId")
    @JoinColumn(name = "accessory_id")
    private Accessory accessory;

    private Boolean approved;

    public BookingAccessory getBookingSession() {
        return bookingAccessory;
    }

    public void setBookingSession(BookingAccessory bookingAccessory) {
        this.bookingAccessory = bookingAccessory;
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