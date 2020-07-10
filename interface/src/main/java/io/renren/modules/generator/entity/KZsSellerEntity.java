package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 卖家表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-07-10 12:14:26
 */
@Data
@TableName("k_zs_seller")
public class KZsSellerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 卖家id
	 */
	private String shopid;
	/**
	 * 卖家昵称
	 */
	private String sellerNickname;
	/**
	 * 店铺标题
	 */
	private String sellerTitle;
	/**
	 * 店铺类型
	 */
	private String type;
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
	 * 运营
	 */
	private String operation;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 状态： 0提交
	 */
	private Integer state;
	/**
	 * 管理员id
	 */
	private Integer mid;
	/**
	 * 锁定时间
	 */
	private Date lockTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 淘宝的活动id
	 */
	private String taobaoActId;
	/**
	 * 是否合作 1是 2否
	 */
	private Integer isHezuo;
	/**
	 * 分配状态： 1已分配 2未分配
	 */
	private Integer allot;

}
