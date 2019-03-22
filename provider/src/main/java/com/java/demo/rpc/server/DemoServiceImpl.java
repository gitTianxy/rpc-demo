package com.java.demo.rpc.server;

import com.java.demo.rpc.common.DemoService;

/**
 * @Author: XinyuTian
 * @Date: 2019/3/22
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        String msg = "Hello, " + name;
        System.out.println("Provider ==> " + msg);
        return msg;
    }
}
