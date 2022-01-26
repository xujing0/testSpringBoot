package com.test.demo.exception;

/**
 * @author xujingjing
 * @date 2022/1/26
 * @apiNote
 */
public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
