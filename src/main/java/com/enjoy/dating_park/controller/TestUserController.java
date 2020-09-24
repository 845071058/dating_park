package com.enjoy.dating_park.controller;


import com.enjoy.dating_park.common.Result;
import com.enjoy.dating_park.entity.TestUser;
import com.enjoy.dating_park.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hexian
 * @since 2020-09-24
 */
@RestController
@RequestMapping("/user")
public class TestUserController {

    @Autowired
    private TestUserService testUserService;

    @GetMapping("/test")
    public Result<TestUser> getTestUsers(){
        return Result.success(testUserService.getTestUsers());
    }
}
