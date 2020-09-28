package com.enjoy.dating_park.service.impl;

import com.enjoy.dating_park.entity.TestUser;
import com.enjoy.dating_park.mapper.TestUserMapper;
import com.enjoy.dating_park.service.TestUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hexian
 * @since 2020-09-24
 */
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements TestUserService {

    @Override
    public TestUser getTestUsers() {
        return baseMapper.selectById(1);
    }

    @Override
    public TestUser findByUserId(String userId) {
        return baseMapper.findByUserId(userId);
    }

    @Override
    public Boolean addUser(String userId, String userName) {

        return baseMapper.addUser(userId,userName);
    }

    @Override
    public Integer delUser(String userId) {
        return baseMapper.deleteById(userId);
    }
}
