package com.example.demo.spring0413.ex5_7;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public interface MessageBean { void sayHello(String name); }