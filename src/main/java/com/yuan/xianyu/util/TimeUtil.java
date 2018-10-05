/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: TimeUtil
 * Author:   Administrator
 * Date:     2018/9/22 0022 10:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/22 0022
 * @since 1.0.0
 */
public class TimeUtil {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String time2String(Date date){
		return simpleDateFormat.format(date);
	}

	public static String time2String(Date date, String format){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

}