package com.bee.common.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;

/**
 * @author jiangjunqing
 * @date 2019/11/29
 * @desc
 */
public class BeeUUIDUtilTest {
    private static Logger logger = LoggerFactory.getLogger(BeeUUIDUtilTest.class);

    @Test
    public void get(){
        String s = BeeUUIDUtil.get();
        logger.info("s;{}", s);
    }



}
