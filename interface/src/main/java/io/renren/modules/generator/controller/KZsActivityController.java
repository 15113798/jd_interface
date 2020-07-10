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

import io.renren.modules.generator.entity.KZsActivityEntity;
import io.renren.modules.generator.service.KZsActivityService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 活动表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-07-09 15:29:23
 */
@RestController
@RequestMapping("generator/kzsactivity")
public class KZsActivityController {
    @Autowired
    private KZsActivityService kZsActivityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kzsactivity:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kZsActivityService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kzsactivity:info")
    public R info(@PathVariable("id") Integer id){
		KZsActivityEntity kZsActivity = kZsActivityService.getById(id);

        return R.ok().put("kZsActivity", kZsActivity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kzsactivity:save")
    public R save(@RequestBody KZsActivityEntity kZsActivity){
		kZsActivityService.save(kZsActivity);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kzsactivity:update")
    public R update(@RequestBody KZsActivityEntity kZsActivity){
		kZsActivityService.updateById(kZsActivity);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kzsactivity:delete")
    public R delete(@RequestBody Integer[] ids){
		kZsActivityService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
