package com.yi.rpc.serializer.impl;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test() {
        logger.error("error msg {}", "dummy", new IllegalArgumentException("IllegalArgumentException"));
        logger.info("info...");
    }

}
