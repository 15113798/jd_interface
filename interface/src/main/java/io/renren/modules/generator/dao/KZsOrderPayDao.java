package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.KZsOrderPayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-25 00:37:00
 */
@Mapper
public interface KZsOrderPayDao extends BaseMapper<KZsOrderPayEntity> {
	
}
