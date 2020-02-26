package com.kevinlyz.api.kevinapi.common.util;


import com.kevinlyz.api.kevinapi.common.enums.ERspCode;
import com.kevinlyz.api.kevinapi.common.result.*;
import com.kevinlyz.api.kevinapi.common.result.Error;

import java.util.ArrayList;


/**
 * @author pasta
 * @date 2018/3/21
 */
@SuppressWarnings("unchecked")
public class ResultUtil {

    public static <T> Result<T> defaultSuccess() {
        return new SuccessResult(
                new Error(
                        ERspCode.SUCCESS.code,
                        ERspCode.SUCCESS.message
                )
        );
    }

    public static <T> Result<T> defaultEmptyArraySuccess() {
        return defaultSuccess(new ArrayList<>());
    }

    public static <T> Result<T> defaultSuccessMsg(String returnMessage) {
        return new SuccessResult(
                new Error(
                        ERspCode.SUCCESS.code,
                        returnMessage
                )
        );
    }

    public static <T> Result<T> defaultSuccess(Object retData) {
        return new SuccessResult(
                retData,
                new Error(
                        ERspCode.SUCCESS.code,
                        ERspCode.SUCCESS.message
                )
        );
    }

    public static <T> Result<T> defaultFailure(Error error) {
        return new FailureResult(error);
    }

    public static <T> Result<T> defaultFailure(String returnMessage) {
        return new FailureResult(
                new Error(
                        ERspCode.FAILURE.code,
                        returnMessage
                )
        );
    }

    public static <T> Result<T> defaultFailure(ERspCode code) {
        return new FailureResult(
                new Error(
                        code.code,
                        code.message
                )
        );
    }

    public static <T> Result<T> defaultFailure(ERspCode code, String returnMessage) {
        return new FailureResult(
                new Error(
                        code.code,
                        returnMessage
                )
        );
    }

    public static <T> Result<T> defaultFailure(ERspCode code, String returnMessage, String returnUserMessage) {
        return new FailureResult(
                new Error(
                        code.code,
                        returnMessage,
                        returnUserMessage
                )
        );
    }

    public static <T> Result<T> defaultFailure(int code, String returnMessage, String returnUserMessage) {
        return new FailureResult(
                new Error(
                        code,
                        returnMessage,
                        returnUserMessage
                )
        );
    }

    public static <T> Result<T> customResult(ERspCode code) {
        return new AbstractResult(
                new Error(
                        code.code,
                        code.message,
                        code.message
                )
        );
    }

    public static <T> Result<T> customResult(ERspCode code, Object data) {
        return new AbstractResult(
                data,
                new Error(
                        code.code,
                        code.message,
                        code.message
                )
        );
    }

    public static <T> Result<T> customResult(int code, String returnMessage, String returnUserMessage) {
        return new AbstractResult(
                new Error(
                        code,
                        returnMessage,
                        returnUserMessage
                )
        );
    }

    public static <T> Result<T> customResult(int code, String returnMessage, String returnUserMessage, Object data) {
        return new AbstractResult(
                data,
                new Error(
                        code,
                        returnMessage,
                        returnUserMessage
                )
        );
    }

    public static boolean checkSuccess(Result result) {
        try {
            return ERspCode.SUCCESS.code == result.getError().getReturnCode();
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean checkSuccessWithData(Result result) {
        try {
            return ERspCode.SUCCESS.code == result.getError().getReturnCode() && null != result.getData();
        } catch (Exception ex) {
            return false;
        }
    }

}
