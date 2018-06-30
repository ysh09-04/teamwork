package com.ssm.promotion.core.common;

import java.io.Serializable;

/**
 * 封装了一个结果返回值的格式
 * Created by 13 on 17/6/26.
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int resultCode;//返回值的编码
    private String message;//返回值的信息提示
    private T data;//返回值要带的数据

    public Result() {
    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data={" + data.toString() + "}" +
                '}';
    }

}
