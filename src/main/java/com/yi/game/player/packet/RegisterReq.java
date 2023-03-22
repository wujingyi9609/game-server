package com.yi.game.player.packet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterReq {
    /**
     * 注册
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 确认密码
     */
    private String confirmPwd;
}
