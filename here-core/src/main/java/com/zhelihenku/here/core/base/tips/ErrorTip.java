package com.zhelihenku.here.core.base.tips;

/**
 * 返回给前台的错误提示
 *
 * @author PhilWang
 * @date 2016年11月12日 下午5:05:22
 */
public class ErrorTip extends Tip {

    public ErrorTip(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
}
