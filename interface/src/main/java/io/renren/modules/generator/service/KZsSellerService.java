package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KZsSellerEntity;

import java.util.Map;

/**
 * 卖家表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-03 22:01:07
 */
public interface KZsSellerService extends IService<KZsSellerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

