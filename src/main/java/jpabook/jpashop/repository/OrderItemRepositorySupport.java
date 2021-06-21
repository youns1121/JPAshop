package jpabook.jpashop.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jpabook.jpashop.config.QuerydslConfiguration;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jpabook.jpashop.domain.QOrderItem.orderItem;

@Repository
public class OrderItemRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public OrderItemRepositorySupport(JPAQueryFactory jpaQueryFactory){
        super(OrderItem.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Order

        return jpaQueryFactory
                .selectFrom(orderItem)
                .where(orderItem.name.eq(name))
                .fetch();

    }

}
