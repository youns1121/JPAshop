package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {



    @NotEmpty(message = "이메일은 필수 입니다.")
    private String email;

    @NotEmpty(message = "패스워드 필수 입니다.")
    private String password;

    @NotEmpty(message = "회원 이름은 필수 입니다.") // 아무것도 입력 안하고 "Submit" 방지
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
