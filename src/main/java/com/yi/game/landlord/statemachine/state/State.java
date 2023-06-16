package com.yi.game.landlord.statemachine.state;

import com.yi.game.landlord.statemachine.msg.LandlordMsg;

public interface State<E> {
    /**
     * 进入状态
     */
    void enter(E e);

    /**
     * 退出状态
     */
    void exit(E e);

    /**
     * 更新状态
     */
    void update(E e);

    /**
     * 处理消息
     */
    void onMessage(E e, LandlordMsg msg);
}
