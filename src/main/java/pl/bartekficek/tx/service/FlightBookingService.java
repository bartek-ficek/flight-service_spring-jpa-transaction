package pl.bartekficek.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bartekficek.tx.dto.FlightBookingAcknowledgement;
import pl.bartekficek.tx.dto.FlightBookingRequest;
import pl.bartekficek.tx.entity.PassengerInfo;
import pl.bartekficek.tx.entity.PaymentInfo;
import pl.bartekficek.tx.repository.PassengerInfoRepository;
import pl.bartekficek.tx.repository.PaymentInfoRepository;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    public FlightBookingAcknowledgement bookFlightTicket (FlightBookingRequest request) {
        FlightBookingAcknowledgement acknowledgement = null;

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
    }

}
