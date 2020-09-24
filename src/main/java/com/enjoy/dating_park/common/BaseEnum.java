package com.enjoy.dating_park.common;

/**
 * @author cc  2020/4/9
 */
public enum BaseEnum {

    /**
     *后台处理成功
     */
    SUCCESS("后台处理成功！",200),
    /**
     *后台处理失败
     */
    FAILED( "操作失败", 500 ),

    VALIDATE_FAILED("参数检验失败", 404 ),

    UNAUTHORIZED("暂未登录或token已经过期", 401 ),

    FORBIDDEN("没有相关权限", 403 ),

    /**
     *资源没有找到
     */
    RESOURCE_NOT_FOUND("资源没有找到",101),
    /**
     * 数组越界了！
     */
    INDEX_OUT_BOUNDS("数组越界了！",102),
    /**
     * 系统错误，未知的错误
     */
    SYSTEM_ERROR("系统错误，未知的错误!",103),
    /**
     * 空指针错误
     */
    NULL_POINTER("空指针异常！",104),
    /**
     * IO异常
     */
    IO_EXCEPTION("IO异常！",105),
    /**
     * 未知的方法
     */
    NO_SUCH_METHOD("找不到方法，未知的方法",106),
    /**
     * 类型转换错误
     */
    CLASS_CAST("类型转换出错，请检查",107),
    /**
     * 文件未找到错误
     */
    FILE_NOT_FOUND("文件没有找到，请确认文件位置！",108),
    /**
     * 字符串转换数字异常
     */
    NUMBER_FORMAT("字符串转换数字出错了!",109),
    /**
     * 操作数据库错误
     */
    SQL_EXCEPTION("操作数据库出错了!",110),
    /**
     * 传递的参数出错了
     */
    ILLEGAL_ARGUMENT("传递的参数出错了！",111),
    /**
     * 堆栈溢出错误
     */
    STACK_OVERFLOW("栈溢出了！",112),
    /**
     * 用户未注册
     */
    USER_UNREGISTERED("用户未注册",113),
    /**
     * 用户已注册
     */
    USER_REGISTERED("用户已注册",114),
    /**
     * 用户名或密码错误
     */
    PASSWORD_ERROR("用户名或密码错误！",115),
    /**
     * 验证码发送失败
     */
    SEND_FAIL("验证码发送失败",116),
    /**
     * 缺少参数或值为空
     */
    PARAMETER_IS_NULL("缺少参数或值为空",117),
    /**
     * 参数不合法
     */
    PARAMETER_IS_WRONGFUL("参数不合法",118),
    /**
     * 无效的Token
     */
    INVALID_TOKEN("无效的Token",119),
    /**
     * 无操作权限
     */
    NO_OPERATION_AUTHORITY("无操作权限",120),
    /**
     * 自定义异常
     */
    CUSTOMIZE_EXCEPTION("自定义异常，请检查",121),
    /**
     * token过期了，请重新登录!
     */
    LOGIN_AGIN("token失效!",122),
    /**
     * 400错误
     */
    BAD_REQUEST("Bad Request!",400),
    /**
     * 405错误
     */
    METHOD_NOT_ALLOWED("Method Not Allowed! 有可能是接口类型错误！",405),
    /**
     * 500错误
     */
    INTERNAL_SERVER_ERROR("Internal Server Error",500),


    /**
     * 404错误拦截
     */
    NO_HANDLER("这个页面石沉大海了！接口没找到",404),


    /**
     * 數據重複錯誤 1401 ~ 1500
     */
    REPETITION( "添加信息已重复", 1400 ),
    GETTOKENFAILED( "调取微信接口获取token失败", 1401 ),


    /**
     * 數異常錯誤  1501 ~ 1600
     */
    REFRESHTOKENFAILED( "刷新token失败", 1501 ),
    GETWECHATUSERFAILED( "获取微信用户信息失败", 1502 ),
    CHECKTOKENFAILED( "token校验失败", 1503 ),
    EXSITCIRCLE( "已经存在同名圈子", 1504 ),
    SUPERTOKENFAILED( "获取全局token失败", 1505 ),

    LOGINFIALED( "登录失败", 1600 ),
    NOULLUSER( "没有找到该用户,请注册", 1601 ),
    ZHUCEFAILED( "注册失败", 1602 ),
    TOKENFAILED( "获取token失败", 1603 ),
    //
    ADDCIRCLEFAILED( "添加圈子失败", 1701 ),
    DELCOMMENT( "删除评论失败", 1702 ),
    ADDCOMMENT( "发表评论失败", 1703 ),
    ADDREPLY( "发表回复失败", 1704 ),
    DELREPLY( "删除回复失败", 1705 ),
    DELBLOG( "删除帖子失败", 1706 ),
    ISTOP( "是否置顶操作失败", 1707 ),
    ADDBLOG( "发帖失败", 1708 ),
    BANFAILED( "禁言操作失败", 1709 ),
    ADDCIRCLE( "加入圈子失败", 1710 ),
    DELUSERCIRCLE( "退出圈子失败", 1711 ),
    ADDMSGFAILED( "发送消息失败", 1712 ),
    DELMSGFAILED( "删除消息失败", 1713 ),
    CODEIMG( "不能上传带二维码的图片", 1714 ),
    SENSITIVE( "文字中存在敏感词", 1715 ),
    BLOGLIMIT( "今天已发帖", 1716 ),
    REINCIRCLE( "你已经加入了这个圈子", 1717 ),
    ISBAN( "抱歉，您已被圈主禁言,请联系圈主解禁", 1718 ),
    NOCIRCLE( "没有找到你所在的圈子", 1719 ),
    GETSIGNERROR( "获取签名失败", 1720 ),
    NOJIFEN( "积分不够,快去分享圈子吧~", 1721 ),
    NOVIPPROVE( "只有会员才能申请认证哦,快加入会员吧~", 1722 ),
    ADDPROVEFAILED( "申请认证失败", 1723 ),
    SUPERCIRCLELIMIT( "已经有够多的同类型圈子啦,请搜索后加入他们吧", 1724 ),
    SECONDPROVE( "您已经提交认证了,正在审核中。请勿反复提交", 1725 ),
    LITTLEOPENIDFAILED( "获取小程序用户信息失败", 1726 )
    ;

    private String msg;

    private int code;

    BaseEnum(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
