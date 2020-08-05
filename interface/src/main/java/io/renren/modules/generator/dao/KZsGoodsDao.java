package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.KZsGoodsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-07-13 21:29:04
 */
@Mapper
public interface KZsGoodsDao extends BaseMapper<KZsGoodsEntity> {

     void batchSaveOrUpdate(List<KZsGoodsEntity> list);
	
}
