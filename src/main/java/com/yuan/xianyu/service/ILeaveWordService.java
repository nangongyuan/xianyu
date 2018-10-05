/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ILeaveWordService
 * Author:   Administrator
 * Date:     2018/9/22 0022 10:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.LeaveWord;
import com.yuan.xianyu.vo.LeaveWordVo;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/22 0022
 * @since 1.0.0
 */
public interface ILeaveWordService {
	ServerResponse saveLeaveWord(LeaveWord leaveWord);

	List<LeaveWordVo> listLeaveWordByProductId(Integer productId);
}
