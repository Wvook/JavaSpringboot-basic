package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // save라는 메소드를 선언한 것 new Member와 다름(인스턴스 생성)
    // save라는 메서드를 호출할 때 Member(id,name)타입의 객체를 인수로 넘겨줘야함

    Optional<Member> findById(Long id); // 아이디로 회원을 찾는 걸 만드는 거, 아이디가 없으면 널이 반환될 수도 있기에 널을 옵셔널(옵션을 붙여)로 반환하기 위함
    Optional<Member> findByName(String name);
    List<Member> findAll(); //Member 객체의 정보를 리스트 형태로 저장한 뒤 찾게 하는 것
}
