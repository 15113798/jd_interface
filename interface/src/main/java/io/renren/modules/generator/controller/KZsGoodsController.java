package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.KZsGoodsEntity;
import io.renren.modules.generator.service.KZsGoodsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 商品表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-07-09 17:40:10
 */
@RestController
@RequestMapping("generator/kzsgoods")
public class KZsGoodsController {
    @Autowired
    private KZsGoodsService kZsGoodsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kzsgoods:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kZsGoodsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kzsgoods:info")
    public R info(@PathVariable("id") Integer id){
		KZsGoodsEntity kZsGoods = kZsGoodsService.getById(id);

        return R.ok().put("kZsGoods", kZsGoods);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kzsgoods:save")
    public R save(@RequestBody KZsGoodsEntity kZsGoods){
		kZsGoodsService.save(kZsGoods);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kzsgoods:update")
    public R update(@RequestBody KZsGoodsEntity kZsGoods){
		kZsGoodsService.updateById(kZsGoods);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kzsgoods:delete")
    public R delete(@RequestBody Integer[] ids){
		kZsGoodsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
