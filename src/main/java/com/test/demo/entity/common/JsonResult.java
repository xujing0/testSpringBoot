package com.test.demo.entity.common;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author xujingjing
 * @date 2022/1/26
 * @apiNote
 */
public class JsonResult extends HashMap<String,Object> implements Serializable {

    private final static  Integer OK=200;
    private final static  Integer ERROR=200;
    private final static  String CODE="code";
    private final static  String MESSAGE="message";
    private final static  String DATA="data";


    public static JsonResult error(String message) {
        JsonResult result = new JsonResult();
        result.put(CODE,OK);
        result.put(MESSAGE,message);
        result.put(DATA,"");
        return result;
    }
}
