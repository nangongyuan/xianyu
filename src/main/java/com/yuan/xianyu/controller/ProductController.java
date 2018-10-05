/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductController
 * Author:   Administrator
 * Date:     2018/9/16 0016 12:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.controller;

import com.yuan.xianyu.common.Const;
import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.Product;
import com.yuan.xianyu.pojo.User;
import com.yuan.xianyu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 〈商品〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@PostMapping("save")
	public ServerResponse<String> saveProduct(Product product, HttpSession httpSession){
		User user = (User) httpSession.getAttribute(Const.LOGIN_USER);
		product.setCollegeId((Integer) httpSession.getAttribute(Const.COLLEGE_ID));
		if (user == null){
			return ServerResponse.createErrorByMessage("未登录");
		}
		product.setUserId(user.getId());
		return productService.saveProduct(product);
	}

	@PostMapping("status_update")
	public ServerResponse<String> updateProductStatus(Integer productStatus, Integer productId){
		return productService.updateProductStatus(productId, productStatus);
	}

}