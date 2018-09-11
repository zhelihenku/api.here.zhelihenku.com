package com.zhelihenku.here.rest.common.util;

public class Result {

    private int code = 0;
    private String message = "ok";
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result getResult(RestScrviceExceptionEunm exceptionEunm) {

        Result result = new Result();
        result.setCode(exceptionEunm.getCode());
        result.setMessage(exceptionEunm.getMessage());
        result.setData(new Object());

        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
