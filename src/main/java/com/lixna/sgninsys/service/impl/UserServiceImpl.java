package com.lixna.sgninsys.service.impl;

import com.lixna.sgninsys.entity.User;
import com.lixna.sgninsys.mapper.UserMapper;
import com.lixna.sgninsys.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lixna
 * @since 2023-02-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
