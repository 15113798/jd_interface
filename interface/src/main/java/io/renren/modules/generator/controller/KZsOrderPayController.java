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

import io.renren.modules.generator.entity.KZsOrderPayEntity;
import io.renren.modules.generator.service.KZsOrderPayService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 订单表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-25 00:37:00
 */
@RestController
@RequestMapping("generator/kzsorderpay")
public class KZsOrderPayController {
    @Autowired
    private KZsOrderPayService kZsOrderPayService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:kzsorderpay:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = kZsOrderPayService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:kzsorderpay:info")
    public R info(@PathVariable("id") Integer id){
		KZsOrderPayEntity kZsOrderPay = kZsOrderPayService.getById(id);

        return R.ok().put("kZsOrderPay", kZsOrderPay);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:kzsorderpay:save")
    public R save(@RequestBody KZsOrderPayEntity kZsOrderPay){
		kZsOrderPayService.save(kZsOrderPay);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:kzsorderpay:update")
    public R update(@RequestBody KZsOrderPayEntity kZsOrderPay){
		kZsOrderPayService.updateById(kZsOrderPay);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:kzsorderpay:delete")
    public R delete(@RequestBody Integer[] ids){
		kZsOrderPayService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
