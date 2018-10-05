/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LeaveWordServiceImpl
 * Author:   Administrator
 * Date:     2018/9/22 0022 10:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.LeaveWord;
import com.yuan.xianyu.repository.ILeaveWordRepository;
import com.yuan.xianyu.repository.IUserRepository;
import com.yuan.xianyu.service.ILeaveWordService;
import com.yuan.xianyu.util.Converter;
import com.yuan.xianyu.vo.LeaveWordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/22 0022
 * @since 1.0.0
 */
@Service
public class LeaveWordServiceImpl implements ILeaveWordService {

	@Autowired
	private ILeaveWordRepository leaveWordRepository;

	@Autowired
	private IUserRepository userRepository;

	@Override
	public ServerResponse saveLeaveWord(LeaveWord leaveWord) {
		LeaveWord result = leaveWordRepository.save(leaveWord);
		if (result == null){
			ServerResponse.createErrorByMessage("留言失败");
		}
		return ServerResponse.createSuccess();
	}

	@Override
	public List<LeaveWordVo> listLeaveWordByProductId(Integer productId) {
		List<LeaveWord> leaveWordList = leaveWordRepository.findByProductId(productId);
		List<LeaveWordVo> leaveWordVoList = new ArrayList<>();
		for (LeaveWord item: leaveWordList
			 ) {
			LeaveWordVo leaveWordVo = Converter.leaveWord2LeaveWordVo(item);
			leaveWordVo.setSender(userRepository.getOne(item.getSender()).getUsername());
			leaveWordVoList.add(leaveWordVo);
		}
		return leaveWordVoList;
	}
}