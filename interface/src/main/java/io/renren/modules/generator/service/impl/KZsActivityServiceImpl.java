package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KZsActivityDao;
import io.renren.modules.generator.entity.KZsActivityEntity;
import io.renren.modules.generator.service.KZsActivityService;


@Service("kZsActivityService")
public class KZsActivityServiceImpl extends ServiceImpl<KZsActivityDao, KZsActivityEntity> implements KZsActivityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KZsActivityEntity> page = this.page(
                new Query<KZsActivityEntity>().getPage(params),
                new QueryWrapper<KZsActivityEntity>()
        );

        return new PageUtils(page);
    }

}