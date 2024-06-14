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

import com.project.mall.ware.entity.WarehouseEntity;
import com.project.mall.ware.service.WarehouseService;
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
@RequestMapping("ware/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:warehouse:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = warehouseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{warehouseid}")
    //@RequiresPermissions("ware:warehouse:info")
    public R info(@PathVariable("warehouseid") Long warehouseid){
		WarehouseEntity warehouse = warehouseService.getById(warehouseid);

        return R.ok().put("warehouse", warehouse);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:warehouse:save")
    public R save(@RequestBody WarehouseEntity warehouse){
		warehouseService.save(warehouse);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:warehouse:update")
    public R update(@RequestBody WarehouseEntity warehouse){
		warehouseService.updateById(warehouse);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:warehouse:delete")
    public R delete(@RequestBody Long[] warehouseids){
		warehouseService.removeByIds(Arrays.asList(warehouseids));

        return R.ok();
    }

}
