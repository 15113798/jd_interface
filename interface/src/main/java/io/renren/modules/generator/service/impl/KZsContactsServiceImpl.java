package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KZsContactsDao;
import io.renren.modules.generator.entity.KZsContactsEntity;
import io.renren.modules.generator.service.KZsContactsService;


@Service("kZsContactsService")
public class KZsContactsServiceImpl extends ServiceImpl<KZsContactsDao, KZsContactsEntity> implements KZsContactsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KZsContactsEntity> page = this.page(
                new Query<KZsContactsEntity>().getPage(params),
                new QueryWrapper<KZsContactsEntity>()
        );

        return new PageUtils(page);
    }

}