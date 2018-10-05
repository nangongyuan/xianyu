/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ILeaveWordRepository
 * Author:   Administrator
 * Date:     2018/9/22 0022 10:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.repository;

import com.yuan.xianyu.pojo.LeaveWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/22 0022
 * @since 1.0.0
 */
public interface ILeaveWordRepository extends JpaRepository<LeaveWord,Integer> {
	List<LeaveWord> findByProductId(Integer productId);
}
