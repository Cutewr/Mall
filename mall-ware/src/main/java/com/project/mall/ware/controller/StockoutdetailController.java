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

import com.project.mall.ware.entity.StockoutdetailEntity;
import com.project.mall.ware.service.StockoutdetailService;
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
@RequestMapping("ware/stockoutdetail")
public class StockoutdetailController {
    @Autowired
    private StockoutdetailService stockoutdetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:stockoutdetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stockoutdetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{stockoutdetailid}")
    //@RequiresPermissions("ware:stockoutdetail:info")
    public R info(@PathVariable("stockoutdetailid") Long stockoutdetailid){
		StockoutdetailEntity stockoutdetail = stockoutdetailService.getById(stockoutdetailid);

        return R.ok().put("stockoutdetail", stockoutdetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:stockoutdetail:save")
    public R save(@RequestBody StockoutdetailEntity stockoutdetail){
		stockoutdetailService.save(stockoutdetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:stockoutdetail:update")
    public R update(@RequestBody StockoutdetailEntity stockoutdetail){
		stockoutdetailService.updateById(stockoutdetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:stockoutdetail:delete")
    public R delete(@RequestBody Long[] stockoutdetailids){
		stockoutdetailService.removeByIds(Arrays.asList(stockoutdetailids));

        return R.ok();
    }

}
