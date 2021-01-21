package pl.bartekficek.tx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.bartekficek.tx.entity.PassengerInfo;
import pl.bartekficek.tx.entity.PaymentInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;

    private PaymentInfo paymentInfo;

}
