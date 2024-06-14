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
@TableName("wms_reservoirarea")
public class ReservoirareaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long reservoirareaid;
	/**
	 * 库区编号
	 */
	private String reservoirareano;
	/**
	 * 库区名称
	 */
	private String reservoirareaname;
	/**
	 * 所属仓库ID
	 */
	private Long warehouseid;
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
