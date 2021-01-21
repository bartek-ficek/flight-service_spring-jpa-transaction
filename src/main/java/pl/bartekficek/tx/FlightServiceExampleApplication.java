package pl.bartekficek.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.bartekficek.tx.dto.FlightBookingAcknowledgement;
import pl.bartekficek.tx.dto.FlightBookingRequest;
import pl.bartekficek.tx.service.FlightBookingService;

@SpringBootApplication
@RestController
public class FlightServiceExampleApplication {

    @Autowired
    private FlightBookingService service;

    @PostMapping("/bookFlightTicket")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
        return service.bookFlightTicket(request);
    }

    public static void main(String[] args) {
        SpringApplication.run(FlightServiceExampleApplication.class, args);
    }

}
