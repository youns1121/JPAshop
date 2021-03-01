package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){//상품 저장
        if(item.getId() == null) { //ID가 없으면 신규로 보고 persist()실행
            em.persist(item);
        }else{
           em.merge(item); //id 가 있으면 이미 데이터베이스에 저장된 엔티티를 수정한다고 보고, merge() 를 실행,->저장한스
        }
    }
    public Item findOne(Long id){ //한건 조회
        return em.find(Item.class, id);
    }

    public List<Item> findALL(){ // 전체 조회
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
