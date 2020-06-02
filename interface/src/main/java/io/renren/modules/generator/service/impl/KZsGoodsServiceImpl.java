package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KZsGoodsDao;
import io.renren.modules.generator.entity.KZsGoodsEntity;
import io.renren.modules.generator.service.KZsGoodsService;


@Service("kZsGoodsService")
public class KZsGoodsServiceImpl extends ServiceImpl<KZsGoodsDao, KZsGoodsEntity> implements KZsGoodsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KZsGoodsEntity> page = this.page(
                new Query<KZsGoodsEntity>().getPage(params),
                new QueryWrapper<KZsGoodsEntity>()
        );

        return new PageUtils(page);
    }

}