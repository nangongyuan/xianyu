/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IProvinceService
 * Author:   Administrator
 * Date:     2018/9/16 0016 14:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.Province;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
public interface IProvinceService {
	ServerResponse<List<Province>> listProvince();

	Province getProvinceById(Integer id);
}
