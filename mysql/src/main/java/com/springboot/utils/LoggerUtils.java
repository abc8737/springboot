package com.springboot.utils;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Created by YRP-Laptop on 2018/6/3.
 */
public class LoggerUtils {

    private Level level;
    private String loggerName;
    private String msgContent;

    public LoggerUtils() {
    }

    public LoggerUtils(Level level, String loggerName, String msgContent) {
        this.level = level;
        this.loggerName = loggerName;
        this.msgContent = msgContent;
    }

    public void loggerOutput() {
        Logger logger = Logger.getLogger(loggerName);
        LogRecord logRecord = new LogRecord(level, msgContent);
        logger.log(logRecord);
    }
}
