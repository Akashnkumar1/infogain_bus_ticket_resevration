package com.busreservation.bookingsservice.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bus_id")
    private Long busId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "booking_date")
    private String bookingDate;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "status")
    private String status;
}
