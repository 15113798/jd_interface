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

import io.renren.modules.generator.entity.KZsSellerEntity;
import io.renren.modules.generator.service.KZsSellerService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 卖家表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-05-03 22:01:07
 */
@RestController
@RequestMapping("generator/kzsseller")
public class KZsSellerController {
    @Autowired
    private KZsSellerService kZsSellerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kzsseller:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kZsSellerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kzsseller:info")
    public R info(@PathVariable("id") Integer id){
		KZsSellerEntity kZsSeller = kZsSellerService.getById(id);

        return R.ok().put("kZsSeller", kZsSeller);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kzsseller:save")
    public R save(@RequestBody KZsSellerEntity kZsSeller){
		kZsSellerService.save(kZsSeller);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kzsseller:update")
    public R update(@RequestBody KZsSellerEntity kZsSeller){
		kZsSellerService.updateById(kZsSeller);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kzsseller:delete")
    public R delete(@RequestBody Integer[] ids){
		kZsSellerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
