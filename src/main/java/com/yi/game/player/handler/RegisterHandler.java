package com.yi.game.player.handler;

import com.yi.game.player.dao.PlayerDAO;
import com.yi.rpc.log.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {
    @Autowired
    private PlayerDAO dao;

    public void register(String account, String password) {
        dao.saveAccount(account, password);
        LoggerUtil.info("注册新账号。account:{}, password:{}", account, password);
    }
}
