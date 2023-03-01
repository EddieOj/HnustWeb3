package com.lixna.sgninsys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lixna.sgninsys.common.R;
import com.lixna.sgninsys.entity.CheckinRec;
import com.lixna.sgninsys.service.CheckinRecService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lixna
 * @since 2023-02-24
 */
@RestController
@RequestMapping("/sgninsyseckin-rec")
public class CheckinRecController {

    @Resource
    CheckinRecService checkinRecService;

    @PostMapping("check")
    public R attendCheck(@Valid @RequestBody CheckinRec checkRec){
        checkinRecService.save(checkRec);
        return  R.ok();
    }

}