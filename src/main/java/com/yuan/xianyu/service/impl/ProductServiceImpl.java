/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductServiceImpl
 * Author:   Administrator
 * Date:     2018/9/16 0016 12:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.enums.OrderByEnum;
import com.yuan.xianyu.enums.ProductStatusEnum;
import com.yuan.xianyu.service.ICategoryService;
import com.yuan.xianyu.util.Converter;
import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.Category;
import com.yuan.xianyu.pojo.Product;
import com.yuan.xianyu.repository.ICategoryRepository;
import com.yuan.xianyu.repository.IProductRepository;
import com.yuan.xianyu.service.IProductService;
import com.yuan.xianyu.vo.CategoryListVo;
import com.yuan.xianyu.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public ServerResponse<String> saveProduct(Product product) {
		product.setId(null);
		String mainImage = product.getSubImages().split(",")[0];
		product.setMainImage(mainImage);
		if (productRepository.save(product)!=null){
			return ServerResponse.createSuccess();
		}else{
			return ServerResponse.createError();
		}
	}

	@Override
	public ProductDetailVo getProductDetailById(Integer productId) {
		Product product = productRepository.getOne(productId);
		Category category = categoryRepository.getOne(product.getCategoryId());
		ProductDetailVo productDetailVo = Converter.product2ProductDetail(product);
		productDetailVo.setCategoryName(category.getName());
		return productDetailVo;
	}

	@Override
	public Page<Product> listProductByCategoryId(Integer collectId,Integer categoryId, Integer status, Integer order, Integer pageNum, Integer pageSize) {
		Sort sort = OrderByEnum.getSort(order);
		Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
		List<Integer> list = new ArrayList<>();
		list.add(categoryId);
		dfsCategory(list,categoryId);
		return productRepository.findByCollegeIdAndStatusAndCategoryIdIn(collectId, ProductStatusEnum.ING_STATUS.getCode(),list, pageable);
	}

	@Override
	@Transactional
	public void increaseProductHit(Integer productId) {
		productRepository.increaseProductHit(productId);
	}

	@Override
	public Page<Product> listMyProduct(Integer userId, Integer pageNum, Integer pageSize) {
		return productRepository.findByUserId(userId, PageRequest.of(pageNum,pageSize));
	}

	@Override
	@Transactional
	public ServerResponse updateProductStatus(Integer productId, Integer status) {
		int result = productRepository.updateProductStatus(status, productId);
		if (result <=0){
			return ServerResponse.createError();
		}
		return ServerResponse.createSuccess();
	}

	@Override
	public Page<Product> searchProduct(Integer collegeId, String word, Integer order,Integer pageNum, Integer pageSize) {
		Sort sort = OrderByEnum.getSort(order);
		return productRepository.findByCollegeIdAndNameContainingAndStatus(collegeId, word, 1,PageRequest.of(pageNum, pageSize,sort));
	}

	private void dfsCategory(List<Integer> list, Integer id){
		List<Category> categoryList= categoryRepository.findByParentId(id,null);
		for (Category item: categoryList
			 ) {
			list.add(item.getId());
			dfsCategory(list,item.getId());
		}
	}
}