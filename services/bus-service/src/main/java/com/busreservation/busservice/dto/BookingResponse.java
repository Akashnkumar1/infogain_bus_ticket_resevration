package com.busreservation.busservice.dto;


import lombok.Data;

@Data
public class BookingResponse {
    private long bookingId;
    private String bookingStatus;
    private long busName;
    private long busType;
    private long source;
    private long destination;
    private long busDepartureTime;
    private long busArrivalTime;
    private long busFare;
}
