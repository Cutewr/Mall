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

import com.project.mall.ware.entity.StockindetailEntity;
import com.project.mall.ware.service.StockindetailService;
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
@RequestMapping("ware/stockindetail")
public class StockindetailController {
    @Autowired
    private StockindetailService stockindetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:stockindetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stockindetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{stockindetailid}")
    //@RequiresPermissions("ware:stockindetail:info")
    public R info(@PathVariable("stockindetailid") Long stockindetailid){
		StockindetailEntity stockindetail = stockindetailService.getById(stockindetailid);

        return R.ok().put("stockindetail", stockindetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:stockindetail:save")
    public R save(@RequestBody StockindetailEntity stockindetail){
		stockindetailService.save(stockindetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:stockindetail:update")
    public R update(@RequestBody StockindetailEntity stockindetail){
		stockindetailService.updateById(stockindetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:stockindetail:delete")
    public R delete(@RequestBody Long[] stockindetailids){
		stockindetailService.removeByIds(Arrays.asList(stockindetailids));

        return R.ok();
    }

}
