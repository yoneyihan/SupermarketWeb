package com.hd.supermarket.error;

/**
 * @author 李金荣
 * @date 2018/11/1 16:50
 */
public class AppException extends RuntimeException {

    private int code;

    private String result;

    public AppException(int code, String result) {
        this.code = code;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
