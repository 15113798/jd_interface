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
 * @date 2020-06-02 22:09:51
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
	 * 推广结束日期
	 */
	private Date enddate;
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
	 * 推广开始日期
	 */
	private Date startdate;
	/**
	 * 状态： 1正常 2挖单待处理 3挖单已处理
	 */
	private Integer state;
	/**
	 * 现在的佣金比率
	 */
	private BigDecimal commissionratenow;

}
