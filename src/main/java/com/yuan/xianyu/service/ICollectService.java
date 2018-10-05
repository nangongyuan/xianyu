/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ICollectService
 * Author:   Administrator
 * Date:     2018/9/19 0019 21:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.Product;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/19 0019
 * @since 1.0.0
 */
public interface ICollectService {

	ServerResponse saveCollect(Integer productId, Integer userId);

	Page listMyCollect(Integer userId, Integer pageNum, Integer pageSize);

	ServerResponse delCollect(Integer productId, Integer userId);

}
