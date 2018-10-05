/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ICategoryRepository
 * Author:   Administrator
 * Date:     2018/9/16 0016 12:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.repository;

import com.yuan.xianyu.pojo.Category;
import com.yuan.xianyu.pojo.College;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
	List<Category> findByParentId(Integer parentId, Sort sort);
}
