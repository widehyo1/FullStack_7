package com.spring.compass.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.compass.command.instRegistCommand;
import com.spring.compass.service.AdminService;
import com.spring.compass.service.HsptService;
import com.spring.compass.service.InspService;
import com.spring.compass.service.LtctService;
import com.spring.compass.service.MberService;
import com.spring.compass.service.PbhtService;
import com.spring.compass.vo.HsptVO;
import com.spring.compass.vo.InspVO;
import com.spring.compass.vo.InstVO;
import com.spring.compass.vo.LtctVO;
import com.spring.compass.vo.MberVO;
import com.spring.compass.vo.PbhtVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private InspService inspService;
	@Autowired
	private PbhtService pbhtService;
	@Autowired
	private HsptService hsptService;
	@Autowired
	private MberService mberService;
	@Autowired
	private LtctService ltctService;
	@Autowired
	private AdminService adminService;
	
	@Resource(name="instPath")
	private String instPath;

	@RequestMapping("main")
	public String adminMain() {
		String url="admin/main";
		return url;
	}

	@RequestMapping("/inst-list")
	public String insttList(){
		String url="admin/inst-list";

		return url;
	}
	@RequestMapping("/error-log-list")
	public String error() {
		String url="admin/errorlogPage";
		return url;
	}
	@RequestMapping("/access-log-list")
	public String access() {
		String url="admin/accesslogPage";
		return url;
	}

	@RequestMapping("/inst-registForm")
	public String insttRegistForm() {
		String url="admin/inst-registForm";

		return url;
	}
	@RequestMapping("/admin-emp-modifyForm")
	public String admin_emp() {
		String url = "admin/admin-emp-modifyForm";
		return url;
	}

	@RequestMapping("/notice-list")
	public String admin_notice() {
		String url = "admin/notice-list";
		return url;
	}
	@RequestMapping("/notice-detail")
	public String admin_detail() {
		String url = "admin/notice-detail";
		return url;
	}
	@RequestMapping("/notice-registForm")
	public String noticeRegistForm() {
		String url="admin/notice-registForm";
		
		return url;
	}


	@RequestMapping(value="/inst-selfRegist", method=RequestMethod.POST)
	public String selfInstRegist(instRegistCommand registCommand)throws Exception{
		InspVO insp = new InspVO();
		PbhtVO pbht = new PbhtVO();
		HsptVO hstp = new HsptVO();
		LtctVO ltct = new LtctVO();
		InstVO inst = new InstVO();
		MberVO mber = new MberVO();
		String url="";
		System.out.println("기관 직접등록");
		String writer=registCommand.getWriter();
		String checkInst = registCommand.getInst();
		String instCall=registCommand.getInstCall();
		String checkAdres = registCommand.getInstAdres();
		String instNm = registCommand.getInstName();
		
		String changeAdres = checkAdres.substring(0, checkAdres.indexOf(" "));
		
		System.out.println("instNm:"+instNm);
		System.out.println("changeAdres:"+changeAdres);
		System.out.println("changeAdresLength:"+changeAdres.length());
		System.out.println("writer:"+writer);
		System.out.println("inst:"+checkInst);
		System.out.println("isntCall:"+instCall);
		System.out.println("instAdres:"+checkAdres);
		
		switch (checkInst) {
		case "검사소":
			
			break;
		case "보건소":
			String cityNo = pbhtService.getPbhtCityNo(changeAdres);
			int pbhtSeq = pbhtService.getPbhtSeqNo();
			int instSeq = pbhtService.getInstSeqNo();
			String pbhtNo = "PBHT"+cityNo+pbhtSeq;
			String instNo = "INST"+"02"+instSeq;
			
			pbht.setCityNo(cityNo);
			pbht.setPbhtNo(pbhtNo);
			pbht.setInstNo(instNo);
			
			pbht.setInstAdres(checkAdres);
			pbht.setInstNm(instNm);
			pbht.setInstTelno(instCall);
			
			break;

		case "병원":
			break;
			
		case "생활치료센터":
			break;	
		}
		return url;
	}


	private List<Map<String, String>> instList;
	@RequestMapping(value="/inst-fileRegist", method=RequestMethod.POST)
	public String insttRegist(instRegistCommand registCommand)throws Exception{
		String url="";
		String writer=registCommand.getWriter();
		String instName = registCommand.getInst();
		String fileName =registCommand.getFileName();

		
		//확장자확인
		String extension = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
		
		String filePath = instPath+fileName;
		
		File file = new File(filePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		MultipartFile instFile = registCommand.getInstFile();
		
		instFile.transferTo(file);
		
		System.out.println("filePath:"+filePath);
		if(extension.equals("xlsx")) {
			instList =new registFileResolver().registInstXlsxFile(filePath);
		}
		if(extension.equals("xls")) {
			instList =new registFileResolver().registInstXlsFile(filePath);
		}
		
		switch (instName) {
		case "검사소":
			for(int i=0; i<instList.size(); i++) {
				InspVO insp = new InspVO();
				InstVO inst = new InstVO();
				MberVO mber = new MberVO();
				Map<String, String> needDataMap = instList.get(i);
				//System.out.println(i+"행---시도:"+test.get("city")+",주소:"+test.get("instAdres")+",전화:"+test.get("instTelNo")+",이름:"+test.get("instNm"));
				String city = needDataMap.get("city");
				String cityNo = inspService.getInspCityNo(city);
				String responsibleAgency = needDataMap.get("responsibleAgency");
				String pbhtNo = inspService.getResponsibleAgency(responsibleAgency);
				
				//System.out.println("cityNo:"+cityNo);
				String inspSeqNo = inspService.getInspSeqNo();
				String instSeqNo = inspService.getInstSeqNo();
				System.out.println("isntSeq:"+instSeqNo);
				String instNo = "INST" + "01" + instSeqNo;
				String inspNo = "INSP"+cityNo+inspSeqNo;
				
				insp.setPbhtNo(pbhtNo);
				insp.setCityNo(cityNo);
				insp.setInspNo(inspNo);
				insp.setInstAdres(needDataMap.get("instAdres"));
				insp.setInstNm(needDataMap.get("instNm"));
				insp.setInstNo(instNo);
				insp.setInstTelno(needDataMap.get("instTelNo"));
				insp.setInstCode("C101");
				
				inst.setInstNo(instNo);
				inst.setInstCode("C101");
				inst.setChildNo(inspNo);
				inst.setInstNm(needDataMap.get("instNm"));
				inst.setInstTelno(needDataMap.get("instTelNo"));
				inst.setInstAdres(needDataMap.get("instAdres"));
				
				String mberNo = mberService.getMberSeq();
				String mberId = city+ needDataMap.get("instNm").replaceAll(" ", "");
				String instTelno = needDataMap.get("instTelNo");
				String mberPwd=instTelno.replaceAll("-", "");
				mber.setMberNo(mberNo);
				mber.setInstNo(instNo);
				mber.setMberCode("B121");
				mber.setMberId(mberId);
				mber.setMberPwd(mberPwd);
				mber.setMberTelno(needDataMap.get("instTelNo"));
				mber.setMberNm(needDataMap.get("instNm"));
				mber.setMberAdres(needDataMap.get("instAdres"));
				
				int resultRegistInsp = inspService.registInsp(insp);
				adminService.registInst(inst);
				mberService.registMberRepresent(mber);
				
			}
			break;

		case "보건소":
			for(int i=0; i<instList.size(); i++) {
				PbhtVO pbht = new PbhtVO();
				InstVO inst = new InstVO();
				MberVO mber = new MberVO();
				Map<String, String> needDataMap = instList.get(i);
				String city = needDataMap.get("city");
				String cityNo = pbhtService.getPbhtCityNo(city);
				int pbhtSeq = pbhtService.getPbhtSeqNo();
				int instSeq = pbhtService.getInstSeqNo();
				String pbhtNo = "PBHT"+cityNo+pbhtSeq;
				String instNo = "INST"+"02"+instSeq;
				
				pbht.setCityNo(cityNo);
				pbht.setPbhtNo(pbhtNo);
				pbht.setInstNo(instNo);
				pbht.setInstAdres(needDataMap.get("instAdres"));
				pbht.setInstNm(needDataMap.get("instNm"));
				pbht.setInstTelno(needDataMap.get("instTelNo"));
				
				inst.setInstNo(instNo);
				inst.setInstCode("C102");
				inst.setChildNo(pbhtNo);
				inst.setInstNm(needDataMap.get("instNm"));
				inst.setInstTelno(needDataMap.get("instTelNo"));
				inst.setInstAdres(needDataMap.get("instAdres"));
				
				String mberNo = mberService.getMberSeq();
				String mberId = city+needDataMap.get("instNm").replaceAll(" ", "");
				String instTelno = needDataMap.get("instTelNo");
				String mberPwd=instTelno.replaceAll("-", "");
				mber.setMberNo(mberNo);
				mber.setInstNo(instNo);
				mber.setMberCode("B122");
				mber.setMberId(mberId);
				mber.setMberPwd(mberPwd);
				mber.setMberTelno(needDataMap.get("instTelNo"));
				mber.setMberNm(needDataMap.get("instNm"));
				mber.setMberAdres(needDataMap.get("instAdres"));
				
				int resultRegistPbht = pbhtService.registPbht(pbht);
				adminService.registInst(inst);
				mberService.registMberRepresent(mber);
			}
			break;
		
		
		case "병원":
			System.out.println("병원등록~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			for(int i=0; i<instList.size(); i++) {
				HsptVO hspt = new HsptVO();
				MberVO mber = new MberVO();
				InstVO inst = new InstVO();
				Map<String, String> needDataMap = instList.get(i);
				String city = needDataMap.get("city");
				String cityNo = hsptService.getHsptCityNo(needDataMap.get("city"));
				int hsptSeq = hsptService.getHsptSeqNo();
				int instSeq = hsptService.getInstSeqNo();
				String hsptNo = "HSPT"+cityNo+hsptSeq;
				String instNo = "INST"+"03"+instSeq;
				hspt.setCityNo(cityNo);
				hspt.setHsptNo(hsptNo);
				hspt.setInstNo(instNo);
				hspt.setInstAdres(needDataMap.get("instAdres"));
				hspt.setInstNm(needDataMap.get("instNm"));
				hspt.setInstTelno(needDataMap.get("instTelNo"));
				
				inst.setInstNo(instNo);
				inst.setInstCode("C103");
				inst.setChildNo(hsptNo);
				inst.setInstNm(needDataMap.get("instNm"));
				inst.setInstTelno(needDataMap.get("instTelNo"));
				inst.setInstAdres(needDataMap.get("instAdres"));
				
				String mberNo = mberService.getMberSeq();
				String mberId = city+ needDataMap.get("instNm").replaceAll(" ", "");
				String instTelno = needDataMap.get("instTelNo");
				String mberPwd=instTelno.replaceAll("-", "");
				mber.setMberNo(mberNo);
				mber.setInstNo(instNo);
				mber.setMberCode("B123");
				mber.setMberId(mberId);
				mber.setMberPwd(mberPwd);
				mber.setMberTelno(needDataMap.get("instTelNo"));
				mber.setMberNm(needDataMap.get("instNm"));
				mber.setMberAdres(needDataMap.get("instAdres"));
				
				int resultRegistHspt = hsptService.registHspt(hspt);
				int resultRegistInst = hsptService.registInst(hspt);
				
				mberService.registMberRepresent(mber);
			}
			
			break;
		
		case "생활치료센터":
			System.out.println("생활치료센터 등록~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("instList.size(" +instList.size());
			for(int i=0; i<instList.size(); i++) {
				LtctVO ltct = new LtctVO();
				MberVO mber = new MberVO();
				InstVO inst = new InstVO();
				
				Map<String, String> needDataMap = instList.get(i);
				String city = needDataMap.get("city");
				String cityNo = ltctService.getLtctCityNo(needDataMap.get("city"));
				int ltctSeq = ltctService.getLtctSeqNo();
				int instSeq = ltctService.getInstSeqNo();
				String ltctNo = "LTCT"+cityNo+ltctSeq;
				String instNo = "INST"+"04"+instSeq;
				ltct.setCityNo(cityNo);
				ltct.setLtctNo(ltctNo);
				ltct.setInstNo(instNo);
				ltct.setInstAdres(needDataMap.get("instAdres"));
				ltct.setInstNm(needDataMap.get("instNm"));
				ltct.setInstTelno(needDataMap.get("instTelNo"));
				
				inst.setInstNo(instNo);
				inst.setInstCode("C104");
				inst.setChildNo(ltctNo);
				inst.setInstNm(needDataMap.get("instNm"));
				inst.setInstTelno(needDataMap.get("instTelNo"));
				inst.setInstAdres(needDataMap.get("instAdres"));
				
				String mberNo = mberService.getMberSeq();
				String mberId = city + needDataMap.get("instNm").replaceAll(" ", "");
				String instTelno = needDataMap.get("instTelNo");
				String mberPwd=instTelno.replaceAll("-", "");
				mber.setMberNo(mberNo);
				mber.setInstNo(instNo);
				mber.setMberCode("B124");
				mber.setMberId(mberId);
				mber.setMberPwd(mberPwd);
				mber.setMberTelno(needDataMap.get("instTelNo"));
				mber.setMberNm(needDataMap.get("instNm"));
				mber.setMberAdres(needDataMap.get("instAdres"));
				
				ltctService.registLtct(ltct);
				ltctService.registInst(ltct);
				
				mberService.registMberRepresent(mber);
			}
			break;
		
	 }
		return url;
	}
	
	@RequestMapping("/inst-detail")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> instDetail(@RequestParam("instNo") String instNo) {
		//System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"+instNo);
		//String url="admin/inst-detail-right";
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> instMap = new HashMap<String, Object>();
//		InstVO inst = new InstVO();
//		MberVO mber = new MberVO();
		try {
			instMap = adminService.getAllInstDetail(instNo);
//			inst = (InstVO) instMap.get("inst");
//			mber = (MberVO) instMap.get("mber");
			entity = new ResponseEntity<Map<String,Object>>(instMap, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		return entity;
	}
		


}
