package com.example.demo.spring0413.ex5_7;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("default")
public class MessageBeanKo implements MessageBean, DisposableBean, InitializingBean {
    public void sayHello(String name) {
    System.out.println("안녕하세요," + name);
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy()실행");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet()실행");
    }
}