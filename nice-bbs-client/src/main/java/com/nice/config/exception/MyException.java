package com.nice.config.exception;

/**
 * 自定义异常
 *
 * @author nice
 */
public class MyException extends RuntimeException {

    public MyException(String code, String msg){
         this.code = code;
        this.msg = msg;
     }

     private String code;
    private String msg;

    public String getCode() {
        return code;
     }
    public void setCode(String code) {
        this.code = code;
     }

    public String getMsg() {
         return msg;
     }

     public void setMsg(String msg) {
         this.msg = msg;
     }


}
