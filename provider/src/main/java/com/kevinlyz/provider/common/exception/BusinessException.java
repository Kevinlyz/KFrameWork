package com.kevinlyz.provider.common.exception;

import com.alibaba.fastjson.JSON;
import com.kevinlyz.api.kevinapi.common.enums.ERspCode;
import com.kevinlyz.provider.common.result.entity.Error;
import lombok.NonNull;


/**
 * 业务异常
 *
 * @author kevinlyz
 * @version 1.0
 * @date 2020-02-26 15:18
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -3261592078317885053L;

    private Error error;

    public BusinessException(@NonNull ERspCode rspCode) {
        this(rspCode.code, rspCode.message, rspCode.userMessage);
    }

    public BusinessException(@NonNull ERspCode rspCode, String message) {
        this(rspCode.code, rspCode.message, message);
    }

    public BusinessException(@NonNull Error error) {
        super(JSON.toJSONString(error));
        this.error = error;
    }

    public BusinessException(@NonNull Integer returnCode, @NonNull String returnMessage, String returnUserMessage) {
        this(new Error(returnCode, returnMessage, returnUserMessage));
    }

    public Error getError() {
        return error;
    }
}
