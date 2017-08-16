package cn.meijunjie.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackTest {

    private static final Logger logger = LoggerFactory.getLogger(LogBackTest.class);

    public static void main(String[] args)
    {
        logger.info("logback 成功le");
        logger.error("dsdsd");
        logger.debug("dsdsd");
    }
}
