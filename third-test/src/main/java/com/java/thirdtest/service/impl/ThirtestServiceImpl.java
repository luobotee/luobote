package com.java.thirdtest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.thirdtest.entity.Thirtest;
import com.java.thirdtest.mapper.ThirtestMapper;
import com.java.thirdtest.service.IThirtestService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author luozhong
 * @since 2021-06-14
 */
@Service
public class ThirtestServiceImpl extends ServiceImpl<ThirtestMapper, Thirtest> implements IThirtestService {

}
