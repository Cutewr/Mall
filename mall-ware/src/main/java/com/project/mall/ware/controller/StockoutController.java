package com.project.mall.ware.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.mall.ware.entity.StockoutEntity;
import com.project.mall.ware.service.StockoutService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.R;



/**
 * 
 *
 * @author cutewr
 * @email cutewr2003@gmail.com
 * @date 2024-06-14 13:21:05
 */
@RestController
@RequestMapping("ware/stockout")
public class StockoutController {
    @Autowired
    private StockoutService stockoutService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:stockout:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stockoutService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{stockoutid}")
    //@RequiresPermissions("ware:stockout:info")
    public R info(@PathVariable("stockoutid") Long stockoutid){
		StockoutEntity stockout = stockoutService.getById(stockoutid);

        return R.ok().put("stockout", stockout);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:stockout:save")
    public R save(@RequestBody StockoutEntity stockout){
		stockoutService.save(stockout);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:stockout:update")
    public R update(@RequestBody StockoutEntity stockout){
		stockoutService.updateById(stockout);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:stockout:delete")
    public R delete(@RequestBody Long[] stockoutids){
		stockoutService.removeByIds(Arrays.asList(stockoutids));

        return R.ok();
    }

}
