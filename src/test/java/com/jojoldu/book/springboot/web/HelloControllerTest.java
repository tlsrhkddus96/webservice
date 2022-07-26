package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;




@RunWith(SpringRunner.class) // 스프링부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class) // Web(Spring MVC)에 집중할수 있는 어노테이션  @Controller 사용가능,
public class HelloControllerTest {

    @Autowired  //스프링이 관리하는 Bean 주입받음
    private MockMvc mvc;    // 웹API를 테스트할 때 사용, Http GET,POST등에 대한 API 테스트 가능

    @Test
    public void hello() throws Exception{

        String hello = "hello";

        mvc.perform(get("/hello"))   //MockMvc를 통해 /hello주소로 get요청
                .andExpect(status().isOk())   //mvc.perform의 결과를 검증 (200이 맞는지 아닌지 검증)
                .andExpect(content().string(hello));    //"hello"를 리턴하기 때문에 이 값이 맞는지 검증

    }

    @Test
    public void helloDTO() throws Exception{

        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))        // JSON 응답값을 필드별로 검증할 수 있는 메소드
                .andExpect(jsonPath("$.amount", is(amount)));   // $를 기준으로 필드명을 명시

    }


}
