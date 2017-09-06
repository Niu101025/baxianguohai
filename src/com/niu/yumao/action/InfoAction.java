package com.niu.yumao.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.niu.yumao.domain.Info;
import com.niu.yumao.service.InfoService;
import com.niu.yumao.utils.StrUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InfoAction extends ActionSupport implements ModelDriven<Info> {

	private Info info = new Info();

	@Override
	public Info getModel() {
		// TODO Auto-generated method stub
		return info;
	}

	private InfoService infoService;

	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
	}

	/**
	 * 获取网站的信息
	 * @return
	 */
	public String findInfo() {
		Info info = infoService.findInfo();
		ActionContext.getContext().getValueStack().push(info);
		return "findInfoSuccess";
	}

	// myFile属性用来封装上传的文件
	private File myFile;

	// myFileContentType属性用来封装上传文件的类型
	private String myFileContentType;

	// myFileFileName属性用来封装上传文件的文件名
	private String myFileFileName;

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	
	/**
	 * 保存网站的信息
	 * @return
	 */
	public String saveInfo() {
		File toFile = null;
		try {
			if(StrUtils.isNotBlank(myFileFileName)&&myFile!=null){
				// 基于myFile创建一个文件输入流
				InputStream is = new FileInputStream(myFile);
				// 设置上传文件目录
				String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
				File file = new File(uploadPath);
				if (!file.exists()) {
					file.mkdirs();
				}
				// 设置目标文件
				Date date = new Date();
				DateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
				String time = format.format(date);
				toFile = new File(uploadPath, time + "_" + this.getMyFileFileName());
				// 创建一个输出流
				OutputStream os = null;
				// 设置缓存
				byte[] buffer = new byte[1024];
				int length = 0;
				os = new FileOutputStream(toFile);
				while ((length = is.read(buffer)) > 0) {
					os.write(buffer, 0, length);
				}
				is.close();
				// 关闭输出流
				os.close();
				if(toFile!=null){
					info.setLogo("/upload/"+toFile.getName());
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "saveError";
		}
		infoService.updateInfo(info);

		return "saveSuccess";
	}

}
