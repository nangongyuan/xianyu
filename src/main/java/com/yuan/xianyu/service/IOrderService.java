/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IOrderService
 * Author:   Administrator
 * Date:     2018/9/24 0024 13:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.vo.OrderVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/24 0024
 * @since 1.0.0
 */
public interface IOrderService {

	ServerResponse saveOrder(Integer userId, String username, Integer productId);

	Page<OrderVo> listMyOrder(Integer userId, Integer pageNum, Integer pageSize);

}
