package com.java.demo.rpc.client;

import com.java.demo.rpc.common.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: XinyuTian
 * @Date: 2019/3/22
 */
public class Consumer {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        DemoService svc = (DemoService) context.getBean("demoService");
        int c = 0;
        while (c++ < 40) {
            String msg = svc.sayHello("Kevin Tian");
            System.out.println("Consumer ==> " + msg);
            Thread.sleep(100);
        }
        context.destroy();
    }
}
