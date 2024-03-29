package com.yi.server.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    public static void error(String log) {
        logger.error(log);
    }

    public static void error(String log, Object... args) {
        logger.error(log, args);
    }

    public static void info(String log, Object... params) {
        logger.info(log, params);
    }
}
