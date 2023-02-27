package com.lixna.sgninsys.controller;


import com.lixna.sgninsys.common.R;
import com.lixna.sgninsys.entity.Class;
import com.lixna.sgninsys.entity.vo.ClassDto;
import com.lixna.sgninsys.service.ClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
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
    //新增班级
    @ApiOperation(value = "新增班级")
    @PostMapping("/save")
    public R save(@RequestBody ClassDto classDto){
        Class newClass = new Class();
        newClass.setClassCapacity(classDto.getClass_capacity());
        newClass.setClassName(classDto.getClass_name());
        newClass.setCreateId(classDto.getCreator());
        boolean isSaved = classService.save(newClass);
        if (isSaved){
            return R.ok();
        }else {
            return R.error();
        }
    }
}

