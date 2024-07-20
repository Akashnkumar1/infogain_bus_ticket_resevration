package com.busreservation.bookingsservice.controller;


import com.busreservation.bookingsservice.dto.BookingRequest;
import com.busreservation.bookingsservice.dto.BookingResponse;
import com.busreservation.bookingsservice.model.Booking;
import com.busreservation.bookingsservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping

    @GetMapping("/{busId}/availability")
    public ResponseEntity<List<Booking>> getAvailableSeats(@PathVariable Long busId) {
        return ResponseEntity.ok(bookingService.getAvailableSeats(busId));
    }

    @PostMapping ("/reserve")
    public ResponseEntity<Booking> reserveSeat(@RequestHeader("Authorization") String token, @RequestBody BookingRequest bookingRequest) {
        return ResponseEntity.ok(bookingService.reserveSeat(bookingRequest));
    }

    @GetMapping("/user")
    public ResponseEntity<List<Booking>> getUserBookings(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(bookingService.getUserBookings(token));
    }
}
