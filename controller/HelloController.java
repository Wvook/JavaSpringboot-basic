package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello"; // hello.html에 리턴해준다는 뜻. 스프링부트는 디폴트로 resources/templates 밑에 있는 폴더를 찾아 랜더링함
    }

    @GetMapping("hello-mvc") // 도메인 http://localhost:8080/hello-mvc?name=spring!!!!!!
    public String helloMvc(@RequestParam("name") String name, Model model){ // 도메인에 name=spring하게 되면 입력한대로 Value가 바뀜
        model.addAttribute("name",name); // name은 spring으로 바뀜 그래서 hello-template.html에서 ${name} 부분에 spring이 들어가게됌
        return "hello-template";
    }

    @GetMapping("hello-string") // 얘 또한 http://localhost:8080/hello-string?name=spring!!!!!! 도메인을 이렇게 넣음
    @ResponseBody // html을 거쳐가지 않고 그대로 웹페이지에 매핑함. 그래서 html 코드가 없음
    public String hellostring(@RequestParam("name") String name){
        return "hello " + name; // http(통신 프로토콜의 헤더부, 바디부로 나뉨)의 바디부분에 직접 데이터를 넣겠다.
    }

    @GetMapping("hello-api")// http://localhost:8080/hello-api?name=spring!!!!!! <- 도메인
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){ //json방식 즉 객체를 반환하고 ResponseBody를 하면 JSON방식으로 된다.(디폴트셋팅)
        Hello hello = new Hello(); // 객체가 오면 디폴트로 JSON방식으로 만들어서 http응답에 반환함.
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
