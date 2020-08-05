package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KZsGoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-07-13 21:29:04
 */
public interface KZsGoodsService extends IService<KZsGoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void batchSaveOrUpdate(List<KZsGoodsEntity> list);
}

