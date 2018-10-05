/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CollegeServiceImpl
 * Author:   Administrator
 * Date:     2018/9/16 0016 15:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.common.ServerResponse;
import com.yuan.xianyu.pojo.College;
import com.yuan.xianyu.pojo.Province;
import com.yuan.xianyu.repository.ICollegeRepository;
import com.yuan.xianyu.repository.IProvinceRepository;
import com.yuan.xianyu.service.ICollegeService;
import com.yuan.xianyu.vo.ProvinceCollegeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
@Service
public class CollegeServiceImpl implements ICollegeService {

	@Autowired
	private IProvinceRepository provinceRepository;

	@Autowired
	private ICollegeRepository collegeRepository;

	@Override
	public ServerResponse<List<ProvinceCollegeVo>> listProvinceCollege(){
		List<Province> provinceList = provinceRepository.findAll(new Sort(Sort.Direction.DESC,"ordering"));
		List<ProvinceCollegeVo> provinceCollegeVoList = new ArrayList<>();
		for (Province item: provinceList
		) {
			List<College> collegeList = collegeRepository.findByProvinceId(item.getId(),new Sort(Sort.Direction.DESC,"ordering"));
			provinceCollegeVoList.add(new ProvinceCollegeVo(item.getId(),item.getName(),collegeList));
		}
		return ServerResponse.createErrorByData(provinceCollegeVoList);
	}

	@Override
	public College getCollectById(Integer id) {

		return collegeRepository.getOne(id);

	}
}