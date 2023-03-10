package com.yi.rpc;

import com.yi.rpc.server.RPCServer;

public class ServerStarter {
    private static final RPCServer RPC_SERVER = new RPCServer();

    public static void main(String[] args) throws InterruptedException {
        RPC_SERVER.start();
        Thread.sleep(1000000L);
        RPC_SERVER.shutdown();
    }
}
