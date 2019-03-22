package com.java.demo.rpc.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Description: 加载spring配置
 *
 * @Author: XinyuTian
 * @Date: 2019/3/22
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();
        System.in.read(); // 按任意键退出
    }
}
