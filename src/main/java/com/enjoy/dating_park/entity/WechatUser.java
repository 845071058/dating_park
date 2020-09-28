package com.enjoy.dating_park.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hexian
 * @since 2020-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WechatUser extends Model<WechatUser> {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String openid;

    private String nickname;

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private String sex;

    private String province;

    private String city;

    private String country;

    private String headimgurl;

    private String myheadimgurl;

    private String unionid;

    private String myName;

    /**
     * 在系统中的电话
     */
    private String mobile;

    private String realProvince;

    private String realCity;

    private String realCountry;

    private String wechatId;

    private Integer realSex;

    private String realName;

    private String birthday;

    private Integer height;

    private Integer weight;

    /**
     * 星座
     */
    private String constellation;

    /**
     * 1:高中以下,2大专,3本科,4硕士,5:博士,6:博士以上
     */
    private Integer educate;

    /**
     * 星座
     */
    private String school;

    /**
     * 个人说明
     */
    private String introduceMe;

    /**
     * 剩余积分
     */
    private Integer systemIntegral;

    /**
     * 剩余积分
     */
    private Integer activityIntegral;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 分享人id
     */
    private String shareUserId;

    /**
     * 预留1
     */
    private String reserve1;

    /**
     * 预留2
     */
    private String reserve2;

    /**
     * 预留3
     */
    private String reserve3;

    /**
     * 预留4
     */
    private String reserve4;

    /**
     * 预留5
     */
    private String reserve5;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
