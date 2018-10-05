/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CategoryServiceImpl
 * Author:   Administrator
 * Date:     2018/9/16 0016 12:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.util.Converter;
import com.yuan.xianyu.pojo.Category;
import com.yuan.xianyu.repository.ICategoryRepository;
import com.yuan.xianyu.service.ICategoryService;
import com.yuan.xianyu.vo.CategoryListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	@Cacheable(value = "categoryList")
	public List<CategoryListVo> listCategory() {
		CategoryListVo categoryListVo = new CategoryListVo();
		categoryListVo.setId(0);
		getChildCategoryu(categoryListVo);
		return categoryListVo.getCategoryListVoList();
	}

	@Override
	public Category getCategoryById(Integer id) {
		return categoryRepository.getOne(id);
	}


	private void getChildCategoryu(CategoryListVo categoryListVo){
		if (categoryListVo != null){
			List<Category> categories = categoryRepository.findByParentId(categoryListVo.getId(),new Sort(Sort.Direction.DESC,"ordering"));
			List<CategoryListVo> categoryListVoList = new ArrayList<>();
			for (Category item:
					categories) {
				CategoryListVo temp = Converter.category2CategoryListVo(item);
				getChildCategoryu(temp);
				categoryListVoList.add(temp);
			}
			if (categoryListVoList.size()>0){
				categoryListVo.setCategoryListVoList(categoryListVoList);
			}
		}
	}
}