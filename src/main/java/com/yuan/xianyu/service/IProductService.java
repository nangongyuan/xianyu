/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IProductService
 * Author:   Administrator
 * Date:     2018/9/16 0016 12:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.Product;
import com.yuan.xianyu.vo.ProductDetailVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
public interface IProductService {
	ServerResponse<String> saveProduct(Product product);

	ProductDetailVo getProductDetailById(Integer productId);

	Page<Product> listProductByCategoryId(Integer collectId,Integer categoryId,Integer status, Integer order, Integer pageNum, Integer pageSize);

	void increaseProductHit(Integer productId);

	Page<Product> listMyProduct(Integer userId, Integer pageNum, Integer pageSize);

	ServerResponse updateProductStatus(Integer productId, Integer status);

	Page<Product> searchProduct(Integer collegeId,String word, Integer order,Integer pageNum, Integer pageSize);
}
