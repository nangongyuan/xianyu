/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Converter
 * Author:   Administrator
 * Date:     2018/9/16 0016 13:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.util;

import com.yuan.xianyu.common.ImageInfo;
import com.yuan.xianyu.pojo.Category;
import com.yuan.xianyu.pojo.LeaveWord;
import com.yuan.xianyu.pojo.Product;
import com.yuan.xianyu.repository.IUserRepository;
import com.yuan.xianyu.vo.CategoryListVo;
import com.yuan.xianyu.vo.LeaveWordVo;
import com.yuan.xianyu.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈转换器类〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
public class Converter {

	public static CategoryListVo category2CategoryListVo(Category category){
		CategoryListVo categoryListVo = new CategoryListVo();
		categoryListVo.setId(category.getId());
		categoryListVo.setName(category.getName());
		return categoryListVo;
	}

	public static ProductDetailVo product2ProductDetail(Product product){
		ProductDetailVo productDetailVo = new ProductDetailVo();
		productDetailVo.setId(product.getId());
		productDetailVo.setCollegeId(product.getCollegeId());
		productDetailVo.setDetail(product.getDetail());
		productDetailVo.setMainImage(product.getMainImage());
		productDetailVo.setName(product.getName());
		productDetailVo.setPrice(product.getPrice());
		productDetailVo.setQuality(product.getQuality());
		productDetailVo.setUserId(product.getUserId());
		String[] images = product.getSubImages().split(",");
		List<ImageInfo> imageInfoList = new ArrayList<>();
		for (String item: images
			 ) {
			imageInfoList.add(ImageUtil.getImgWidthAndHeight(new ImageInfo(item)));
		}
		productDetailVo.setSubImages(imageInfoList);
		return productDetailVo;
	}

	public static LeaveWordVo leaveWord2LeaveWordVo(LeaveWord leaveWord){
		LeaveWordVo leaveWordVo = new LeaveWordVo();
		leaveWordVo.setContent(leaveWord.getContent());
		leaveWordVo.setCreateTime(TimeUtil.time2String(leaveWord.getCreateTime(),"yyyy年MM月dd日"));
		return leaveWordVo;
	}
}