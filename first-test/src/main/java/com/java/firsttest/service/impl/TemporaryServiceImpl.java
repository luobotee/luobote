package com.java.firsttest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.firsttest.entity.Temporary;
import com.java.firsttest.mapper.TemporaryMapper;
import com.java.firsttest.service.ITemporaryService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TemporaryServiceImpl extends ServiceImpl<TemporaryMapper, Temporary> implements ITemporaryService {

    @Autowired
    TemporaryMapper temporaryMapper;

    public int create() {
        return temporaryMapper.CreateNewdate();
    }

}
