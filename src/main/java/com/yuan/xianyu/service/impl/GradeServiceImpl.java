/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GradeServiceImpl
 * Author:   Administrator
 * Date:     2018/9/24 0024 13:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.Grade;
import com.yuan.xianyu.repository.IGradeRepository;
import com.yuan.xianyu.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/24 0024
 * @since 1.0.0
 */
@Service
public class GradeServiceImpl implements IGradeService {

	@Autowired
	private IGradeRepository gradeRepository;

	@Override
	public ServerResponse updateScore(Grade grade) {
		int result = gradeRepository.updateScore(grade.getOrderId(),grade.getGrader(),grade.getScore());
		if (result<=0){
			return ServerResponse.createError();
		}
		return ServerResponse.createSuccess();
	}
}