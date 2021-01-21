package pl.bartekficek.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartekficek.tx.entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {
}
