/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ImageUtil
 * Author:   Administrator
 * Date:     2018/9/18 0018 11:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.util;

import com.yuan.xianyu.common.ImageInfo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/18 0018
 * @since 1.0.0
 */
public class ImageUtil {

	public static ImageInfo getImgWidthAndHeight(ImageInfo imageInfo){
		try {
			URL url = new URL(imageInfo.getUrl());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			BufferedImage image = ImageIO.read(connection.getInputStream());
			imageInfo.setWidth(image .getWidth());
			imageInfo.setHeight(image .getHeight());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageInfo;
	}
}