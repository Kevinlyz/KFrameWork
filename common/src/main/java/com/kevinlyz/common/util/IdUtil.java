package com.kevinlyz.common.util;

import java.util.UUID;

/**
 * Id工具
 * 
 * @author kevinlyz
 * @version 1.0
 * @date 2020-02-26 19:47
 */
public class IdUtil {


    /**
     * 生成id
     *
     * @return
     */
    public static String getId() {
        return getUuid();
    }

    /**
     * 获取uuid
     *
     * @return
     */
    private static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
