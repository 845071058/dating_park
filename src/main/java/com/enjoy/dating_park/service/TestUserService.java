package com.enjoy.dating_park.service;

import com.enjoy.dating_park.entity.TestUser;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
