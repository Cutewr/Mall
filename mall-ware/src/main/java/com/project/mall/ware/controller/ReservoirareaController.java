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

import com.project.mall.ware.entity.ReservoirareaEntity;
import com.project.mall.ware.service.ReservoirareaService;
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
@RequestMapping("ware/reservoirarea")
public class ReservoirareaController {
    @Autowired
    private ReservoirareaService reservoirareaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:reservoirarea:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = reservoirareaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{reservoirareaid}")
    //@RequiresPermissions("ware:reservoirarea:info")
    public R info(@PathVariable("reservoirareaid") Long reservoirareaid){
		ReservoirareaEntity reservoirarea = reservoirareaService.getById(reservoirareaid);

        return R.ok().put("reservoirarea", reservoirarea);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:reservoirarea:save")
    public R save(@RequestBody ReservoirareaEntity reservoirarea){
		reservoirareaService.save(reservoirarea);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:reservoirarea:update")
    public R update(@RequestBody ReservoirareaEntity reservoirarea){
		reservoirareaService.updateById(reservoirarea);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:reservoirarea:delete")
    public R delete(@RequestBody Long[] reservoirareaids){
		reservoirareaService.removeByIds(Arrays.asList(reservoirareaids));

        return R.ok();
    }

}
