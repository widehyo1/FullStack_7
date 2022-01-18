package com.spring.compass.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.compass.service.MberService;
import com.spring.compass.service.MenuService;
import com.spring.compass.vo.MberVO;
import com.spring.compass.vo.MenuVO;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Controller
public class CommonController {
	
	private final static String APIKEY = "NCSAPXSIFKAYD8MM";
	private final static String APISECRET = "SPVLAXK5IDMRJEREVXRBTBWMXY8OVIER";
	
	@Autowired
	private MberService mberService;
	
	public void setMberService(MberService mberService) {
		this.mberService = mberService;
	}


	@RequestMapping(value="common/main")
	public String main() {

		System.out.println("test!!!!!!!!!!!!!!!!!!!!!!!");

		String url = "common/main";

		return url;
	}

	/*
	 * 테스트용으로 설계됨
	 * iframe만 바꾸려면 추가로직 필요
	 * 그대로 쓰지 못하는 코드!!!!!!!!!!!
	 */
	@RequestMapping("/index")
	public String index(String murl, String mcode, Model model)
											throws SQLException{
		String url = "common/indexPage";

		/*
		List<MenuVO> menuList = menuService.getMainMenuList();
		MenuVO menu = menuService.getMenuByMcode(mCode);

		model.addAttribute("menuList", menuList);
		*/
		model.addAttribute("murl", murl);
		model.addAttribute("mcode", mcode);

		return url;
	}


	@RequestMapping("/index-test")
	public String indexTest(String murl, String mcode, Model model) {
		String url = "common/indexPage";

		model.addAttribute("mcode", mcode);
		model.addAttribute("murl", murl);

		return url;
	}


	@RequestMapping("/common/loginForm")
	public String loginForm(@RequestParam(defaultValue="")String error, HttpServletResponse response) {

		String url = "common/login";

		if(error.equals("1")) {
			response.setStatus(302);
		}
		return url;
	}
	
	@RequestMapping("/common/loginTimeOut")
	public String loginTimeOut(Model model) throws Exception{
		String url = "security/sessionOut";
		
		model.addAttribute("message", "세션이 만료되었습니다.\\n다시 로그인 하세요!");
		return url;
	}
	
	@RequestMapping("/security/accessDenied")
	public void accessDenied() {}

	@RequestMapping("/common/find_IdForm")
	public void find_idForm() {}
	
	@RequestMapping(value="/common/findId", method=RequestMethod.POST)
	public String find_id(MberVO mber, Model model) {
		String url = "common/check-id";
		
		MberVO user = null;
		try {
			user = mberService.getInfo(mber);
			model.addAttribute("mberId", user.getMberId());
		} catch (Exception e) {
			e.printStackTrace();
			url = "common/notFoundInfo";
		}
		
		return url;
	}

	@RequestMapping("/common/find_PwdForm")
	public void find_pwdForm() {}

	@RequestMapping(value="/common/findPwd", method=RequestMethod.POST)
	public String find_pwd(String mberNm, String mberTelno, Model model) {
		String url="common/change-password";
		
		MberVO mber = new MberVO();
		
		mber.setMberNm(mberNm);
		mber.setMberTelno(mberTelno);
		
		try {
			MberVO user = mberService.getInfo(mber);
				model.addAttribute("mberNo", user.getMberNo());
				
		} catch (Exception e) {
			e.printStackTrace();
			url = "common/notFoundInfo";
		}
		return url;
	}
	
	@RequestMapping("/common/check-id")
	public void check_id() {}

	@RequestMapping("/common/change-password")
	public void change_password() {}
	
	@RequestMapping("/common/changepass")
	public String changePass(String mberNo, String mberPwd, String SessionMberNo, HttpSession session) {
		String url = null;
		MberVO mber = new MberVO();
		if(SessionMberNo == "" || SessionMberNo == null || SessionMberNo.isEmpty()) {
			mber.setMberNo(mberNo);
		}
		if(mberNo == "" || mberNo == null || mberNo.isEmpty()) {
			mber.setMberNo(SessionMberNo);
		}
		mber.setMberPwd(mberPwd);
		
		try {
			mberService.modifyPwd(mber);
			url = "common/success";
			session.invalidate();
		} catch (Exception e) {
			e.printStackTrace();
			url = "common/error";
		}
		return url;
	}
	@RequestMapping("/common/mypage")
	public void mypage() {}

	@RequestMapping("/common/mypage-modifyform")
	public void mypage_modifyform() {}

	@RequestMapping("/common/set-session")
	public void setSession() {}

	@RequestMapping("/common/loading")
	public String loading() {
		return "common/loading";
	}

	@Autowired
	private MenuService menuService;

	@RequestMapping("/indexPage")
	public String index(@RequestParam(value="mCode", defaultValue = "M060000") String menuNo,
						HttpSession session,
			 			Model model)
			 					throws Exception{
		String url = "common/indexPage";
		
		String tempMenuNo = menuNo.substring(0,3) + "0000";
		List<MenuVO> menuList = null;
		
		menuList = menuService.getSubMenuList(tempMenuNo);
		
		/*
		MberVO loginUser = (MberVO)session.getAttribute("loginUser");
		System.out.println(loginUser);
		String mberCode = loginUser.getMberCode();
		System.out.println(mberCode.charAt(2));
		String typeCheck = String.valueOf(mberCode.charAt(2));
		
		
		if(typeCheck.equals("0")) {
			System.out.println("직원회원");
			menuList = menuService.getEmpSubMenuList(tempMenuNo);
		}else if(typeCheck.equals("2")) {
			System.out.println("대표회원");
			menuList = menuService.getSubMenuList(tempMenuNo);
		}*/
		

		MenuVO menu = menuService.getMenu(menuNo);

		model.addAttribute("menuList", menuList);
		model.addAttribute("menu", menu);

		return url;
	}

	@RequestMapping("/submenu")
	public String submenu(@RequestParam(value="mCode", defaultValue = "M020000") String menuNo, Model model)
		throws Exception{

		System.out.println("submenu with parent menuNo : " + menuNo);

		String url = "common/indexPage";

		List<MenuVO> menuList = menuService.getSubMenuList(menuNo);

		model.addAttribute("menuList", menuList);

		return url;
	}

	@RequestMapping("/common/sms")
	@ResponseBody
	public void smsOkay(@RequestBody Map<String, String> data) {
		
		String name = data.get("mberNm");
		String tel = data.get("mberTelno");
		String number = data.get("number");
		
		MberVO mber = new MberVO();
		mber.setMberNm(name);
		mber.setMberTelno(tel);
		
		MberVO user = null;
		
		try {
			user = mberService.getInfo(mber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String userNm = user.getMberNm();
		String userTelno = user.getMberTelno().replaceAll("-", "");
		
		Message coolsms = new Message(APIKEY, APISECRET);
		
		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", "01064757568");
		params.put("from", userTelno); //무조건 자기번호 (인증)
		params.put("type", "SMS");
		params.put("text", userNm+"님 COVID-19 COMPASS입니다. 비밀번호 찾기인증번호는 ["+ number +"] 입니다.");
		params.put("app_version", "test app 1.2"); // application name and version
		
		try {
			//send() 는 메시지를 보내는 함수  
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
		
		
	}
}