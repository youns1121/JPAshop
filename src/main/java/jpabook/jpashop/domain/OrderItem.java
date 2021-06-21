package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @Column(name = "order_item_name")
    private String name;        // imsi

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; //주문 가격
    private int count; //주문 수량

    //queryDSL 테스트
    @Builder
    public OrderItem(Long id, String name, Item item, Order order, int orderPrice, int count) {
        this.id = id;
        this.name = name;
        this.item = item;
        this.order = order;
        this.orderPrice = orderPrice;
        this.count = count;
    }




    //==생서 매서드==//
    public static OrderItem createOrderItem(Item item, int orderPrice, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

    //==비즈니스 로직==//
    public void cancel() {
        getItem().addStock(count);
    }

    //==조회 로직==//

    /**
     * 주문상품 전체 가격 조회
     */
    public int getTotaPrice() {
        return getOrderPrice() * getCount();
    }
}
