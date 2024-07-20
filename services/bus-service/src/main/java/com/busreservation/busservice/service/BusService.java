package com.busreservation.busservice.service;

import com.busreservation.busservice.dto.BusRequest;
import com.busreservation.busservice.model.Bus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.List;

public interface BusService {
    List<Bus> searchBus(String source, String destination, Timestamp busArrivalTime);

    List<Bus> searchBuses(String route, String departureTime);

    Bus getBusById(Long busId);

    List<Bus> getAllBus();

    Bus addBus(BusRequest busRequest);
}