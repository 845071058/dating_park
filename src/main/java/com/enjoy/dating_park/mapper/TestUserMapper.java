package com.enjoy.dating_park.mapper;

import com.enjoy.dating_park.entity.TestUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hexian
 * @since 2020-09-24
 */
public interface TestUserMapper extends BaseMapper<TestUser> {
    TestUser findByUserId(@Param("userId") String userId);

    Boolean addUser(@Param("userId") String userId,@Param("userName") String userName);
//    Integer delUser(@Param("userId") String userId);

}
