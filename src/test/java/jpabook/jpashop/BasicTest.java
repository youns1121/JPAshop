package jpabook.jpashop;

import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.repository.OrderItemRepository;
import jpabook.jpashop.repository.OrderItemRepositorySupport;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicTest {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderItemRepositorySupport orderItemRepositorySupport;

    @After
    void tearDown() throws Exception{
        orderItemRepository.deleteAllInBatch();
    }


    @Test
    public void queryDSL_test() throws Exception{
        //given
        String name = "hello";


        //when
        List<OrderItem> result = orderItemRepositorySupport.findByName(name);

        //then



    }


    }

