package com.yi.rpc;

import com.yi.rpc.server.RPCServer;

public class ServerStarter {
    private static RPCServer rpcServer = new RPCServer();

    public static void main(String[] args) throws InterruptedException {
        rpcServer.start();
        Thread.sleep(1000000L);
        rpcServer.shutdown();
    }
}
