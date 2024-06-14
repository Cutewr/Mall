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

import com.project.mall.ware.entity.MaterialEntity;
import com.project.mall.ware.service.MaterialService;
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
@RequestMapping("ware/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:material:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = materialService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{materialid}")
    //@RequiresPermissions("ware:material:info")
    public R info(@PathVariable("materialid") Long materialid){
		MaterialEntity material = materialService.getById(materialid);

        return R.ok().put("material", material);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:material:save")
    public R save(@RequestBody MaterialEntity material){
		materialService.save(material);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:material:update")
    public R update(@RequestBody MaterialEntity material){
		materialService.updateById(material);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:material:delete")
    public R delete(@RequestBody Long[] materialids){
		materialService.removeByIds(Arrays.asList(materialids));

        return R.ok();
    }

}
