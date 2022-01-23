package com.spring.compass.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.compass.command.InspPstiRegistCommand;
import com.spring.compass.command.InspSmplRequestCommand;
import com.spring.compass.command.VInspPstiVO;
import com.spring.compass.service.InspService;
import com.spring.compass.vo.InspVO;
import com.spring.compass.vo.KitHistVO;
import com.spring.compass.vo.MberVO;
import com.spring.compass.vo.PcrKitVO;

@Controller
@RequestMapping(value="/insp")
public class InspController {
	
	@Autowired
	private InspService inspService;
	
	public void setInspService(InspService inspService) {
		this.inspService = inspService;
	}

	@RequestMapping(value="/main")
	public void main() {}
	
	@ResponseBody
	@RequestMapping(value="/psti-modify", method= RequestMethod.POST)
	public void pstiModify(String pstiNm, String pstiTelno, String pstiAdres, String pregnYn, String pstiNo, ModelAndView model) {
		VInspPstiVO psti = new VInspPstiVO();
		psti.setPstiNm(pstiNm);
		psti.setPstiAdres(pstiAdres);
		psti.setPstiTelno(pstiTelno);
		psti.setPregnYn(pregnYn);
		psti.setPstiNo(pstiNo);
		try {
			inspService.modifyPstiInfo(psti);
			model.addObject("pstiNm", pstiNm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="psti-list")
	public void pstiList() {}

	@RequestMapping(value="/chckd-psti-list")
	public void chckdPstiList() {}

	@RequestMapping(value="/res-psti-list")
	public void resPstiList() {}
	
	@RequestMapping(value="regist-Kit")
	public ModelAndView registKit(int inputCnt, HttpSession session, ModelAndView model) throws Exception{
		String url = null;
		
		MberVO mber = (MberVO) session.getAttribute("loginUser");
		InspVO insp = (InspVO) session.getAttribute("loginInst");
		
		KitHistVO kitHist = new KitHistVO();
		kitHist.setInputCnt(inputCnt);
		kitHist.setInspempNo(mber.getMberNo());
		kitHist.setInspNo(insp.getInspNo());

		try {
			inspService.registKitHist(kitHist);
			url = "insp/success";
		} catch (Exception e) {
			e.printStackTrace();
			url = "insp/error";
		}
		
		model.setViewName(url);
		return model;
	}
	
	@RequestMapping(value="regist-Question")
	@ResponseBody
	public ModelAndView registQuestion(InspPstiRegistCommand psti, HttpSession session, ModelAndView model) {

		String url = null;
		
		InspVO insp = (InspVO) session.getAttribute("loginInst");
		
		try {
			url = "insp/kitCountZero";
			int kitCount = inspService.getPcrKitCount(insp.getInspNo());

			
			if(kitCount>0) {
				kitCount = kitCount - 1;
				psti.setRmndKitCnt(kitCount);
				psti.setInspNo(insp.getInspNo());
				
				inspService.registQuestion(psti);
				url = "insp/succeess";
			}
		} catch (Exception e) {
			e.printStackTrace();
			url = "insp/error";
		}
		model.setViewName(url);
		return model;
	}
	
	@RequestMapping(value="regist-Request-Smpl")
	public ModelAndView registRequestSmpl(String[] pstiNo, HttpSession session, ModelAndView model) {
		String url = "insp/succeess";
		InspSmplRequestCommand smplRequest = new InspSmplRequestCommand();
		InspVO insp = (InspVO) session.getAttribute("loginInst");
		
		for(String psti : pstiNo) {
			smplRequest.setPbhtNo(insp.getPbhtNo());
			smplRequest.setInstNo(insp.getInstNo());
			smplRequest.setInstNm(insp.getInstNm());
			smplRequest.setPstiNo(psti);
			
			try {
				String manageNo = inspService.getManageNoByPstiNo(psti);
				if(manageNo != null || !manageNo.isEmpty() || manageNo != "") {
					smplRequest.setManageNo(manageNo);
				}
				inspService.registRequestSmpl(smplRequest);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.setViewName(url);
		return model;
	}
	
	@RequestMapping(value="/psti-regist-form")
	public ModelAndView pstiRegistform(String pstiNo, ModelAndView model) {
		String url = "insp/psti-regist-form";
		try {
			VInspPstiVO psti = inspService.getPstiDetail(pstiNo);
			String pstiRechckd = psti.getRechkdYn();
			if(pstiRechckd.equals("Y")) {
				psti.setRechkdYn("자가격리");
			}else {
				psti.setRechkdYn("본인판단");
			}
			String pstiGender = psti.getGender();
			if(pstiGender.equals("M")) {
				psti.setGender("남");
			}else {
				psti.setGender("여");
			}
			model.addObject("psti", psti);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.setViewName(url);
		return model;
	}

	@RequestMapping("/pcrKitForm")
	public ModelAndView pcrKitForm(HttpSession session, ModelAndView model) {
		String url = "insp/pcrKitForm";
		InspVO insp = (InspVO)(session.getAttribute("loginInst"));;
		String inspNo = insp.getInspNo();
		try {
			int kitCount = inspService.getPcrKitCount(insp.getInspNo());
			List<PcrKitVO> kitList = inspService.getPcrKitList(insp.getInspNo());
			int totalKitCount = inspService.getTotalKitCount(insp.getInspNo());
			model.addObject("kitCount", kitCount);
			model.addObject("kitList", kitList);
			model.addObject("totalKitCount", totalKitCount);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		model.setViewName(url);
		return model;
	}

	@RequestMapping(value="/qrcode")
	public void qrcode() {}

	@RequestMapping("/emp-manage-list")
	public void empManageList(){}

	@RequestMapping("/psti-regist")
	public void pstiRegist() {}

	@RequestMapping("/emp-manage-registform")
	public void empManageRegistform(){}

	@RequestMapping("/dataTableSample")
	public void dataTableSample(){}

	@RequestMapping("/datatable-psti-list")
	public void datatablePstiList(){}

	@RequestMapping("/mypage")
	public void myPage() {}

	@RequestMapping("/mypage-modifyform")
	public void mypageModifyform() {}
	
	
	@RequestMapping("/notice-list")
	public void noticeList() {}
	@RequestMapping("/notice-modify")
	public void noticeModify() {}
	@RequestMapping("/notice-modifyform")
	public void noticeModifyform() {}
	@RequestMapping("/notice-regist")
	public void noticeRegist() {}
	@RequestMapping("/notice-registform")
	public void noticeRegistform() {}
	
	
	@RequestMapping("/statistics")
	public void statistics() {}

}


