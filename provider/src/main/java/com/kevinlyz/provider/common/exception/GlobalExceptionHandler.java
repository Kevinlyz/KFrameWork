package com.kevinlyz.provider.common.exception;

import com.kevinlyz.api.kevinapi.common.enums.ERspCode;
import com.kevinlyz.api.kevinapi.common.result.Result;
import com.kevinlyz.api.kevinapi.common.result.Error;
import com.kevinlyz.api.kevinapi.common.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * Redis服务
 *
 * @author kevinlyz
 * @version 1.0
 * @date 2020-02-26 15:18
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public static Result toStandardResult(Throwable throwable) {

        Error error = new Error(ERspCode.ERROR.code, ERspCode.ERROR.message, ERspCode.ERROR.userMessage);


        if (throwable instanceof RuntimeException){
            log.error("occur runtime exception: ", throwable);
            return ResultUtil.defaultFailure(ERspCode.ERROR.code, ERspCode.ERROR.message,
                    ERspCode.ERROR.userMessage);
        }else{
            return ResultUtil.defaultFailure(error);
        }
    }

}
