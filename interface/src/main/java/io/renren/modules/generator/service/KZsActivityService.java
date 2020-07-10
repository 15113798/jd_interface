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
 * @date 2020-07-09 15:29:23
 */
public interface KZsActivityService extends IService<KZsActivityEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

