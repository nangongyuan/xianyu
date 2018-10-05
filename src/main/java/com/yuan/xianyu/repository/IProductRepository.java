/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IProductRepository
 * Author:   Administrator
 * Date:     2018/9/16 0016 12:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.repository;

import com.yuan.xianyu.pojo.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * 〈商品〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
public interface IProductRepository extends JpaRepository<Product, Integer> {
	Page<Product> findByCollegeIdAndStatusAndCategoryIdIn(Integer collegeId, Integer status,List<Integer> categoryIds, Pageable pageable);

	@Modifying
	@Query("update Product product set product.hit = product.hit+1 where product.id=:id")
	void increaseProductHit(@Param(value = "id")Integer id);

	Page<Product> findByIdIn(List<Integer> ids, Pageable pageable);

	Page<Product> findByUserId(Integer userId, Pageable pageable);

	@Modifying
	@Query("update Product product set product.status=:status where product.id=:id")
	int updateProductStatus(@Param(value = "status")Integer status, @Param(value = "id")Integer id);

	Page<Product> findByCollegeIdAndNameContainingAndStatus(Integer collegeId, String name , Integer status, Pageable pageable);
}
