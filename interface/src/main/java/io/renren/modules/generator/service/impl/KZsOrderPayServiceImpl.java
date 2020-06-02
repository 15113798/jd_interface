package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KZsOrderPayDao;
import io.renren.modules.generator.entity.KZsOrderPayEntity;
import io.renren.modules.generator.service.KZsOrderPayService;


@Service("kZsOrderPayService")
public class KZsOrderPayServiceImpl extends ServiceImpl<KZsOrderPayDao, KZsOrderPayEntity> implements KZsOrderPayService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KZsOrderPayEntity> page = this.page(
                new Query<KZsOrderPayEntity>().getPage(params),
                new QueryWrapper<KZsOrderPayEntity>()
        );

        return new PageUtils(page);
    }

}