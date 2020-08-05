package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.KZsActivityEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 活动表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-07-09 15:29:23
 */
@Mapper
public interface KZsActivityDao extends BaseMapper<KZsActivityEntity> {

    public void batchSaveOrUpdate(List<KZsActivityEntity> list);
	
}
