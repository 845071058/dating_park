package com.enjoy.dating_park.common;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cc  2020/4/9
 */
@Data
public class Result<T> {
    private static final Logger log = LoggerFactory.getLogger(Result.class);

    /**
     * 返回状态码，200为正确，100为失败
     */
    private int code;

    /**
     * 返回处理信息，成功或者失败
     */
    private String msg;

    /**
     * 成功返回true，失败返回false
     */
    private Boolean success;

    private T data;

    /**
     * 返回给前端的数据
     */
    private Map<String, Object> extend = new HashMap<String ,Object>();


    protected Result() {
    }

    protected Result( boolean status, int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
        this.success = status;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>( true, BaseEnum.SUCCESS.getCode(), BaseEnum.SUCCESS.getMsg(), data );
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> Result<T> success(T data, String message) {
        return new Result<T>( true, BaseEnum.SUCCESS.getCode(), message, data );
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> Result<T> failed(BaseEnum errorCode) {
        return new Result<T>( false, errorCode.getCode(), errorCode.getMsg(), null );
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> Result<T> failed( String message) {
        return new Result<T>( false, BaseEnum.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> Result<T> failed() {
        return failed( BaseEnum.FAILED );
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> Result<T> validateFailed() {
        return failed( BaseEnum.VALIDATE_FAILED );
    }


    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> Result<T> validateFailed(String message) {
        return new Result<T>( false, BaseEnum.VALIDATE_FAILED.getCode(), message, null );
    }

    /**
     * 未登录返回结果
     */
    public static <T> Result<T> unauthorized(T data) {
        return new Result<T>( false, BaseEnum.UNAUTHORIZED.getCode(), BaseEnum.UNAUTHORIZED.getMsg(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> Result<T> forbidden(T data) {
        return new Result<T>( false, BaseEnum.FORBIDDEN.getCode(), BaseEnum.FORBIDDEN.getMsg(), data);
    }


    /**
     * 成功返回的json封装体
     * @param value 原始数据
     * @return json格式
     */
    public static Result successJson(Object value){
        Result results = new Result();
        results.setCode( BaseEnum.SUCCESS.getCode() );
        results.setMsg( BaseEnum.SUCCESS.getMsg() );
        results.setSuccess(true);
        results.getExtend().put( "data",value );
        return results;
    }

    /**
     * 失败返回的json封装体
     * @return json格式
     */
    public static Result errorJson(){
        Result results = new Result();
        results.setCode( BaseEnum.FAILED.getCode() );
        results.setSuccess(false);
        results.setMsg( BaseEnum.FAILED.getMsg());
        return results;
    }

    /**
     * 失败返回的json封装体
     * @return json格式
     */
    public static Result errorJson(String msg){
        Result results = new Result();
        results.setCode( BaseEnum.FAILED.getCode() );
        results.setSuccess(false);
        results.setMsg(msg);
        return results;
    }

    public static Result errorJson( BaseEnum baseEnum ){
        Result results = new Result();
//        log.info( "----getIndex={}", baseEnum.getIndex() );
        results.setCode( baseEnum.getCode() );
        results.setSuccess(false);
        results.setMsg( baseEnum.getMsg() );
        return results;
    }

    /**
     * 失败返回的json封装体
     * @return json格式
     */
    public static Result errorJson(String msg,Integer code){
        Result results = new Result();
        results.setCode(code);
        results.setSuccess(false);
        results.setMsg(msg);
        return results;
    }

}
