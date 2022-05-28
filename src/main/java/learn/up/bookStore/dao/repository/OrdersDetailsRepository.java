package learn.up.bookStore.dao.repository;

import learn.up.bookStore.dao.entity.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDetailsRepository extends JpaRepository<OrdersDetails, Long> {
}
