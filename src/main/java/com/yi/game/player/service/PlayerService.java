package com.yi.game.player.service;

import com.yi.game.player.handler.RegisterChecker;
import com.yi.game.player.handler.RegisterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerService {
    @Autowired
    private RegisterChecker checker;
    @Autowired
    private RegisterHandler registerHandler;
    public void register(String account, String password, String confirmPwd) {
        checker.checkRegister(account, password, confirmPwd);
        registerHandler.register(account, password);
    }
}
