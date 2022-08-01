package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  // 이 어노테이션이 생성될 수 있는 위치 지정, (Parameter로 했으니 메소드의 파라미터로 선언된 객체만 사용가능)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {   //이 파일을 어노테이션 클래스로 지정, LoginUser라는 어노테이션이 생성된것

}
