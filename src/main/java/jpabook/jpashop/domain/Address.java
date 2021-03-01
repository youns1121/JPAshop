package jpabook.jpashop.domain;


import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
public class Address {

    private String city; // 도시
    private String street; // 거리
    private String zipcode; // 우편번호

    protected Address() { //값 타입은 변경 불가능하게 설계 해야함
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
