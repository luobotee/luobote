package com.java.securityauthserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.securityauthserver.entity.User;
import com.java.securityauthserver.mapper.UserMapper;
import com.java.securityauthserver.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author luozhong
 * @since 2021-06-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
