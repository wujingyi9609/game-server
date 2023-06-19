package com.yi.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerStarter {
    private static final RPCServer RPC_SERVER = new RPCServer();

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        applicationContext.start();
        RPC_SERVER.start();
        // todo wujingyi
        Thread.sleep(10000000L);
        RPC_SERVER.shutdown();
        applicationContext.stop();
    }
}
