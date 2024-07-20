package com.busreservation.bookingsservice.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingRequest {

    private Long busId;
    private Long userId;
    private String seatNumber;
}
