package hello.hello_spring.domain;

public class Member { //getter, setter를 만드는 이유는 private로 선언했기 때문이다. 보안때문에 id와 name을 직접 수저하지 못하게 하고
    // getter와 setter로 수정하기 위해서

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
