package com.spring.compass.interceptor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.compass.service.AdminService;
import com.spring.compass.vo.MberVO;

public class LoginFailUserInterceptor extends HandlerInterceptorAdapter{
	
	private String savePath;
	private String saveFileName;
	private AdminService adminService;
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		MberVO loginUser = (MberVO) request.getSession().getAttribute("loginUser");
		
		System.out.println("------------------------------------------------------오긴옵니다 logInterceptor");
		if(loginUser == null) return;
		if(loginUser.getMberNo().equals("MBER259999999")) return;
		Date logTime = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String userLogTime = fmt.format(logTime);
		if(adminService ==null) {
			System.out.println("바보");
		}else {
			System.out.println("널은아님");
		}
		MberVO mber = adminService.getMberBymberNo(loginUser.getMberNo());
		if(mber ==null) {
			System.out.println("바보");
		}else {
			System.out.println("널은아님");
		}
		
		System.out.println("--------------------회원번호:"+loginUser.getMberNo());
		System.out.println("--------------------기관번호:"+loginUser.getInstNo());
//		System.out.println("--------------------URL:"+request.getRequestURL());
		System.out.println("--------------------접속시간:"+userLogTime);
		System.out.println("--------------------접속IP:"+request.getRemoteAddr());
		System.out.println("--------------------회원명:"+mber.getMberNm());
		
		
		
		
		String tag = "[login:user]";
		String log = tag + loginUser.getMberNo() + "," 
						 + loginUser.getInstNo() + "," 
				         + userLogTime + "," 
						 + request.getRemoteAddr()+","
						 + mber.getMberNm();
		
		File file = new File(savePath);
		if(!file.exists()) file.mkdirs();
		
		String logFilePath = savePath + File.separator + saveFileName;
		BufferedWriter out = new BufferedWriter(new FileWriter(logFilePath, true));
		
		out.write(log);
		out.newLine();
		out.close();
	}
	
}
