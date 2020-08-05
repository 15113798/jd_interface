package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.KZsContactsEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-08-03 18:51:27
 */
public interface KZsContactsService extends IService<KZsContactsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

