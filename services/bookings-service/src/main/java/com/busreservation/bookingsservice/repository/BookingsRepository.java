package com.busreservation.bookingsservice.repository;

import com.busreservation.bookingsservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByBusId(Long busId);
    List<Booking> findByUserId(Long userId);
}
