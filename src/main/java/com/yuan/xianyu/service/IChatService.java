/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IChatService
 * Author:   Administrator
 * Date:     2018/9/21 0021 23:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service;

import com.yuan.xianyu.pojo.Chat;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/21 0021
 * @since 1.0.0
 */
public interface IChatService {
	List<Chat> listMyUnreadChat(Integer userId);

	Boolean saveChat(Chat chat);

	Boolean updateRead(Integer receiver);
}
