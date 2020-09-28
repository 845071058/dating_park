package com.enjoy.dating_park.service;

import com.enjoy.dating_park.common.Result;
import com.enjoy.dating_park.entity.TestUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hexian
 * @since 2020-09-24
 */
public interface TestUserService extends IService<TestUser> {

    TestUser getTestUsers();
    TestUser findByUserId(String userId);
    Boolean addUser(String userId,String userName);
    Integer delUser(String userId);
}
