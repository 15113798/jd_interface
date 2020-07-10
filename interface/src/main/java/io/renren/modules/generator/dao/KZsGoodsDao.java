package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.KZsGoodsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-07-09 17:40:10
 */
@Mapper
public interface KZsGoodsDao extends BaseMapper<KZsGoodsEntity> {
	
}
