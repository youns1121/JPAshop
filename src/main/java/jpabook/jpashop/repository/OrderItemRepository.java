package jpabook.jpashop.repository;

import jpabook.jpashop.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    OrderItem findByName(String name);
}
