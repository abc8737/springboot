package yerenpeng.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * @Author: YeRenpeng
 * @e-mail: abc8737@163.com
 * @github: https://github.com/Liu-xingyu
 * @Date: 2018/11/24 21:37
 * @Version 1.0
 */
public class TestLog {

    private static Logger logger = Logger.getLogger(TestLog.class);

    private static String LOG_MSG = "的日志消息";

    private static String info, debug, warn, error, trace, fatal;

    public static void init() {
        info = "info";
        debug = "debug";
        warn = "warn";
        error = "error";
        trace = "trace";
        fatal = "fatal";
    }

    public static String info(String msgType) {
        return msgType + LOG_MSG;
    }

    public static void main(String[] args) {
        init();
        BasicConfigurator.configure();
        logger.info(info(info));
        logger.debug(info(debug));
        logger.warn(info(warn));
        logger.error(info(error));
        logger.trace(info(trace));
        logger.fatal(info(fatal));
    }

}
