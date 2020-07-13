package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-07-13 21:29:04
 */
@Data
@TableName("k_zs_goods")
public class KZsGoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 产品链接
	 */
	private String goodsUrl;
	/**
	 * 商品图片
	 */
	private String logoImg;
	/**
	 * 商品名称
	 */
	private String title;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 所有者id
	 */
	private Integer mid;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 商品ID-新增
	 */
	private String skuid;
	/**
	 * 商品单价-新增
	 */
	private BigDecimal unitprice;
	/**
	 * 商品落地页-新增
	 */
	private String materialurl;
	/**
	 * 是否支持运费险(1:是,0:否)-新增
	 */
	private Integer isfreefreightrisk;
	/**
	 * 是否包邮(1:是,0:否,2)-新增
	 */
	private Integer isfreeshipping;
	/**
	 * 无线佣金比例-新增
	 */
	private BigDecimal commisionratiowl;
	/**
	 * PC佣金比例-新增
	 */
	private BigDecimal commisionratiopc;
	/**
	 * 图片地址
	 */
	private String imgurl;
	/**
	 * 商家id-新增
	 */
	private Integer vid;
	/**
	 * 一级类目名称-新增
	 */
	private String cidname;
	/**
	 * 一级类目ID-新增
	 */
	private Integer cid;
	/**
	 * 二级类目ID-新增
	 */
	private Integer cid2;
	/**
	 * 二级类目名称
	 */
	private String cid2name;
	/**
	 * 三级类目id
	 */
	private Integer cid3;
	/**
	 * 三级类目名称
	 */
	private String cid3name;
	/**
	 * 商品无线京东价（单价为-1表示未查询到该商品单价）
	 */
	private BigDecimal wlunitprice;
	/**
	 * 是否秒杀(1:是,0:否)
	 */
	private Integer isseckill;
	/**
	 * 30天引单数量
	 */
	private Integer inordercount;
	/**
	 * 店铺ID
	 */
	private Integer shopid;
	/**
	 * 是否自营(1:是,0:否)
	 */
	private Integer isjdsale;
	/**
	 * 商品名称
	 */
	private String goodsname;
	/**
	 * 状态： 1正常 2挖单待处理 3挖单已处理
	 */
	private Integer state;
	/**
	 * 现在的佣金比率
	 */
	private BigDecimal commissionratenow;
	/**
	 * 分配状态： 1已分配 2未分配
	 */
	private Integer allot;
	/**
	 * 京东活动id（新）
	 */
	private String activityid;
	/**
	 * 佣金比例（新）
	 */
	private BigDecimal commissionrate;
	/**
	 * 参与时间-开始时间（新）
	 */
	private String starttime;
	/**
	 * 参与时间-结束时间（新）
	 */
	private String endtime;
	/**
	 * 商品图片路径（新）
	 */
	private String imageurl;
	/**
	 * 引单量（新）
	 */
	private Integer ordercntin;
	/**
	 * 服务费比例（新）
	 */
	private BigDecimal servicerate;
	/**
	 * 店铺名称（新）
	 */
	private String shopname;
	/**
	 * 商品名称（新）
	 */
	private String skuname;
	/**
	 * 状态（新）0待审核1已通过2已拒绝3已中止4已过期5已停止
	 */
	private Integer status;
	/**
	 * 京东的活动id
	 */
	private String taobaoActId;

}
