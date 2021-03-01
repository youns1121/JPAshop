package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService { //상품 서비스, 상품 리포지토리에 단순히 위임만 하는 클래

    private final ItemRepository itemRepository;


    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }


    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item findItem = itemRepository.findOne(itemId);
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);

    }

    public Item findOne(Long itemId) { return itemRepository.findOne(itemId); }

    public List<Item> findItems() { return itemRepository.findALL(); }
}
