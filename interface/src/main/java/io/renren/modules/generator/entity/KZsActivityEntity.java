package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-25 01:30:10
 */
@Data
@TableName("k_zs_activity")
public class KZsActivityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 活动表
	 */
	@TableId
	private Integer id;
	/**
	 * 类型： 1公有活动 2自有活动
	 */
	private Integer type;
	/**
	 * 活动标题
	 */
	private String activityTitle;
	/**
	 * 活动场景类型: 1普通招商
	 */
	private Integer senceType;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 
	 */
	private String remark;
	/**
	 * 操作人id
	 */
	private Integer mid;
	/**
	 * 联盟账号id
	 */
	private String allianceId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 状态: 0关闭 1开启
	 */
	private Integer state;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 淘宝的活动id
	 */
	private String taobaoActId;

}
