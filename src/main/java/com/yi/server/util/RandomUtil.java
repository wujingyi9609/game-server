package com.yi.server.util;

import java.util.Random;

public class RandomUtil {

    /**
     * @param from 包含
     * @param to 不包含
     */
    public static int randomInt(int from, int to) {
        Random random = new Random();
        return from + random.nextInt(to);
    }
}
