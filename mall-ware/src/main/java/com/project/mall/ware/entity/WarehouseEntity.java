package com.project.mall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author cutewr
 * @email cutewr2003@gmail.com
 * @date 2024-06-14 13:21:05
 */
@Data
@TableName("wms_warehouse")
public class WarehouseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long warehouseid;
	/**
	 * 仓库编号
	 */
	private String warehouseno;
	/**
	 * 仓库名称
	 */
	private String warehousename;
	/**
	 * 所属国家Id
	 */
	private String countryid;
	/**
	 * 所属城市Id
	 */
	private String cityid;
	/**
	 * 是否删除 1未删除  0删除
	 */
	private Integer isdel;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建人
	 */
	private Long createby;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 修改人
	 */
	private Long modifiedby;
	/**
	 * 修改时间
	 */
	private Date modifieddate;

}
