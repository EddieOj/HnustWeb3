package com.lixna.sgninsys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lixna.sgninsys.common.R;
import com.lixna.sgninsys.entity.User;
import com.lixna.sgninsys.service.ClassService;
import com.lixna.sgninsys.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lixna
 * @since 2023-02-24
 */
@RestController
@RequestMapping("/sgninsys/user")
@Slf4j
@CrossOrigin
@Api(tags = "用户模块")
public class UserController {

    @Resource
    ClassService classService;
    @Resource
    UserService userService;
    //查询班级所有人数
    @ApiOperation(value = "根据班级Id查询所有成员")
    @GetMapping("/findAllByClassId/{classId}")
    public R listAllPeople(@ApiParam(name = "classId", value = "班级ID", required = true) @PathVariable Integer classId) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("class_id", classId);
        List<User> list = userService.list(wrapper);
        return R.ok().data("items", list);
    }

    //删除用户
    @ApiOperation(value = "根据用户ID删除用户")
    @GetMapping("/deleteUserById/{id}")
    public R deleteUserById(@ApiParam(name = "id", value = "用户ID", required = true) @PathVariable Integer id) {
        boolean isDeleted = userService.removeById(id);
        if (isDeleted) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}

