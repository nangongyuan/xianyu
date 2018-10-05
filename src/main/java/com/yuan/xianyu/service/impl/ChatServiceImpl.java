/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ChatServiceImpl
 * Author:   Administrator
 * Date:     2018/9/21 0021 23:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.pojo.Chat;
import com.yuan.xianyu.repository.IChatRepository;
import com.yuan.xianyu.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/21 0021
 * @since 1.0.0
 */
@Service
public class ChatServiceImpl implements IChatService {

	@Autowired
	private IChatRepository chatRepository;

	@Override
	public List<Chat> listMyUnreadChat(Integer userId){
		return chatRepository.findByReceiverAndReadContent(userId,0);
	}

	@Override
	public Boolean saveChat(Chat chat) {
		Chat result = chatRepository.save(chat);
		if (result == null){
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public Boolean updateRead(Integer receiver) {
		if (chatRepository.updateRead(receiver)>0){
			return true;
		}
		return false;
	}


}