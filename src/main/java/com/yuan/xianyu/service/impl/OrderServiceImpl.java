/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: OrderServiceImpl
 * Author:   Administrator
 * Date:     2018/9/24 0024 13:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.Grade;
import com.yuan.xianyu.pojo.Order;
import com.yuan.xianyu.pojo.User;
import com.yuan.xianyu.repository.IGradeRepository;
import com.yuan.xianyu.repository.IOrderRepository;
import com.yuan.xianyu.repository.IProductRepository;
import com.yuan.xianyu.repository.IUserRepository;
import com.yuan.xianyu.service.IOrderService;
import com.yuan.xianyu.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/24 0024
 * @since 1.0.0
 */
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IGradeRepository gradeRepository;

	@Autowired
	private IProductRepository productRepository;

	@Override
	@Transactional
	public ServerResponse saveOrder(Integer userId, String username, Integer productId) {
		User user = userRepository.findByUsername(username);
		if (user == null){
			return ServerResponse.createErrorByMessage("找不到该用户");
		}
		Order order = new Order();
		order.setBuyer(user.getId());
		order.setSeller(userId);
		order.setProductId(productId);
		Order result = orderRepository.save(order);
		if (result == null){
			return ServerResponse.createErrorByMessage("创建订单失败");
		}
		List<Grade> gradeList = new ArrayList<>();
		gradeList.add(new Grade(result.getId(),5,userId,user.getId()));
		gradeList.add(new Grade(result.getId(),5,user.getId(),userId));
		gradeRepository.saveAll(gradeList);
		return ServerResponse.createSuccess();
	}

	@Override
	public Page<OrderVo> listMyOrder(Integer userId, Integer pageNum, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		Page<Order> page = orderRepository.findByBuyerOrSeller(userId,userId,pageable);
		List<Order> orderList = page.getContent();
		List<OrderVo> orderVoList = new ArrayList<>();
		for (Order item : orderList
			 ) {
			OrderVo orderVo = new OrderVo();
			orderVo.setOrderId(item.getId());
			orderVo.setBuyer(userRepository.getOne(item.getBuyer()).getUsername());
			orderVo.setSeller(userRepository.getOne(item.getSeller()).getUsername());
			Grade grade = gradeRepository.findByOrderIdAndGrader(item.getId(),userId);
			if (grade != null){
				orderVo.setGrade(grade.getScore());
			}
			orderVo.setProduct(productRepository.getOne(item.getProductId()));
			orderVoList.add(orderVo);
		}
		PageImpl<OrderVo> result = new PageImpl(orderVoList,pageable,orderVoList.size());
		return result;
	}
}