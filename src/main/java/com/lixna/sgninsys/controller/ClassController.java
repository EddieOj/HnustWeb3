package com.lixna.sgninsys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lixna.sgninsys.common.R;
import com.lixna.sgninsys.entity.Class;
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
 * 前端控制器
 * </p>
 *
 * @author lixna
 * @since 2023-02-24
 */
@RestController
@RequestMapping("/sgninsys/class")
@Slf4j
@CrossOrigin
@Api(tags = "班级模块")
public class ClassController {
    @Resource
    ClassService classService;
    @Resource
    UserService userService;

    //新增班级
    @ApiOperation(value = "新增班级")
    @PostMapping("/save")
    public R save(@RequestBody Class newClass) {
        boolean isSaved = classService.save(newClass);
        if (isSaved) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    //查询所有创建的课程或参加的课程
    @ApiOperation(value = "根据用户Id查询所有班级")
    @GetMapping("/findAllByUserId/{userId}")
    public R listAll(@ApiParam(name = "userId", value = "用户ID", required = true) @PathVariable Integer userId,
                     Integer tabIndex) {
        QueryWrapper<Class> wrapper = new QueryWrapper<>();
        if (tabIndex == 0) {
            wrapper.eq("create_id", userId);
            List<Class> list = classService.list(wrapper);
            return R.ok().data("items", list);
        } else {
            wrapper.eq("class_id", userService.getById(userId).getClassId());
            List<Class> list = classService.list(wrapper);
            return R.ok().data("items", list);
        }
    }

    //删除班级
    @ApiOperation(value = "根据班级ID删除班级")
    @GetMapping("/deleteClassById/{id}")
    public R deleteprojectById(@ApiParam(name = "id", value = "班级ID", required = true) @PathVariable Integer id) {
        boolean isDeleted = classService.removeById(id);
        if (isDeleted) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    //根据id查询，用于信息回显
    @ApiOperation(value = "根据id查询")
    @GetMapping("/getById/{id}")
    public R getById(@PathVariable Integer id) {
        Class newClass = classService.getById(id);
        return R.ok().data("item", newClass);
    }

    //修改班级
    @ApiOperation(value = "修改班级")
    @PostMapping("/updateById")
    public R updateById(@RequestBody Class newClass) {
        boolean flag = classService.updateById(newClass);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation(value = "退出班级")
    @GetMapping("/out/{userId}")
    public R quitClass(@ApiParam(name = "userId", value = "用户ID", required = true) @PathVariable Integer userId) {
        User user = userService.getById(userId);
        user.setClassId(-1);
        boolean isUpdated = userService.updateById(user);
        if (isUpdated) {
            return R.ok();
        } else {
            return R.error();
        }
    }

}

