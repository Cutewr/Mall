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
 * @date 2024-06-14 13:21:04
 */
@Data
@TableName("wms_inventorymove")
public class InventorymoveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 库存移动主键
	 */
	@TableId
	private Long inventorymoveid;
	/**
	 * 库存移动编号
	 */
	private String inventorymoveno;
	/**
	 * 原货架Id
	 */
	private Long sourcestoragerackid;
	/**
	 * 目标货架
	 */
	private Long aimstoragerackid;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 1 0
	 */
	private Integer isdel;
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
