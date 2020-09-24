package com.enjoy.dating_park.common.exception;

import com.enjoy.dating_park.common.BaseEnum;
import com.enjoy.dating_park.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * CreateTime: 2019-9-27
 * ClassName: GlobalExceptionHandler
 * Describe:
 * 全局异常处理类，拦截controller  RestControllerAdvice此注解为ResponseBody和ControllerAdvice混合注解
 *
 * @author sean.Wan
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     *
     * 全局异常类中定义的异常都可以被拦截，只是触发条件不一样，如IO异常这种必须抛出异常到
     * controller中才可以被拦截，或者在类中用try..catch自己处理
     * 绝大部分不需要向上抛出异常即可被拦截，返回前端json数据，如数组下标越界，404 500 400等错误
     * 如果自己想要写，按着以下格式增加异常即可
     *HttpMessageNotReadableException
     */

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     *   启动应用后，被 @ExceptionHandler、@InitBinder、@ModelAttribute 注解的方法，
     *   都会作用在 被 @RequestMapping 注解的方法上。
     * @param binder 参数
     */
    @InitBinder
    public void initWebBinder(WebDataBinder binder){

    }

    /**
     * 系统错误，未知的错误   已测试
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler({Exception.class})
    public Result exception(Exception ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.SYSTEM_ERROR );
    }

    /**
     * 文件没有找到错误拦截   **要把错误信息抛出到controller层  已测试
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(FileNotFoundException.class)
    public Result fileNotFound(FileNotFoundException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.FILE_NOT_FOUND );
    }

    /**
     * 字符串转换为数字异常   已测试  不需要抛出到ccontroller即可被拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(NumberFormatException.class)
    public Result numberFormatEx(NumberFormatException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.NUMBER_FORMAT );
    }

    /**
     * sql操作数据库出错了
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(SQLException.class)
    public Result sqlException(SQLException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.SQL_EXCEPTION );
    }

    /**
     * 参数传递出错了
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result sqlException(IllegalArgumentException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.ILLEGAL_ARGUMENT );
    }

    /**
     * 栈溢出错误
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(StackOverflowError.class)
    public Result stackOverflow(StackOverflowError ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed(BaseEnum.STACK_OVERFLOW );
    }

    /**
     * 404错误拦截   已测试
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result noHandlerNotFound(NoHandlerFoundException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.NO_HANDLER );
    }

    /**
     * 400错误拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(TypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result request400(TypeMismatchException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.BAD_REQUEST );
    }

    /**
     * 400错误拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result request400(MissingServletRequestParameterException ex){
        log.error("错误详情：" + ex.getMessage(),ex );
        return Result.failed( BaseEnum.BAD_REQUEST.getMsg() + " 找不到传入的参数"  );
    }

    /**
     * 400错误拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result request400(HttpMessageNotReadableException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.BAD_REQUEST.getMsg() + " 可能缺少参数" );
    }

    /**
     * 405错误拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Result request405(HttpRequestMethodNotSupportedException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.METHOD_NOT_ALLOWED );
    }

    /**
     * 500错误拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result request500(RuntimeException ex){
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.INTERNAL_SERVER_ERROR );
    }

    /**
     * 类型转换异常   已经测试 可以拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(ClassCastException.class)
    public Result classCastExceptionHandler(ClassCastException ex) {
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.CLASS_CAST );
    }

    /**
     * 未知方法异常
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(NoSuchMethodException.class)
    public Result noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.NO_SUCH_METHOD.getMsg() );
    }

    /**
     * IO异常 需要抛出到Controller层可捕获到
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(IOException.class)
    public Result iOExceptionHandler(IOException ex) {
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.IO_EXCEPTION );
    }

    /**
     * 空指针异常  已测试  可以拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(NullPointerException.class)
    public Result nullPointerExceptionHandler(NullPointerException ex) {
        log.error("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.NULL_POINTER );
    }

    /**
     * 数组越界异常拦截   已测试
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Result indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex){
        log.warn("错误详情：" + ex.getMessage(),ex);
        return Result.failed( BaseEnum.INDEX_OUT_BOUNDS );
    }

    /**
     * 自定义异常信息拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(MyException.class)
    public Result myCustomizeException(MyException ex){
        log.warn("错误详情：" + ex);
        return Result.failed( BaseEnum.CUSTOMIZE_EXCEPTION );
    }

    /**
     * 服务异常信息拦截
     * @param ex 异常信息
     * @return 返回前端异常信息
     */
    @ExceptionHandler(ServiceException.class)
    public Result serviceException(ServiceException ex){
        log.error("错误详情："+ ex.getMessage(),ex);
        return Result.failed( ex.getMessage() );
    }

}
