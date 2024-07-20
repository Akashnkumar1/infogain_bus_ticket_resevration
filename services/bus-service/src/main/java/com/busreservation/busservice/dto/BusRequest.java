package com.busreservation.busservice.dto;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class BusRequest {
    private String busType;
    private String source;
    private String destination;
    private String busArrivalTime;
    private String busDepartureTime;
}
