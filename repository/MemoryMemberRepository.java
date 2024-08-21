package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //store는 변수이다. 즉 A a = new A와 같은 형태
    private static long sequence = 0L;

    @Override
    public Member save(Member member) { // MemberRepository를 구현하기에 생성자를 만듬
        member.setId(++sequence); //member의 아이디를 전치연산자를 이용해 1 2 3 등으로 선언
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // id가 null이라면 옵셔널을 붙여서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))// 람다식(getname이 name과 같은지 확인) true인 경우만 반환
                //,filter = 스트림에서 조건에 맞는 요소만 남기고 나머지를 제거하는 중간 연산
                .findAny(); // 옵셔널을 반환함 즉 벨류가 널일수도 있고 아닐수도 있기에 사용(널인경우 옵셔널을 사용하여 반환)
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
