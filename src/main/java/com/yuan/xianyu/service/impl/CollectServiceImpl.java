/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CollectServiceImpl
 * Author:   Administrator
 * Date:     2018/9/19 0019 21:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.Collect;
import com.yuan.xianyu.repository.ICollectRepository;
import com.yuan.xianyu.repository.IProductRepository;
import com.yuan.xianyu.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/19 0019
 * @since 1.0.0
 */
@Service
public class CollectServiceImpl implements ICollectService {

	@Autowired
	private ICollectRepository collectRepository;

	@Autowired
	private IProductRepository productRepository;

	@Override
	public ServerResponse saveCollect(Integer productId, Integer userId) {
		if (collectRepository.findByProductIdAndCollecter(productId,userId)!=null){
			return ServerResponse.createErrorByMessage("该商品你已收藏");
		}
		Collect collect = new Collect();
		collect.setCollecter(userId);
		collect.setProductId(productId);
		collect = collectRepository.save(collect);
		if (collect == null){
			return ServerResponse.createErrorByMessage("收藏失败");
		}
		return ServerResponse.createSuccess();
	}

	@Override
	public Page listMyCollect(Integer userId, Integer pageNum, Integer pageSize) {
		List<Collect> collectList = collectRepository.findByCollecter(userId);
		List<Integer> ids = new ArrayList<>();
		for (Collect item : collectList
			 ) {
			ids.add(item.getProductId());
		}
		return productRepository.findByIdIn(ids, PageRequest.of(pageNum,pageSize));
	}

	@Override
	@Transactional
	public ServerResponse delCollect(Integer productId, Integer userId) {
		int result = collectRepository.delByProductIdAndCollecter(productId, userId);
		if (result<=0){
			return ServerResponse.createErrorByMessage("删除失败");
		}
		return ServerResponse.createSuccess();
	}
}