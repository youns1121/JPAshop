package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service //
@Transactional(readOnly = true) // 트랜잭션, 영속성 컨텍스트  => JPA 읽기전용 성능 최적화
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
    * 회원 가입
    */
    @Transactional //  쓰기엔 (readOnly = true) 할 경우 데이터 변경이 안됌
    public Long join(Member member){

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }

    }


    //회원 전체 조회

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }


    public Member findOne(Long memberId){ // 회원 단건 조회
        return memberRepository.findOne(memberId);
    }

}
