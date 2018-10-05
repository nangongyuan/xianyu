/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ICollectRepository
 * Author:   Administrator
 * Date:     2018/9/19 0019 21:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.repository;

import com.yuan.xianyu.pojo.Collect;
import com.yuan.xianyu.pojo.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/19 0019
 * @since 1.0.0
 */
public interface ICollectRepository extends JpaRepository<Collect,Integer> {
	Collect findByProductIdAndCollecter(Integer productId, Integer collecter);

	List<Collect> findByCollecter(Integer collecter);

	@Modifying
	@Query("delete from Collect collect where collect.productId=:productId and collect.collecter=:collecter")
	int delByProductIdAndCollecter(@Param("productId") Integer productId, @Param("collecter") Integer collecter);
}
