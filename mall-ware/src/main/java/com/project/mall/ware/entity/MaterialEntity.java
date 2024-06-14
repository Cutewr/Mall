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
@TableName("wms_material")
public class MaterialEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long materialid;
	/**
	 * 产品编号
	 */
	private String materialno;
	/**
	 * 产品名称
	 */
	private String materialname;
	/**
	 * 产品类型
	 */
	private Long materialtype;
	/**
	 * 单位
	 */
	private Long unit;
	/**
	 * 默认所属货架
	 */
	private Long storagerackid;
	/**
	 * 默认所属库区
	 */
	private Long reservoirareaid;
	/**
	 * 默认所属仓库
	 */
	private Long warehouseid;
	/**
	 * 安全库存
	 */
	private BigDecimal qty;
	/**
	 * 有效期
	 */
	private BigDecimal expirydate;
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
