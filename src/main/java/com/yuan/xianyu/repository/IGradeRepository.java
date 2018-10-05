/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IGradeRepository
 * Author:   Administrator
 * Date:     2018/9/24 0024 13:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.repository;

import com.yuan.xianyu.pojo.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/24 0024
 * @since 1.0.0
 */
public interface IGradeRepository extends JpaRepository<Grade, Integer> {
	Grade findByOrderIdAndGrader(Integer orderId, Integer grader);

	@Modifying
	@Query("update Grade grade set grade.score=:score where grade.orderId=:orderId and grade.grader=:grader")
	int updateScore(@Param(value = "orderId")Integer orderId, @Param(value = "grader")Integer grader,@Param(value = "score")Integer score);
}
