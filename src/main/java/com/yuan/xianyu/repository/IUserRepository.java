/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IUserRepository
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.repository;

import com.yuan.xianyu.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
public interface IUserRepository extends JpaRepository<User ,Integer> {
	User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);
}
