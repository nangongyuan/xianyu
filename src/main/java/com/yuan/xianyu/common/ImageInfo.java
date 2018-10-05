/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ImageInfo
 * Author:   Administrator
 * Date:     2018/9/18 0018 11:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.common;

import lombok.Data;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/18 0018
 * @since 1.0.0
 */
@Data
public class ImageInfo {

	private String url;

	private Integer width;

	private Integer height;

	public ImageInfo() {
	}

	public ImageInfo(String url) {
		this.url = url;
	}
}