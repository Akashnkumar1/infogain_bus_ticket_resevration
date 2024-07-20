package com.busreservation.busservice.service;
import com.busreservation.busservice.dto.BusRequest;
import com.busreservation.busservice.model.Bus;
import com.busreservation.busservice.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    /**
     * @param source
     * @param destination
     * @param busArrivalTime
     * @return
     */
    @Override
    public List<Bus> searchBus(String source, String destination, Timestamp busArrivalTime) {
        return busRepository.findBySourceAndDestinationAndBusArrivalTime(source, destination, busArrivalTime);
    }

    @Override
    public List<Bus> searchBuses(String route, String departureTime) {
        return busRepository.findByRouteAndBusDepartureTime(route, Timestamp.valueOf(departureTime));
    }

    /**
     * @param busId
     * @return
     */
    @Override
    public Bus getBusById(Long busId) {
        return busRepository.findById(busId).orElseThrow(() -> new RuntimeException("Bus not found"));
    }
    /**
     * @return
     */
    @Override
    public List<Bus> getAllBus() {
        return null;
    }

    /**
     * @param busRequest
     * @return
     */
    @Override
    public Bus addBus(BusRequest busRequest) {
        Bus newBus = Bus.builder().
                busName(STR."\{busRepository.count()}A")
                .busDepartureTime(Timestamp.valueOf(busRequest.getBusDepartureTime()))
                .busArrivalTime(Timestamp.valueOf(busRequest.getBusArrivalTime()))
                .busType(busRequest.getBusType())
                .source(busRequest.getSource())
                .destination(busRequest.getDestination())
                .build();
        return busRepository.save(newBus);
    }


}
