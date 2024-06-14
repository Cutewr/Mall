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

import com.project.mall.ware.entity.StockinEntity;
import com.project.mall.ware.service.StockinService;
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
@RequestMapping("ware/stockin")
public class StockinController {
    @Autowired
    private StockinService stockinService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:stockin:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stockinService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{stockinid}")
    //@RequiresPermissions("ware:stockin:info")
    public R info(@PathVariable("stockinid") Long stockinid){
		StockinEntity stockin = stockinService.getById(stockinid);

        return R.ok().put("stockin", stockin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:stockin:save")
    public R save(@RequestBody StockinEntity stockin){
		stockinService.save(stockin);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:stockin:update")
    public R update(@RequestBody StockinEntity stockin){
		stockinService.updateById(stockin);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:stockin:delete")
    public R delete(@RequestBody Long[] stockinids){
		stockinService.removeByIds(Arrays.asList(stockinids));

        return R.ok();
    }

}
