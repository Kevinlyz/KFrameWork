package com.kevinlyz.api.kevinapi.common.enums;

/**
 * 错误码
 *
 * @author kevinlyz
 * @version 1.0
 * @date 2019-12-22 23:06
 */
public enum ERspCode {
    SUCCESS(0, "SUCCESS", "处理成功！"),
    FAILURE(1, "FAILURE", "处理失败！"),
    PROCESS(2, "processing", "处理中！"),
    INVALID_PARAM(3, "param invalid!", "参数错误"),
    TOKEN_ERROR(4, "token exception", "token校验失败"),
    ERROR(999, "server busy", "服务繁忙！"),
    CONNECT_FAIL(51000, "", "连接失败"),
    DOWNLOAD_FAIL_FAIL(51001,"", "下载对象失败"),
    UPLOAD_FILE_FAIL(51002, "","上传对象失败"),
    ;

    public final int code;
    public final String message;
    public final String userMessage;

    ERspCode(int code, String message, String userMessage) {
        this.code = code;
        this.message = message;
        this.userMessage = userMessage;
    }

}
