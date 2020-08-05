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

import io.renren.modules.generator.entity.KZsContactsEntity;
import io.renren.modules.generator.service.KZsContactsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-08-03 18:51:27
 */
@RestController
@RequestMapping("generator/kzscontacts")
public class KZsContactsController {
    @Autowired
    private KZsContactsService kZsContactsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kzscontacts:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kZsContactsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kzscontacts:info")
    public R info(@PathVariable("id") Integer id){
		KZsContactsEntity kZsContacts = kZsContactsService.getById(id);

        return R.ok().put("kZsContacts", kZsContacts);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kzscontacts:save")
    public R save(@RequestBody KZsContactsEntity kZsContacts){
		kZsContactsService.save(kZsContacts);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kzscontacts:update")
    public R update(@RequestBody KZsContactsEntity kZsContacts){
		kZsContactsService.updateById(kZsContacts);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kzscontacts:delete")
    public R delete(@RequestBody Integer[] ids){
		kZsContactsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
