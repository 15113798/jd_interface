package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KZsJdCookierDao;
import io.renren.modules.generator.entity.KZsJdCookierEntity;
import io.renren.modules.generator.service.KZsJdCookierService;


@Service("kZsJdCookierService")
public class KZsJdCookierServiceImpl extends ServiceImpl<KZsJdCookierDao, KZsJdCookierEntity> implements KZsJdCookierService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KZsJdCookierEntity> page = this.page(
                new Query<KZsJdCookierEntity>().getPage(params),
                new QueryWrapper<KZsJdCookierEntity>()
        );

        return new PageUtils(page);
    }

}