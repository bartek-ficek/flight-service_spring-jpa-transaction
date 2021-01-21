package pl.bartekficek.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bartekficek.tx.dto.FlightBookingAcknowledgement;
import pl.bartekficek.tx.dto.FlightBookingRequest;
import pl.bartekficek.tx.entity.PassengerInfo;
import pl.bartekficek.tx.entity.PaymentInfo;
import pl.bartekficek.tx.repository.PassengerInfoRepository;
import pl.bartekficek.tx.repository.PaymentInfoRepository;
import pl.bartekficek.tx.utils.PaymentUtils;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    public FlightBookingAcknowledgement bookFlightTicket (FlightBookingRequest request) {
        FlightBookingAcknowledgement acknowledgement = null;

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);
    }
}
