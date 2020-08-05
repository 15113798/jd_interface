package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.KZsSellerEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 卖家表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-07-10 12:14:26
 */
@Mapper
public interface KZsSellerDao extends BaseMapper<KZsSellerEntity> {

    void batchSaveOrUpdate(List<KZsSellerEntity> list);

}
