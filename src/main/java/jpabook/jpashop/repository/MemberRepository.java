package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository // 스프링 빈으로 등록, JPA 예외를 스프링 기반 예외 변환
@RequiredArgsConstructor
public class MemberRepository { // 회원 리포지토리


//    @PersistenceContext // 엔티티 매니저( EntityManager ) 주입
    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    } //하나의 멤버 조회

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) // JPQL 사용 from의 대상은 엔티티
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
