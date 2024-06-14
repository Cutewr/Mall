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

import com.project.mall.ware.entity.StoragerackEntity;
import com.project.mall.ware.service.StoragerackService;
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
@RequestMapping("ware/storagerack")
public class StoragerackController {
    @Autowired
    private StoragerackService storagerackService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:storagerack:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = storagerackService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{storagerackid}")
    //@RequiresPermissions("ware:storagerack:info")
    public R info(@PathVariable("storagerackid") Long storagerackid){
		StoragerackEntity storagerack = storagerackService.getById(storagerackid);

        return R.ok().put("storagerack", storagerack);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:storagerack:save")
    public R save(@RequestBody StoragerackEntity storagerack){
		storagerackService.save(storagerack);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:storagerack:update")
    public R update(@RequestBody StoragerackEntity storagerack){
		storagerackService.updateById(storagerack);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:storagerack:delete")
    public R delete(@RequestBody Long[] storagerackids){
		storagerackService.removeByIds(Arrays.asList(storagerackids));

        return R.ok();
    }

}
