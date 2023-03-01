package com.lixna.sgninsys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lixna.sgninsys.common.R;
import com.lixna.sgninsys.entity.*;
import com.lixna.sgninsys.service.LessonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.Query;
import javax.validation.Valid;
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
@RequestMapping("/sgninsys/lesson")
public class LessonController {
    @Resource
    LessonService lessonService;

    @GetMapping("/{id}")
    public R display(@Valid @PathVariable Integer id){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("lesson_creator_id",id);//相当于where id=1
        List list = lessonService.list(wrapper);
        return R.ok().data("list",list);
    }

    @PostMapping("/CreatLesson")
    public R Creat(@Valid @RequestBody Lesson lesson) {
        lessonService.save(lesson);
        return R.ok();
    }

}
