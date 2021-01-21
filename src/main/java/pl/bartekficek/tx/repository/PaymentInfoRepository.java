package pl.bartekficek.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartekficek.tx.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}
