package com.spring.compass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pbhlth")
public class PbhlthController {

	@RequestMapping(value="main")
	public void main() {}
	
	@RequestMapping(value="smple-list")
	public String smpleList() {
		String url ="pbhlth/smple-list";
		
		return url;
	}
	@RequestMapping(value="smple-detail")
	public String smpleDetail() {
		String url ="pbhlth/smple-detail";
		
		return url;
	}
	
	@RequestMapping(value="notice-list")
	public String noticeList() {
		String url = "pbhlth/notice-list";
		
		return url;
	}
	
	@RequestMapping(value="mypage")
	public String myPage() {
		String url = "pbhlth/mypage";
		
		return url;
	}
	
	@RequestMapping(value="emp-manage-list")
	public String empManageList() {
		String url = "pbhlth/emp-manage-list";
		
		return url;
	}
	
	@RequestMapping(value="cnfrm-list")
	public String crfrmList() {
		String url = "pbhlth/cnfrm-list";
		
		return url;
	}
	@RequestMapping(value="slfptnt-list")
	public String slfptntList() {
		String url = "pbhlth/slfptnt-list";
		
		return url;
	}
	@RequestMapping(value="statistics")
	public String statistics() {
		String url ="pbhlth/statistics";
		
		return url;
	}
	
	@RequestMapping(value="cnfrm-detail-dgnss-regist")
	public String cnfrmDetailDgnssRegist() {
		String url = "pbhlth/cnfrm-detail-dgnss-regist";
		return url;
	}
	@RequestMapping(value="cnfrm-detail-dgnss-detail")
	public String cnfrmDetailDgnssDetail() {
		String url = "pbhlth/cnfrm-detail-dgnss-detail";
		
		return url;
	}
	
	@RequestMapping("res-smple-list")
	public void resSmpleList() {}
}