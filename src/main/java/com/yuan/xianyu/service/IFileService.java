/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IFileService
 * Author:   Administrator
 * Date:     2018/9/17 0017 14:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/17 0017
 * @since 1.0.0
 */
public interface IFileService {
	String upload(MultipartFile file, String path);

}
