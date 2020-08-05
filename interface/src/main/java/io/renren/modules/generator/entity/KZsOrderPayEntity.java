package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-04-25 00:37:00
 */
@Data
@TableName("k_zs_order_pay")
public class KZsOrderPayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 商品id
	 */
	private Integer goodsId;


	/**
	 * 活动id
	 */
	private Integer activityId;
	/**
	 * 所有者id
	 */
	private Integer mid;
	/**
	 * 数量
	 */
	private Integer num;
	/**
	 * 单价
	 */
	private BigDecimal price;

	/**
	 * 订单编号
	 */
	private String orderNo;

	/**
	 * 是否付款： 1是 2否
	 */
	private Integer isPay;
	/**
	 * 是否结算： 1是 2否
	 */
	private Integer isSettle;

	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 实际佣金金额（新增）
	 */
	private String actualcosprice;
	/**
	 * 推客获得的实际佣金金额（新增）
	 */
	private String actualfee;
	/**
	 * 预估计佣金额（新增）
	 */
	private String estimatecosprice;
	/**
	 * 佣金比例（新增）
	 */
	private String commissionrate;
	/**
	 * 推客的预估佣金（新增）
	 */
	private String estimatefee;
	/**
	 * 最终比例（新增）
	 */
	private String finalrate;
	/**
	 * 一级类目（新增）
	 */
	private String cid1;
	/**
	 * 商品售后中数量（新增）
	 */
	private String frozenskunum;
	/**
	 * 二级类目ID（新增）
	 */
	private String cid2;
	/**
	 * 商品名称（新增）
	 */
	private String skuname;
	/**
	 * 商品数量（新增）
	 */
	private String skunum;
	/**
	 * 商品已退货数量（新增）
	 */
	private String skureturnnum;
	/**
	 * 分成比例（新增）
	 */
	private String subsiderate;
	/**
	 * 补贴比例（新增）
	 */
	private String subsidyrate;
	/**
	 * 三级类目ID（新增）
	 */
	private String cid3;
	/**
	 * 1：未知,2.无效-拆单,3.无效-取消,4.无效-京东帮帮主订单,5.无效-账号异常,6.无效-赠品类目不返佣,7.无效-校园订单,8.无效-企业订单,9.无效-团购订单,10.无效-开增值税专用发票订单,11.无效-乡村推广员下单,12.无效-自己推广自己下单,13.无效-违规订单,14.无效-来源与备案网址不符,15.待付款,16.已付款,17.已完成,18.已结算（5.9号不再支持结算状态回写展示
	 */
	private String validcode;
	/**
	 * 商家ID（新增）
	 */
	private String popid;


	//淘宝活动id
	private String skuid;
	private String taobao_act_id;
	private Date finishTime;
	private Date orderTime;
	private Date payMonth;
	private String yugu_money;

	private Integer shopid;


	/**
	 * 商品落地页-新增
	 */
	private String materialurl;
	/**
	 * 商品图片
	 */
	private String imgurl;
	/**
	 * 商家名称
	 */
	private String skushopname;


}
