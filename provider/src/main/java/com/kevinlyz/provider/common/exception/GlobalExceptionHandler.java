package com.kevinlyz.provider.common.exception;

import com.sun.corba.se.spi.orbutil.fsm.Guard;
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
    public static Guard.Result toStandardResult(Throwable throwable) {

        return null;
    }

}
