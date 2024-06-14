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
@TableName("wms_stockout")
public class StockoutEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long stockoutid;
	/**
	 * 出库单，系统自动生成
	 */
	private String stockoutno;
	/**
	 * 出库订单
	 */
	private String orderno;
	/**
	 * 出库类型
	 */
	private Long stockouttype;
	/**
	 * 客户
	 */
	private Long customerid;
	/**
	 * 
	 */
	private Integer stockoutstatus;
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
