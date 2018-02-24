package com.refeng.util;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RequestMapping("/uploadFile")
@Controller
public class UploadController {

	//获取ip地址
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	//端口号
	@Value("${FTP_PORT}")
	private String FTP_PORT;
	//用户名
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	//密码
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	//基本路径
	@Value("${FTP_BASEPATH}")
	private String FTP_BASEPATH;
	//下载地址地基础url
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	@RequestMapping(params = "updateImg", produces = "text/html")

	public ResponseEntity<String> updateImg(@RequestParam(value = "imgFile", required = false) MultipartFile  imgFile,
											HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
		// 定义允许上传的文件扩展名 imgFile CommonsMultipartFile attachment
		Date date = new Date();
		String fileName = date.getTime() + "" + RandomUtils.getRandom(999);
			try {
				// 生成一个文件名
				// 获取旧的名字
				String oldName = imgFile.getOriginalFilename();
				String newName = date.getTime() + "" + RandomUtils.getRandom(999);
				//新名字
				newName = newName + oldName.substring(oldName.lastIndexOf("."));
				//上传的路径
				String imagePath = "caipiao";
				//端口号
				int port = Integer.parseInt(FTP_PORT);
				System.out.println(FTP_BASEPATH);
				//调用方法，上传文件
				boolean result = FtpUtil.uploadFile(FTP_ADDRESS, port,
						FTP_USERNAME, FTP_PASSWORD, FTP_BASEPATH, imagePath,
						newName, imgFile.getInputStream());
				//判断是否上传成功
				if (result) {
					String url = IMAGE_BASE_URL+newName;
					System.out.println(url);
					request.setCharacterEncoding("utf-8");
					response.setContentType("text/html;charset=utf-8");
					response.setHeader("Cache-Control", "no-cache");
					PrintWriter out = response.getWriter();
					out.print(url);
					out.flush();
					out.close();
					return null;
				}

			} catch (Exception e) {
         		e.printStackTrace();
			}
		return  null;
		}
	}






