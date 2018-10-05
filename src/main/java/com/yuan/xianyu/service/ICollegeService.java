/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ICollegeService
 * Author:   Administrator
 * Date:     2018/9/16 0016 15:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.College;
import com.yuan.xianyu.vo.ProvinceCollegeVo;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
public interface ICollegeService {
	ServerResponse<List<ProvinceCollegeVo>> listProvinceCollege();

	College getCollectById(Integer id);

}
