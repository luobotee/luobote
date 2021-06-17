package com.java.firsttest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.firsttest.entity.Firtest;
import com.java.firsttest.mapper.FirtestMapper;
import com.java.firsttest.service.IFirtestService;
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
public class FirtestServiceImpl extends ServiceImpl<FirtestMapper, Firtest> implements IFirtestService {

}
