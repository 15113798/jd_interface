package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.KZsGoodsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-06-02 22:09:51
 */
@Mapper
public interface KZsGoodsDao extends BaseMapper<KZsGoodsEntity> {
	
}
