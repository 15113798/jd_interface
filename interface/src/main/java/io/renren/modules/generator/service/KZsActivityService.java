package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KZsActivityEntity;

import java.util.Map;

/**
 * 活动表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-25 01:30:10
 */
public interface KZsActivityService extends IService<KZsActivityEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

