package com.project.mall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
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
@TableName("wms_invmovedetail")
public class InvmovedetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long movedetailid;
	/**
	 * 库存移动Id
	 */
	private Long inventorymoveid;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 物料
	 */
	private Long materialid;
	/**
	 * 计划数量
	 */
	private BigDecimal planqty;
	/**
	 * 实际数量
	 */
	private BigDecimal actqty;
	/**
	 * 审核人
	 */
	private Long auditinid;
	/**
	 * 审核时间
	 */
	private Date auditintime;
	/**
	 * 1 0
	 */
	private Integer isdel;
	/**
	 * 
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
