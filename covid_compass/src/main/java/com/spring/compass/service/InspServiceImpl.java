package com.spring.compass.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.compass.command.InspChckdPstiListCommand;
import com.spring.compass.command.InspListVO;
import com.spring.compass.command.InspPstiSearchCommand;
import com.spring.compass.command.PageMaker;
import com.spring.compass.command.VInspPstiResultVO;
import com.spring.compass.command.VInspPstiVO;
import com.spring.compass.dao.InspDAO;
import com.spring.compass.vo.InspVO;

public class InspServiceImpl implements InspService{

	private InspDAO inspDAO = null;

	public void setInspDAO(InspDAO inspDAO) {
		this.inspDAO = inspDAO;
	}

	@Override
	public InspVO getInspByInstNo(String instNo) throws Exception {
		InspVO insp = inspDAO.selectInspByInstNo(instNo);
		return insp;
	}

	@Override
	public String getInspCityNo(String city) throws Exception {
		String cityNo = inspDAO.selectInspCityNo(city);
		return cityNo;
	}

	@Override
	public String getInspSeqNo() throws Exception {
		String inspSeqNo = inspDAO.selectInspNextval();
		return inspSeqNo;
	}

	@Override
	public String getInstSeqNo() throws Exception {
		String instSeqNo = inspDAO.selectInstNextval();
		return instSeqNo;
	}

	@Override
	public int registInsp(InspVO insp) throws Exception {
		int result = inspDAO.insertInsp(insp);
		return result;
	}

	@Override
	public int registInst(InspVO insp) throws Exception {
		System.out.println("registInst before");
		System.out.println(insp);
		int result = inspDAO.insertInst(insp);
		System.out.println("registInst after");
		return result;
	}

	@Override
	public String getResponsibleAgency(String responsible) throws Exception {
		String responsi = inspDAO.selectResponsibleAgency(responsible);
		return responsi;
	}

	@Override
	public Map<String, Object> getPstiListPage(InspPstiSearchCommand cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		PageMaker pageMaker = null;
		
		pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		int totalCount = inspDAO.selectPstiListCount(cri);
		
		pageMaker.setTotalCount(totalCount);
		
		List<VInspPstiVO> pstiList = inspDAO.selectPstiList(cri);
		
		dataMap.put("pstiList", pstiList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public Map<String, Object> getChckdListPage(InspPstiSearchCommand cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		PageMaker pageMaker = null;
		
		pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		int totalCount = inspDAO.selectChckdListCount(cri);
		
		pageMaker.setTotalCount(totalCount);
		
		List<VInspPstiVO> chckdList = inspDAO.selectChckdList(cri);
		
		dataMap.put("chckdList", chckdList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public Map<String, Object> getResultListPage(InspPstiSearchCommand cri) throws Exception {
		Map<String, Object> dataMap = new HashMap<String , Object>();
		PageMaker pageMaker = null;
		
		pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		int totalCount = inspDAO.selectResultListCount(cri);
		
		pageMaker.setTotalCount(totalCount);
		
		List<VInspPstiResultVO> resultList = inspDAO.selectResultList(cri);
		
		dataMap.put("resultList", resultList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}

	@Override
	public VInspPstiVO getPstiDetail(String pstiNo) throws Exception {
		VInspPstiVO psti = inspDAO.selectPstiDetail(pstiNo);
		return psti;
	}

	@Override
	public VInspPstiResultVO getResultDetail(String pstiNo) throws Exception {
		VInspPstiResultVO result = inspDAO.selectResultDetail(pstiNo);
		return result;
	}
	


}
