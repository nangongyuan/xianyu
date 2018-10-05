/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductDetailVo
 * Author:   Administrator
 * Date:     2018/9/18 0018 11:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.vo;

import com.yuan.xianyu.common.ImageInfo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/18 0018
 * @since 1.0.0
 */
@Data
public class ProductDetailVo {

	private Integer id;

	private String categoryName;

	private String name;

	private Integer collegeId;

	private String quality;

	private String mainImage;

	private List<ImageInfo> subImages;

	private String detail;

	private BigDecimal price;

	private Integer userId;


}