/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IChatRepository
 * Author:   Administrator
 * Date:     2018/9/21 0021 23:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.repository;

import com.yuan.xianyu.pojo.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/21 0021
 * @since 1.0.0
 */
public interface IChatRepository  extends JpaRepository<Chat,Integer> {
	List<Chat> findByReceiverAndReadContent(Integer receiver, Integer readContent);

	@Modifying
	@Query("update Chat chat set chat.readContent=1 where chat.receiver=:receiver and chat.readContent=0")
	int updateRead( @Param(value = "receiver")Integer receiver);
}
