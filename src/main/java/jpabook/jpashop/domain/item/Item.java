package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter

public abstract class Item { // 상속 매핑

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //==비즈니스 로직==/

    /**
     * *stock 증가
     */
    public void addStock(int quantity){ //addStock()메서드는 파라미터로 넘어온 수만큼 재고를 늘린다
        this.stockQuantity += quantity;
    }

    /**
     * *stock 감소
     */
    public void removeStock(int quantity){ // 메서드는 파라미터로 넘어온 수만큼 재고를 줄인다
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}




