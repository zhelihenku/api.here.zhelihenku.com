package com.zhelihenku.here.core.exception;

/**
 * 封装here的异常
 *
 * @author PhilWang
 * @Date 2017/12/28 下午10:32
 */
public class HereException extends RuntimeException {

    private Integer code;

    private String message;

    public HereException(ServiceExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
