package io.renren.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.KZsSellerDao;
import io.renren.modules.generator.entity.KZsSellerEntity;
import io.renren.modules.generator.service.KZsSellerService;


@Service("kZsSellerService")
public class KZsSellerServiceImpl extends ServiceImpl<KZsSellerDao, KZsSellerEntity> implements KZsSellerService {
    @Autowired
    private KZsSellerDao dao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<KZsSellerEntity> page = this.page(
                new Query<KZsSellerEntity>().getPage(params),
                new QueryWrapper<KZsSellerEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void batchSaveOrUpdate(List<KZsSellerEntity> list) {
        dao.batchSaveOrUpdate(list);
    }

}