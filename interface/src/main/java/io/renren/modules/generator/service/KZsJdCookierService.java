package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KZsJdCookierEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-08-03 18:38:04
 */
public interface KZsJdCookierService extends IService<KZsJdCookierEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

