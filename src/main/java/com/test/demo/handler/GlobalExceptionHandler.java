package com.test.demo.handler;

import com.test.demo.entity.common.JsonResult;
import com.test.demo.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.OK;

/**
 * @author xujingjing
 * @date 2022/1/26
 * @apiNote
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger= LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * api异常处理
     * @param e
     * @return
     */
   @ExceptionHandler(ApiException.class)
   public ResponseEntity handlerApiException(ApiException e){
       logger.info("系统内部异常:"+e);
       return ResponseEntity.status(OK).body(JsonResult.error(e.getMessage()));
   }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handlerException(Exception e){
        logger.info("系统错误:"+e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("系统错误,请联系管理员!");
    }


}
