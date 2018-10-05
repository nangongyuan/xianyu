/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ICollegeRepository
 * Author:   Administrator
 * Date:     2018/9/16 0016 12:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.repository;

import com.yuan.xianyu.pojo.College;
import com.yuan.xianyu.pojo.Province;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 〈大学〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
public interface ICollegeRepository extends JpaRepository<College,Integer> {
	List<College> findByProvinceId(Integer provinceId, Sort sort);
}
