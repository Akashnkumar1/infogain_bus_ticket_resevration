package com.busreservation.busservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "bus_name")
    private String busName;

    @Column(name = "route")
    private String route;

    @Column(name = "bus_type")
    private String busType;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "bus_departure_time")
    private Timestamp busDepartureTime;

    @Column(name = "bus_arrival_time")
    private Timestamp busArrivalTime;

}
