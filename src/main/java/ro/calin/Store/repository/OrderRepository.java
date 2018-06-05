package ro.calin.Store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.calin.Store.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
