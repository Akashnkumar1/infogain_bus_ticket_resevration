package com.busreservation.bookingsservice.service;

import com.busreservation.bookingsservice.dto.BookingRequest;
import com.busreservation.bookingsservice.dto.BookingResponse;
import com.busreservation.bookingsservice.model.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookingService {

//    ResponseEntity<BookingResponse> getBooking(String bookingId);
//    ResponseEntity<BookingResponse> createBooking(BookingRequest bookingRequest);

    List<Booking> getAvailableSeats(Long busId);

    Booking reserveSeat(BookingRequest bookingRequest);

    List<Booking> getUserBookings(String token);
}
