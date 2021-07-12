package com.thangnv.booking.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "booking_session")
public class BookingSession {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "sequence_name", value = "booking_session_seq")}
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_room_id", nullable = false)
    private MeetingRoom meetingRoom;

    @Column(name = "from_time", nullable = false)
    private Instant fromTime;

    @Column(name = "to_time", nullable = false)
    private Instant toTime;

    @Column(name = "num_of_attendance")
    private Integer numOfAttendance;

    @OneToMany(mappedBy = "bookingSession")
    private Set<BookingAccessory> bookedAccessoryList;

    @Column(name = "serve_water")
    private Boolean serveWater;

    @Column(name = "serve_fast_food")
    private Boolean serveFastFood;

    @Column(name = "serve_fruit")
    private Boolean serveFruit;

    @Column(name = "active")
    private Boolean active;

    public Long getId() {
        return id;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public Integer getNumOfAttendance() {
        return numOfAttendance;
    }

    public void setNumOfAttendance(Integer numOfAttendance) {
        this.numOfAttendance = numOfAttendance;
    }

    public Instant getFromTime() {
        return fromTime;
    }

    public void setFromTime(Instant fromTime) {
        this.fromTime = fromTime;
    }

    public Instant getToTime() {
        return toTime;
    }

    public void setToTime(Instant toTime) {
        this.toTime = toTime;
    }

    public Set<BookingAccessory> getBookedAccessoryList() {
        return bookedAccessoryList;
    }

    public void setBookedAccessoryList(Set<BookingAccessory> bookedAccessoryList) {
        this.bookedAccessoryList = bookedAccessoryList;
    }

    public Boolean getServeWater() {
        return serveWater;
    }

    public void setServeWater(Boolean serveWater) {
        this.serveWater = serveWater;
    }

    public Boolean getServeFastFood() {
        return serveFastFood;
    }

    public void setServeFastFood(Boolean serveFastFood) {
        this.serveFastFood = serveFastFood;
    }

    public Boolean getServeFruit() {
        return serveFruit;
    }

    public void setServeFruit(Boolean serveFruit) {
        this.serveFruit = serveFruit;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
