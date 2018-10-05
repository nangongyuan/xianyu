/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IOrderRepository
 * Author:   Administrator
 * Date:     2018/9/24 0024 13:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.repository;

import com.yuan.xianyu.pojo.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/24 0024
 * @since 1.0.0
 */
public interface IOrderRepository extends JpaRepository<Order, Integer> {
	Page<Order> findByBuyerOrSeller(Integer buyer, Integer seller, Pageable pageable);
}
