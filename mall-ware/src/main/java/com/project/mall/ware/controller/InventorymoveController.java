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

import com.project.mall.ware.entity.InventorymoveEntity;
import com.project.mall.ware.service.InventorymoveService;
import com.project.common.utils.PageUtils;
import com.project.common.utils.R;



/**
 * 
 *
 * @author cutewr
 * @email cutewr2003@gmail.com
 * @date 2024-06-14 13:21:04
 */
@RestController
@RequestMapping("ware/inventorymove")
public class InventorymoveController {
    @Autowired
    private InventorymoveService inventorymoveService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:inventorymove:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = inventorymoveService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{inventorymoveid}")
    //@RequiresPermissions("ware:inventorymove:info")
    public R info(@PathVariable("inventorymoveid") Long inventorymoveid){
		InventorymoveEntity inventorymove = inventorymoveService.getById(inventorymoveid);

        return R.ok().put("inventorymove", inventorymove);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:inventorymove:save")
    public R save(@RequestBody InventorymoveEntity inventorymove){
		inventorymoveService.save(inventorymove);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:inventorymove:update")
    public R update(@RequestBody InventorymoveEntity inventorymove){
		inventorymoveService.updateById(inventorymove);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:inventorymove:delete")
    public R delete(@RequestBody Long[] inventorymoveids){
		inventorymoveService.removeByIds(Arrays.asList(inventorymoveids));

        return R.ok();
    }

}
