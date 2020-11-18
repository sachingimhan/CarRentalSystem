package lk.easycar.rental.repo;

import lk.easycar.rental.entity.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailRepo extends JpaRepository<PaymentDetail,Integer> {
}
