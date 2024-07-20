package com.busreservation.bookingsservice.service;
import com.busreservation.bookingsservice.dto.BookingRequest;
import com.busreservation.bookingsservice.model.Booking;
import com.busreservation.bookingsservice.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingsRepository bookingRepository;

    /**
     * @param busId
     * @return
     */
    @Override
    public List<Booking> getAvailableSeats(Long busId) {
    return bookingRepository.findByBusId(busId).stream().filter(booking -> booking.getStatus().equals("AVAILABLE")).collect(Collectors.toList());
    }

    /**
     * @param bookingRequest
     * @return
     */
    @Override
    public Booking reserveSeat(BookingRequest bookingRequest) {
        Booking booking = Booking.builder().
                busId(bookingRequest.getBusId()).
                userId(bookingRequest.getUserId()).
                bookingDate(bookingRequest.getSeatNumber()).
                status("RESERVED").
                seatNumber(bookingRequest.getSeatNumber()).
                build();
        return bookingRepository.save(booking);
    }

    /**
     * @param token
     * @return
     */
    @Override
    public List<Booking> getUserBookings(String token) {
        return bookingRepository.findByUserId(Long.parseLong(token.split(":")[0]));
    }

}
