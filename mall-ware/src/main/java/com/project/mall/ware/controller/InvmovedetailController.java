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

import com.project.mall.ware.entity.InvmovedetailEntity;
import com.project.mall.ware.service.InvmovedetailService;
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
@RequestMapping("ware/invmovedetail")
public class InvmovedetailController {
    @Autowired
    private InvmovedetailService invmovedetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("ware:invmovedetail:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = invmovedetailService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{movedetailid}")
    //@RequiresPermissions("ware:invmovedetail:info")
    public R info(@PathVariable("movedetailid") Long movedetailid){
		InvmovedetailEntity invmovedetail = invmovedetailService.getById(movedetailid);

        return R.ok().put("invmovedetail", invmovedetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("ware:invmovedetail:save")
    public R save(@RequestBody InvmovedetailEntity invmovedetail){
		invmovedetailService.save(invmovedetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:invmovedetail:update")
    public R update(@RequestBody InvmovedetailEntity invmovedetail){
		invmovedetailService.updateById(invmovedetail);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("ware:invmovedetail:delete")
    public R delete(@RequestBody Long[] movedetailids){
		invmovedetailService.removeByIds(Arrays.asList(movedetailids));

        return R.ok();
    }

}
