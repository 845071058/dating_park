package com.enjoy.dating_park.common.exception;

/**
* Describe:
* 自定义异常，可以throws的时候用自己的异常类
 * @author sean.Wan
 */
public class MyException extends RuntimeException{

    public MyException(String msg) {
        super(msg);
    }

    public MyException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public MyException(Throwable throwable) {
        super(throwable);
    }

}