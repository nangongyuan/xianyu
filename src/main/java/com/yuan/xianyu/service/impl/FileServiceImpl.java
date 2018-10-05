/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: FileServiceImpl
 * Author:   Administrator
 * Date:     2018/9/17 0017 14:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyu.service.impl;

import com.yuan.xianyu.service.IFileService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/17 0017
 * @since 1.0.0
 */
@Service
public class FileServiceImpl implements IFileService {

	private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

	@Override
	public String upload(MultipartFile file, String path){
		String fileName = file.getOriginalFilename();
		//扩展名
		String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
		String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
		logger.info("开始上传文件,上传的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

		File fileDir = new File(path);
		if (!fileDir.exists()){
			//获得权限
			fileDir.setWritable(true);
			fileDir.mkdirs();
		}
		File targetFile = new File(path,uploadFileName);
		try {
			file.transferTo(targetFile);
		} catch (IOException e) {
			logger.error("上传文件异常",e);
			return null;
		}



		String copypath = "G:\\Java Web Demo\\xianyu\\src\\main\\resources\\static\\upload";
		copyFile(targetFile,new File(copypath,uploadFileName));

		return targetFile.getName();
	}

	public void copyFile(File fromFile,File toFile) {
		try{
			FileInputStream ins = new FileInputStream(fromFile);
			FileOutputStream out = new FileOutputStream(toFile);
			toFile.setWritable(true);
			byte[] b = new byte[1024];
			int n=0;
			while((n=ins.read(b))!=-1){
				out.write(b, 0, n);
			}

			ins.close();
			out.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}



}