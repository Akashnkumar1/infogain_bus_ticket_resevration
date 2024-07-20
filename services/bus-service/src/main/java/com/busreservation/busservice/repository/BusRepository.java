package com.busreservation.busservice.repository;

import com.busreservation.busservice.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface BusRepository extends JpaRepository<Bus, Long> {

    Optional<Bus> findById(Long id);
    List<Bus> findAllByRouteAndBusDepartureTime(String route, Timestamp busDepartureTime);

    List<Bus> findBySourceAndDestinationAndBusArrivalTime(String source, String destination, Timestamp busArrivalTime);

    List<Bus> findByRouteAndBusDepartureTime(String route, Timestamp timestamp);
}
