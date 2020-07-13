package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-07-10 15:22:47
 */
@Data
@TableName("k_zs_jd_cookier")
public class KZsJdCookierEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * cookier值
	 */
	private String cookierValue;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 状态1有效2失效
	 */
	private Integer state;
	/**
	 * 请求次数，用来控制发送短信
	 */
	private Integer count;

}
