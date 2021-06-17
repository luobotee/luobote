package com.java.firsttest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.firsttest.entity.Temporary;
import org.apache.ibatis.annotations.Insert;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author luozhong
 * @since 2021-06-14
 */
public interface TemporaryMapper extends BaseMapper<Temporary> {

    @Insert("insert into tb_firtest select * from tb_temporary")
    int CreateNewdate();

}
