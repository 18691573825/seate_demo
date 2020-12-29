package cn.common.result;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author LLT
 * @Description: 结果集
 * @date: 2020/6/3
 */
@Getter
@Setter
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String message;
    private Object data;



    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public static Result sucess(){
        Result r = new Result(200,"操作成功");
        return r;
    }

    public static Result error(){
        Result r = new Result(500,"系统错误");
        return r;
    }
}
