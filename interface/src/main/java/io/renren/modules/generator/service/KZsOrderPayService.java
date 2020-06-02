package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KZsOrderPayEntity;

import java.util.Map;

/**
 * 订单表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-25 00:37:00
 */
public interface KZsOrderPayService extends IService<KZsOrderPayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

