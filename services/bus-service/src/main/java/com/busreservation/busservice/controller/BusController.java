package com.busreservation.busservice.controller;
import com.busreservation.busservice.dto.BusRequest;
import com.busreservation.busservice.model.Bus;
import com.busreservation.busservice.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/search")
    public ResponseEntity<List<Bus>> searchBus(String source, String destination, Timestamp busArrivalTime) {
        return ResponseEntity.ok(busService.searchBus(source, destination, busArrivalTime));
    }

    @GetMapping("/{busId}/schedule")
    public ResponseEntity<Bus> getBusSchedule(@PathVariable Long busId) {
        return ResponseEntity.ok(busService.getBusById(busId));
    }


    @GetMapping("/{busId}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long busId) {
        return ResponseEntity.ok(busService.getBusById(busId));
    }

    @PostMapping("/add")
    public ResponseEntity<Bus> addBus(@RequestBody BusRequest busRequest) {
        return ResponseEntity.ok(busService.addBus(busRequest));
    }

    @GetMapping("/searchBuses")
    public ResponseEntity<List<Bus>> searchBuses(@RequestParam String route, @RequestParam String departureTime) {
        return ResponseEntity.ok(busService.searchBuses(route, departureTime));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Bus>> getAllBus() {
        return ResponseEntity.ok(busService.getAllBus());
    }

}
