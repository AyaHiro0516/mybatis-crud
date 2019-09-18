package cn.ayahiro.mybatis.entity;

import java.io.Serializable;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/18
 */
public class Result implements Serializable {

    //判断结果
    private boolean success;
    //返回信息
    private String message;

    public Result() {
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}