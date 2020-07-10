package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-07-09 15:29:23
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
	 * 类型
	 */
	private String type;
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
	 * 店铺链接
	 */
	private String url;
	/**
	 * qq
	 */
	private String qq;
	/**
	 * 微信号
	 */
	private String weixinName;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 是否合作 1是 2否
	 */
	private Integer isHezuo;
	/**
	 * 京东的活动id
	 */
	private String taobaoActId;
	/**
	 * 分配状态： 1已分配 2未分配
	 */
	private Integer allot;
	/**
	 * 提报商品数量(新)
	 */
	private Integer skucnt;
	/**
	 * 订单引入量（新）
	 */
	private Integer ordercntin;
	/**
	 * 实际服务费（新）
	 */
	private BigDecimal servicefee;
	/**
	 * 预估服务费（新）
	 */
	private BigDecimal ygservicefee;
	/**
	 * 活动状态(2为进行中，5为活动结束）
	 */
	private Integer activitystatus;

}
