package com.spring.compass.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.compass.command.DgnssListSearchCommand;
import com.spring.compass.command.DgnssListVO;
import com.spring.compass.command.InptntListSearchCommand;
import com.spring.compass.command.InptntListVO;
import com.spring.compass.command.PageMaker;
import com.spring.compass.command.ReqInptntListCommand;
import com.spring.compass.command.SckbdreqLtctListCommand;
import com.spring.compass.dao.HsptDAO;
import com.spring.compass.dao.LtctDAO;
import com.spring.compass.dao.PbhtDAO;
import com.spring.compass.dao.PstiDAO;
import com.spring.compass.util.ErrorCodeUtil;
import com.spring.compass.vo.DgnssResultVO;
import com.spring.compass.vo.HsptVO;
import com.spring.compass.vo.InptntVO;
import com.spring.compass.vo.IsoptntVO;
import com.spring.compass.vo.LtctVO;
import com.spring.compass.vo.ManageVO;
import com.spring.compass.vo.PbhtVO;
import com.spring.compass.vo.PstiVO;
import com.spring.compass.vo.SckbdreqVO;
import com.spring.compass.vo.SlfptntVO;
import com.spring.compass.vo.SmplResultVO;
import com.spring.compass.vo.SmplVO;

public class HsptServiceImplLKH extends HsptServiceImpl implements HsptSerivceLKH{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HsptServiceImplLKH.class);	
	
	private PbhtDAO pbhtDAO;
	private LtctDAO ltctDAO;
	private HsptDAO hsptDAO;
	
	private PstiDAO pstiDAO;
	
	public void setPstiDAO(PstiDAO pstiDAO) {
		this.pstiDAO = pstiDAO;
	}
	
	public void setHsptDAO(HsptDAO hsptDAO) {
		this.hsptDAO = hsptDAO;
	}
	public void setPbhtDAO(PbhtDAO pbhtDAO) {
		this.pbhtDAO = pbhtDAO;
	}
	public void setLtctDAO(LtctDAO ltctDAO) {
		this.ltctDAO = ltctDAO;
	}
	
	/*
	 * ---------------------------------------------------------------
	 * update	manage				|	#{sttusCode} #{instNm} #{instNo} #{manageNo} 								: 소속기관 및 상태수정
	 * update	manage				|	#{instNm} #{instNo} #{manageNo}												: 소속기관만 수정
	 * update	manage				|	#{sttusCode} #{manageNo}													: 상태만 수정
	 * update	dgnss				|	#{dgnssNo}																	: 검사완료 상태로 수정
	 * update	hspt				|	#{hsptNo}																	: 잔여병상수 수정 (증가 혹은 감소)
	 * update	ltct				|	#{ltctNo}																	: 잔여병상수 수정 (증가 혹은 감소)
	 * update	inptnt				|	#{hsptlzCode} #{inptntNo}													: 입원상태 변경(퇴원)
	 * update	isoptnt				|	#{hsptlzCode} #{isoptntNo}													: 입소상태 변경(퇴원)
	 * update	psti				|	#{pstiNm} #{pstiTelno} #{pstiAdres} #{symptms} #{areaNo} #{pstiNo}			: 입원환자 정보수정
	 * update	sckbdreq			|	#{sckbdreqNo} #{sckbdreqCode} #{acceptYmd}									: 병상신청 상태변경(승인)
	 * update	sckbdreq			|	#{sckbdreqNo} #{sckbdreqCode} 												: 병상신청 상태변경(취소 혹은 반려)
	 * insert	inptnt				|	#{inpntNo} #{hsptNo} #{manageNo}											: 입원환자 등록
	 * insert	dgnss_result		|	#{dgnssNo} #{dgnssResultCode} #{dgnssNote}									: 진료결과 등록
	 * insert	sckbdreq			|	#{sckbdreqNo} #{type} #{childNo} #{hsptNo} #{manageNo} #{requestCode}		: 병상신청 등록
	 * insert	slfptnt				|	#{slfptntNo} #{pbhtNo} #{manageNo}											: 자가격리자 등록
	 * insert	smpl				|	#{smplNo} #{manageNo} #{pbhtNo} #{instNo}									: 재검신청 등록
	 * ---------------------------------------------------------------
	 */
	
	private void updateManageChangeAllService(String msg, String manageNo, String sttusCode, HsptVO hspt) throws Exception{
		
		ManageVO manage = new ManageVO(); 
		manage.setSttusCode(sttusCode);
		manage.setInstNm(hspt.getInstNm());
		manage.setInstNo(hspt.getInstNo());
		manage.setManageNo(manageNo);	
		
		if(hsptDAO.updateManageChangeAll(manage) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_06");		
		}
		
		LOGGER.debug(msg);
		
	}

	private void updateManageChangeInstService(String msg, String manageNo, HsptVO hspt) throws Exception{
		ManageVO manage = new ManageVO();
		manage.setInstNm(hspt.getInstNm());
		manage.setInstNo(hspt.getInstNo());
		manage.setManageNo(manageNo);
		
		LOGGER.debug("{}",manage);
		
		if(hsptDAO.updateManageChangeInst(manage) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_06");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	private void updateManageChangeStatusService(String msg, String manageNo, String sttusCode) throws Exception{
		
		ManageVO manage = new ManageVO();
		manage.setSttusCode(sttusCode);
		manage.setManageNo(manageNo);
		
		if(hsptDAO.updateManageChangeStatus(manage) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_06");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	private void updateDgnssCodeChkdService(String msg, String dgnssNo) throws Exception{
		
		if(hsptDAO.updateDgnssCodeChkd(dgnssNo) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_03");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	private void insertDgnssResultService(String msg, DgnssResultVO dgnssResult) throws Exception{
		
		if(hsptDAO.insertDgnssResult(dgnssResult) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_04");		
		}
		
		LOGGER.debug(msg);
		
	}

	private void insertInptntService(String msg, String manageNo, String hsptNo) throws Exception{
		
		String inptntNo = pstiDAO.selectInptntNextVal();
		InptntVO inptnt = new InptntVO();
		
		inptnt.setInptntNo(inptntNo);
		inptnt.setHsptNo(hsptNo);
		inptnt.setManageNo(manageNo);
		
		LOGGER.debug("{}",inptnt);
		
		if(hsptDAO.insertInptnt(inptnt) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_05");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	private void insertSckbdreqService(String msg, String manageNo, String requestCode, String type, String childNo, HsptVO loginHspt) throws Exception{
		
		String sckbdreqNo = pstiDAO.selectSckbdreqNextVal();
	    String hsptNo = loginHspt.getHsptNo();

	    SckbdreqVO sckbdreq = new SckbdreqVO();
	    sckbdreq.setSckbdreqNo(sckbdreqNo);
	    sckbdreq.setType(type);
	    sckbdreq.setChildNo(childNo);
	    sckbdreq.setHsptNo(hsptNo);
	    sckbdreq.setManageNo(manageNo);
	    sckbdreq.setRequestCode(requestCode);
	    
	    LOGGER.debug("{}",sckbdreq);
	    
		if(hsptDAO.insertSckbdreq(sckbdreq) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_07");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	private void updateIncreaseRmndSckbdCntByHsptNoService(String msg, String hsptNo) throws Exception{
		
		if(hsptDAO.updateIncreaseRmndSckbdCntByHsptNo(hsptNo) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_08");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	private void updateDecreaseRmndSckbdCntByHsptNoService(String msg, String hsptNo) throws Exception{

		if(hsptDAO.updateDecreaseRmndSckbdCntByHsptNo(hsptNo) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_08");		
		}
		
		LOGGER.debug(msg);
		
	}

	private void updateIncreaseRmndSckbdCntByLtctNoService(String msg, String ltctNo) throws Exception{
		
		if(hsptDAO.updateIncreaseRmndSckbdCntByLtctNo(ltctNo) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_08");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	private void updateDecreaseRmndSckbdCntByLtctNoService(String msg, String ltctNo) throws Exception{

		if(hsptDAO.updateDecreaseRmndSckbdCntByLtctNo(ltctNo) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_08");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	private void updateIsoptntExitService(String msg, String manageNo, String hsptlzCode) throws Exception{

		IsoptntVO isoptnt = pstiDAO.selectIsoptntByManageNo(manageNo);
		String isoptntNo = isoptnt.getIsoptntNo();
		
		isoptnt.setHsptlzCode(hsptlzCode);
		isoptnt.setIsoptntNo(isoptntNo);
		
		LOGGER.debug("{}",isoptnt);
		
		if(hsptDAO.updateIsoptntExit(isoptnt) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_10");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	private void insertSmplService(String msg, String manageNo, String hsptNo, String pbhtNo) throws Exception{

		String smplNo = pstiDAO.selectSmplNextVal();
		
		String instNo = hsptNo;
		
		SmplVO smpl = new SmplVO();
		
		smpl.setSmplNo(smplNo);
		smpl.setInstNo(instNo);
		smpl.setManageNo(manageNo);
		smpl.setPbhtNo(pbhtNo);
		
		if(hsptDAO.insertSmpl(smpl) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_11");		
		}
		
		LOGGER.debug(msg);
		
	}

	private void updateSckbdreqAcceptService(String msg, String sckbdreqNo, String sckbdreqCode) throws Exception{
		
		Date acceptYmd = new Date();
		
		SckbdreqVO sckbdreq = new SckbdreqVO();
		sckbdreq.setSckbdreqNo(sckbdreqNo);
		sckbdreq.setSckbdreqCode(sckbdreqCode);
		sckbdreq.setAcceptYmd(acceptYmd);
		
		LOGGER.debug("{}", sckbdreq);
		
		if(hsptDAO.updateSckbdreqAccept(sckbdreq) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_13");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	private void updateInptntExitService(String msg, String inptntNo, String hsptlzCode) throws Exception{
		
		InptntVO inptntOrigin = new InptntVO();
		
		inptntOrigin.setHsptlzCode(hsptlzCode);
		inptntOrigin.setInptntNo(inptntNo);
		
		LOGGER.debug("{}", inptntOrigin);
		
		if(hsptDAO.updateInptntExit(inptntOrigin) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_14");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	private void insertSlfptntService(String msg, String manageNo, String pbhtNo) throws Exception{
		
		String slfptntNo = pstiDAO.selectSlfptntNextVal();
		
		SlfptntVO slfptnt = new SlfptntVO();
		
		slfptnt.setSlfptntNo(slfptntNo);
		slfptnt.setPbhtNo(pbhtNo);
		slfptnt.setManageNo(manageNo);
		
		if(hsptDAO.insertSlfptnt(slfptnt) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_09");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	private void updateSckbdreqCodeOnlyService(String msg, String sckbdreqNo, String sckbdreqCode) throws Exception{
		
		SckbdreqVO sckbdreq = new SckbdreqVO();
		
		sckbdreq.setSckbdreqCode(sckbdreqCode);
		sckbdreq.setSckbdreqNo(sckbdreqNo);
		
		LOGGER.debug("{}", sckbdreq);
		
		if(hsptDAO.updateSckbdreqCodeOnly(sckbdreq) == 0) 	{
			msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_16");		
		}
		
		LOGGER.debug(msg);
		
	}
	
	
	@Override
	public Map<String, Object> getDgnssList(DgnssListSearchCommand cri) throws SQLException {
		Map<String, Object> dataMap = null;
		
		PageMaker pageMaker = null;
		
		pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		int totalCount = hsptDAO.selectDgnssListCount(cri);
		
		LOGGER.debug("{}",totalCount);
		
		pageMaker.setTotalCount(totalCount);
		
		List<DgnssListVO> dgnssList = hsptDAO.selectDgnssList(cri);
		
		dataMap = new HashMap<String, Object>();
		
		LOGGER.debug("{}",pageMaker);
		
		for(int i = 0; i < dgnssList.size(); i++) {
			
			DgnssListVO dgnss = dgnssList.get(i);
			if(dgnss.getType().equals("A")) {
				String pbhtNo = dgnss.getChildNo();
				PbhtVO pbht = pbhtDAO.selectPbhtByPbhtNo(pbhtNo);
				dgnss.setPbhtNm(pbht.getInstNm());
				
				dgnss.setPbht(true);
				
			}else if(dgnss.getType().equals("B")) {
				String ltctNo = dgnss.getChildNo();
				LtctVO ltct = ltctDAO.selectLtctByLtctNo(ltctNo);
				dgnss.setLtctNm(ltct.getInstNm());
				dgnss.setPbht(false);
			}
			
			dgnssList.set(i, dgnss);
		}
		for(DgnssListVO dgnss : dgnssList) {
			LOGGER.debug("{}",dgnss);
		}
		dataMap.put("dgnssList", dgnssList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}
	@Override
	public Map<String, Object> getReqInptntList(InptntListSearchCommand cri) throws Exception {
		Map<String, Object> dataMap = null;
		
		PageMaker pageMaker = null;
		
		pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		
		int totalCount = hsptDAO.selectReqInptntListCount(cri);
		
		LOGGER.debug("{}",totalCount);
		
		pageMaker.setTotalCount(totalCount);
		
		List<ReqInptntListCommand> reqInptntList = hsptDAO.selectReqInptntList(cri);
		dataMap = new HashMap<String, Object>();
		
		for(ReqInptntListCommand reqInptnt : reqInptntList) {
			LOGGER.debug("{}",reqInptnt);
		}
		
		dataMap.put("reqInptntList", reqInptntList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}
	@Override
	public Map<String, Object> getInptntList(InptntListSearchCommand cri) throws Exception {

		Map<String, Object> dataMap = null;

		PageMaker pageMaker = null;

		pageMaker = new PageMaker();
		pageMaker.setCri(cri);


		LOGGER.debug(String.valueOf(hsptDAO == null));


		int totalCount = hsptDAO.selectInptntListCount(cri);

		LOGGER.debug("{}",totalCount);

		pageMaker.setTotalCount(totalCount);

		List<InptntListVO> inptntList = hsptDAO.selectInptntList(cri);

		dataMap = new HashMap<String, Object>();

		dataMap.put("inptntList", inptntList);
		dataMap.put("pageMaker", pageMaker);

		LOGGER.debug("{}",pageMaker);

		for(InptntListVO inptnt : inptntList) {
			LOGGER.debug("{}",inptnt);
		}

		return dataMap;
	}
	@Override
	public Map<String, Object> getSckbdreqHsptList(InptntListSearchCommand cri) throws Exception {

		Map<String, Object> dataMap = null;

		PageMaker pageMaker = null;

		pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		int totalCount = hsptDAO.selectSckbdReqHsptListCount(cri);

		LOGGER.debug("{}",totalCount);

		pageMaker.setTotalCount(totalCount);

		List<ReqInptntListCommand> sckbdreqList = hsptDAO.selectSckbdReqHsptList(cri);

		dataMap = new HashMap<String, Object>();

		dataMap.put("sckbdreqList", sckbdreqList);
		dataMap.put("pageMaker", pageMaker);

		LOGGER.debug("{}",pageMaker);

		for(ReqInptntListCommand sckbdreq : sckbdreqList) {
			LOGGER.debug("{}",sckbdreq);
		}

		return dataMap;
	}
	@Override
	public Map<String, Object> getSckbdreqLtctList(InptntListSearchCommand cri) throws Exception {
		Map<String, Object> dataMap = null;

		PageMaker pageMaker = null;

		pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		int totalCount = hsptDAO.selectSckbdReqLtctListCount(cri);

		LOGGER.debug("{}",totalCount);

		pageMaker.setTotalCount(totalCount);

		List<SckbdreqLtctListCommand> sckbdreqList = hsptDAO.selectSckbdReqLtctList(cri);

		dataMap = new HashMap<String, Object>();

		dataMap.put("sckbdreqList", sckbdreqList);
		dataMap.put("pageMaker", pageMaker);

		LOGGER.debug("{}",pageMaker);

		for(SckbdreqLtctListCommand sckbdreq : sckbdreqList) {
			LOGGER.debug("{}",sckbdreq);
		}

		return dataMap;
	}
	
	@Override
	public HsptVO getHsptByHsptNo(String hsptNo) throws Exception {
		HsptVO hspt = hsptDAO.selectHsptByHsptNo(hsptNo);
		return hspt;
	}

	@Override
	public String registInptntByDgnss(DgnssResultVO dgnssResult, HsptVO loginHspt) throws Exception {
		// 보건소에서 요청한 신규환자를 진료하고 바로 입원시키는 메서드
		//-------------------------------------------------
		// insert	inptnt				|	#{inpntNo} #{hsptNo} #{manageNo}
		//			dgnss_result		|	#{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		// update	manage				|	#{sttusCode} #{instNm} #{instNo} #{manageNo}
		//			dgnss				|	#{dgnssNo}
		//--------------------------------------------------
		String msg = "success";
		
		// 1. 사전준비
		String manageNo = dgnssResult.getManageNo();
		String dgnssNo = dgnssResult.getDgnssNo();
		String hsptNo = loginHspt.getHsptNo();
		
		LOGGER.debug("manageNo : {}, dgnssNo : {}", manageNo, dgnssNo);
		
		// 2. 진료 테이블 수정 #{dgnssNo}
		updateDgnssCodeChkdService(msg, dgnssNo);
		
		// 3. 진료결과 등록 #{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		insertDgnssResultService(msg, dgnssResult);
		
		// 4. 입원환자 등록 #{inptntNo} #{hsptNo} #{manageNo}
		insertInptntService(msg, manageNo, hsptNo);
		
		// 5. manage 테이블 수정 #{sttusCode} #{instNm} #{instNo} #{manageNo}
		updateManageChangeAllService(msg, manageNo, "A105", loginHspt);
		
		return msg;
	}

	@Override
	public String registSckbdreqInptntByDgnss(DgnssResultVO dgnssResult, HsptVO loginHspt, String toHsptNo)
			throws Exception {
		// 보건소에서 요청한 신규환자를 진료하고 이원신청하는 메서드
		//-------------------------------------------------
		// insert	sckbdreq			|	#{sckbdreqNo} #{type} #{childNo} #{hsptNo} #{manageNo} #{requestCode}
		//			dgnss_result		|	#{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		// update	manage				|	#{sttusCode} #{instNm} #{instNo} #{manageNo}
		//			dgnss				|	#{dgnssNo}
		//			hspt				|	#{hsptNo}
		//--------------------------------------------------
		String msg = "success";
		
		// 1. 사전준비
		String manageNo = dgnssResult.getManageNo();
		String dgnssNo = dgnssResult.getDgnssNo();
		
		// 2. 진료 테이블 수정 #{dgnssNo}
		updateDgnssCodeChkdService(msg, dgnssNo);
		
		// 3. 진료결과 등록 #{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		insertDgnssResultService(msg, dgnssResult);
		
		// 4. 병상신청 등록 #{sckbdreqNo} #{type} #{childNo} #{hsptNo} #{manageNo} #{requestCode}
		insertSckbdreqService(msg, manageNo, "M101", "A", toHsptNo, loginHspt);
		
		// 5. 이원대상 병원 잔여병상 수정
		updateDecreaseRmndSckbdCntByHsptNoService(msg, toHsptNo);
		
		// 6. manage 테이블 수정  #{sttusCode} #{instNm} #{instNo} #{manageNo}
		updateManageChangeAllService(msg, manageNo, "A110", loginHspt);
		
		return msg;
	}

	@Override
	public String registSckbdreqIsoptntByDgnss(DgnssResultVO dgnssResult, HsptVO loginHspt, String toLtctNo)
			throws Exception {
		// 보건소에서 요청한 신규환자를 진료하고 입소신청하는 메서드
		//-------------------------------------------------
		// insert	sckbdreq			|	#{sckbdreqNo} #{type} #{childNo} #{hsptNo} #{manageNo} #{requestCode}
		//			dgnss_result		|	#{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		// update	manage				|	#{sttusCode} #{instNm} #{instNo} #{manageNo}
		//			dgnss				|	#{dgnssNo}
		//			ltct				|	#{ltctNo}
		//--------------------------------------------------	
		String msg = "success";
		
		// 1. 사전준비
		String manageNo = dgnssResult.getManageNo();
		String dgnssNo = dgnssResult.getDgnssNo();
		
		// 2. 진료 테이블 수정 #{dgnssNo}
		updateDgnssCodeChkdService(msg, dgnssNo);
		
		// 3. 진료결과 등록 #{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		insertDgnssResultService(msg, dgnssResult);
		
		// 4. 병상신청 등록 #{sckbdreqNo} #{type} #{childNo} #{hsptNo} #{manageNo} #{requestCode}
		insertSckbdreqService(msg, manageNo, "M101", "B", toLtctNo, loginHspt);
		
		// 5. 입소대상 생활치료센터 잔여병상 수정
		updateDecreaseRmndSckbdCntByLtctNoService(msg, toLtctNo);
		
		// 6. manage 테이블 수정  #{sttusCode} #{instNm} #{instNo} #{manageNo}
		updateManageChangeAllService(msg, manageNo, "A111", loginHspt);
		
		return msg;
	}

	@Override
	public String registSlfptntByDgnss(DgnssResultVO dgnssResult, HsptVO loginHspt) throws Exception {
		// 보건소에서 요청한 신규환자를 진료하고 자가격리처리하는 메서드
		//-------------------------------------------------
		// insert	slfptnt				|	#{slfptntNo} #{pbhtNo} #{manageNo}
		//			dgnss_result		|	#{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		// update	manage				|	#{sttusCode} #{manageNo}
		//			dgnss				|	#{dgnssNo}
		//			hspt				|	#{hsptNo}		
		//--------------------------------------------------	
		String msg = "success";
		
		// 1. 사전준비
		String manageNo = dgnssResult.getManageNo();
		String dgnssNo = dgnssResult.getDgnssNo();
		SmplResultVO smplResult = pstiDAO.selectVSmplResultByManageNo(manageNo);
		String pbhtNo = smplResult.getPbhtNo();
		String hsptNo = loginHspt.getHsptNo();
		
		// 2. 진료 테이블 수정 #{dgnssNo}
		updateDgnssCodeChkdService(msg, dgnssNo);
		
		// 3. 진료결과 등록 #{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		insertDgnssResultService(msg, dgnssResult);
		
		// 4. 자가격리자 등록 #{slfptntNo} #{pbhtNo} #{manageNo}
		insertSlfptntService(msg, manageNo, pbhtNo);

		// 5. 병원 잔여병상 수정 #{hsptNo}
		updateIncreaseRmndSckbdCntByHsptNoService(msg, hsptNo);
	    
		// 6. manage 테이블 수정 #{sttusCode} #{manageNo}
		updateManageChangeStatusService(msg, manageNo, "A107");
		
		return msg;
	}

	@Override
	public String registDgnssResultByIsoptnt(DgnssResultVO dgnssResult, HsptVO loginHspt) throws Exception {
		// 생활치료센터에서 요청한 환자를 진료하고 별도의 사후처리를 하지 않는 메서드
		//-------------------------------------------------
		// insert	dgnss_result		|	#{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		// update	dgnss				|	#{dgnssNo}
		//			hspt				|	#{hsptNo}		
		//--------------------------------------------------	
		String msg = "success";
		
		// 1. 사전준비
		String dgnssNo = dgnssResult.getDgnssNo();
		String hsptNo = loginHspt.getHsptNo();
		
		// 2. 진료 테이블 수정 #{dgnssNo}
		updateDgnssCodeChkdService(msg, dgnssNo);
		
		// 3. 진료결과 등록 #{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		insertDgnssResultService(msg, dgnssResult);

		// 4. 병원 잔여병상 수정 #{hsptNo}
		updateIncreaseRmndSckbdCntByHsptNoService(msg, hsptNo);
		
		return msg;
	}

	@Override
	public String registSckbdreqInptntByIsoptnt(DgnssResultVO dgnssResult, HsptVO loginHspt, String toHsptNo,
			String fromLtctNo) throws Exception {
		// 생활치료센터에서 요청한 환자를 진료하고 이원신청하는 메서드
		//-------------------------------------------------
		// insert	sckbdreq			|	#{sckbdreqNo} #{type} #{childNo} #{hsptNo} #{manageNo} #{requestCode}
		//			dgnss_result		|	#{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		// update	manage				|	#{sttusCode} #{instNm} #{instNo} #{manageNo}
		//			dgnss				|	#{dgnssNo}
		//			hspt				|	#{hsptNo}
		//--------------------------------------------------
		String msg = "success";
		
		// 1. 사전준비
		String manageNo = dgnssResult.getManageNo();
		String dgnssNo = dgnssResult.getDgnssNo();
		
		// 2. 진료 테이블 수정 #{dgnssNo}
		updateDgnssCodeChkdService(msg, dgnssNo);
		
		// 3. 진료결과 등록 #{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		insertDgnssResultService(msg, dgnssResult);
		
		// 4. 병상신청 등록 #{sckbdreqNo} #{type} #{childNo} #{hsptNo} #{manageNo} #{requestCode}
		insertSckbdreqService(msg, manageNo, "M103", "A", toHsptNo, loginHspt);
	    
		// 5. 이원대상 병원 잔여병상 수정 #{hsptNo}
		updateDecreaseRmndSckbdCntByHsptNoService(msg, toHsptNo);
	    
		// 6. manage 테이블 수정  #{sttusCode} #{instNm} #{instNo} #{manageNo}
		updateManageChangeAllService(msg, manageNo, "A110", loginHspt);
		
		return msg;
	}

	@Override
	public String registInptntByIsoptnt(DgnssResultVO dgnssResult, HsptVO loginHspt, String fromLtctNo)
			throws Exception {
		// 생활치료센터에서 진료요청한 환자를 진료하고 입원처리하는 메서드
		//-------------------------------------------------
		// insert	inptnt				|	#{inpntNo} #{hsptNo} #{manageNo}
		//			dgnss_result		|	#{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		// update	manage				|	#{sttusCode} #{instNm} #{instNo} #{manageNo}
		//			dgnss				|	#{dgnssNo}
		//			ltct				|	#{ltctNo}
		//			isoptnt				|	#{hsptlzCode} #{isoptntNo}
		//--------------------------------------------------
		String msg = "success";
		
		// 1. 사전준비
		String manageNo = dgnssResult.getManageNo();
		String dgnssNo = dgnssResult.getDgnssNo();
		String hsptNo = loginHspt.getHsptNo();
		
		// 2. 진료 테이블 수정 #{dgnssNo}
		updateDgnssCodeChkdService(msg, dgnssNo);
		
		// 3. 진료결과 등록 #{dgnssNo} #{dgnssResultCode} #{dgnssNote}
		insertDgnssResultService(msg, dgnssResult);
		
		// 4. 입원환자 등록 #{inpntNo} #{hsptNo} #{manageNo}
		insertInptntService(msg, manageNo, hsptNo);
		
		// 5. 생활치료센터 잔여병상 수정 #{ltctNo}
		updateIncreaseRmndSckbdCntByLtctNoService(msg, fromLtctNo);
		
		// 6. 입소자 상태 변경(퇴원처리) #{hsptlzCode} #{isoptntNo}
		updateIsoptntExitService(msg, manageNo, "E103");
		
		// 7. manage 테이블 수정 #{sttusCode} #{instNm} #{instNo} #{manageNo}
		updateManageChangeAllService(msg, manageNo, "A105", loginHspt);
		
		return msg;
	}

	@Override
	public String registSmplByInptnt(String hsptNo, String pbhtNo, String manageNo) throws Exception {
		// 입원환자를 재검신청하는 메서드
		//-------------------------------------------------
		// insert	smpl				|	#{smplNo} #{manageNo} #{pbhtNo} #{instNo}
		//--------------------------------------------------	
		String msg = "success";
		
		// 1. 시료 입력 #{smplNo} #{manageNo} #{pbhtNo} #{instNo}
		insertSmplService(msg, manageNo, hsptNo, pbhtNo);
		
		return msg;
	}

	@Override
	public String registSmplByInptnt(String hsptNo, String pbhtNo, List<String> manageNoList) throws Exception {
		// 입원환자를 재검신청하는 메서드(일괄처리)
		//-------------------------------------------------
		// insert	smpl				|	#{smplNo} #{manageNo} #{pbhtNo} #{instNo}
		//--------------------------------------------------	
		String msg = "success";
		int test = 0;
		
		for(String manageNo : manageNoList) {
			// 1. 시료 입력 #{smplNo} #{manageNo} #{pbhtNo} #{instNo}
			msg = registSmplByInptnt(hsptNo, pbhtNo, manageNo);
			test = msg.equals("success") ? test + 1 : test;
		}
		
		if(test != manageNoList.size()) msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_12");
		
		return msg;
	}
	
	@Override
	public String registSckbdreqInptntByInptnt(String toHsptNo, HsptVO loginHspt, String manageNo) throws Exception{
		// 입원중 환자를 이원신청하는 메서드
		//-------------------------------------------------
		// insert	sckbdreq			|	#{sckbdreqNo} #{type} #{childNo} #{hsptNo} #{manageNo} #{requestCode}
		// update	hspt				|	#{hsptNo}
		//--------------------------------------------------	
		String msg = "success";
		
		// 1. 병상신청 등록 #{sckbdreqNo} #{type} #{childNo} #{hsptNo} #{manageNo} #{requestCode}
		insertSckbdreqService(msg, manageNo, "M102", "A", toHsptNo, loginHspt);
	    
		// 2. 이원대상 병원 잔여병상 수정 #{hsptNo}
		updateDecreaseRmndSckbdCntByHsptNoService(msg, toHsptNo);
	    
		return msg;
	}
	
	@Override
	public String modifyInptntInfo(PstiVO psti) throws Exception {
		// 입원환자를 수정하는 메서드, Controller단에서 필요한 모든 내용을 받아서(InptntUpdateCommand -> toPsti()) PstiVO를 생성하여 서비스에 넘겨준다.
		//-------------------------------------------------
		// update	psti				|	#{pstiNm} #{pstiTelno} #{pstiAdres} #{symptms} #{areaNo} #{pstiNo}
		//--------------------------------------------------	
		String msg = "success";
		int test = -1;
		
		LOGGER.debug("{}",psti);
		
		test = hsptDAO.updateInptntInfo(psti);
		if(test == 0) msg = ErrorCodeUtil.getCodeName("HSPT_ERROR_02");
		
		return msg;
	}

	@Override
	public String registInptntAcceptedByDgnss(String manageNo, String sckbdreqNo, HsptVO loginHspt) throws Exception {
		// 입원중이나 입소중이 아닌 확진자의 (보건소 - 진료완료 - 이원신청 flow) 병상신청을 승인하는 메서드 
		//-------------------------------------------------
		// insert	inptnt				|	#{inpntNo} #{hsptNo} #{manageNo}
		// update	manage				|	#{sttusCode} #{instNm} #{instNo} #{manageNo}
		//			sckbdreq			|	#{sckbdreqNo} #{sckbdreqCode} #{acceptYmd}
		// 			hspt				|	#{hsptNo}			
		//--------------------------------------------------	
		String msg = "success";
		
		// 1. 사전작업
		String hsptNo = loginHspt.getHsptNo();
		SckbdreqVO sckbdreqTemp = pstiDAO.selectSckbdreqBySckbdreqNo(sckbdreqNo);
		String fromHsptNo = sckbdreqTemp.getHsptNo(); 
		
		// 2. 입원환자 등록 #{inpntNo} #{hsptNo} #{manageNo}
		insertInptntService(msg, manageNo, hsptNo);
		
		// 3. 병상신청 정보 변경 #{sckbdreqNo} #{sckbdreqCode} #{acceptYmd}
		updateSckbdreqAcceptService(msg, sckbdreqNo, "H103");
		
		// 4. 진료병원(이원신청병원)의 잔여병상수 +1 #{hsptNo}
		updateIncreaseRmndSckbdCntByHsptNoService(msg, fromHsptNo);

		// 5. manage 테이블 수정 #{sttusCode} #{instNm} #{instNo} #{manageNo}
		updateManageChangeAllService(msg, manageNo, "A105", loginHspt);
		
		return msg;
	}

	@Override
	public String registInptntAcceptedByInptnt(String manageNo, String sckbdreqNo, HsptVO loginHspt)
			throws Exception {
		// 입원환자의 이원신청을 승인하는 메서드 
		//-------------------------------------------------
		// insert	inptnt				|	#{inpntNo} #{hsptNo} #{manageNo}
		// update	manage				|	#{instNm} #{instNo} #{manageNo}
		//			sckbdreq			|	#{sckbdreqNo} #{sckbdreqCode} #{acceptYmd}
		//			inptnt				|	#{hsptlzCode} #{inptntNo}
		//			hspt				|	#{hsptNo}	
		//--------------------------------------------------
		String msg = "success";
		
		// 1. 사전작업
		String hsptNo = loginHspt.getHsptNo();
		InptntVO inptntTemp = pstiDAO.selectInptntByManageNo(manageNo);
		String inptntNoOrigin = inptntTemp.getInptntNo();
		SckbdreqVO sckbdreqTemp = pstiDAO.selectSckbdreqBySckbdreqNo(sckbdreqNo);
		String fromHsptNo = sckbdreqTemp.getHsptNo();
		
		// 2. 입원환자 등록 #{inpntNo} #{hsptNo} #{manageNo}
		insertInptntService(msg, manageNo, hsptNo);
		
		// 3. 병상신청 정보 변경 #{sckbdreqNo} #{sckbdreqCode} #{acceptYmd}
		updateSckbdreqAcceptService(msg, sckbdreqNo, "H103");
		 
		// 4. 이원신청 병원의 입원환자 퇴원처리(퇴원-이원상태) #{hsptlzCode} #{inptntNo}
		updateInptntExitService(msg, inptntNoOrigin, "E103");
		
		// 5. 이원신청 병원의 잔여병상수 +1 #{hsptNo}
		updateIncreaseRmndSckbdCntByHsptNoService(msg, fromHsptNo);
		
		// 6. manage 테이블 수정 #{instNm} #{instNo} #{manageNo}
		updateManageChangeInstService(msg, manageNo, loginHspt);
		
		return msg;
	}

	@Override
	public String registInptntAccetedByIsoptnt(String manageNo, String sckbdreqNo, HsptVO loginHspt, String fromLtctNo)
			throws Exception {
		// 입소중환자의 이원신청을 승인하는 메서드, (생활치료센터 - 진료 - 진료완료 후 이원신청 - 이원대상병원 입원처리 flow) 
		//-------------------------------------------------
		// insert	inptnt				|	#{inpntNo} #{hsptNo} #{manageNo}
		// update	manage				|	#{instNm} #{instNo} #{manageNo}
		//			sckbdreq			|	#{sckbdreqNo} #{sckbdreqCode} #{acceptYmd}
		//			isoptnt				|	#{hsptlzCode} #{isoptntNo}
		//			hspt				|	#{hsptNo}	
		//			ltct				|	#{ltctNo}	
		//--------------------------------------------------
		String msg = "success";
		
		// 1. 사전작업
		String hsptNo = loginHspt.getHsptNo();
		SckbdreqVO sckbdreqTemp = pstiDAO.selectSckbdreqBySckbdreqNo(sckbdreqNo);
		String fromHsptNo = sckbdreqTemp.getHsptNo();
		
		// 2. 입원환자 등록 #{inpntNo} #{hsptNo} #{manageNo}
		insertInptntService(msg, manageNo, hsptNo);
		
		// 3. 병상신청 정보 변경 #{sckbdreqNo} #{sckbdreqCode} #{acceptYmd}
		updateSckbdreqAcceptService(msg, sckbdreqNo, "H103");
		 
		// 4. 진료신청 생활치료센터의 입소환자 퇴원처리(퇴원-이원상태) #{hsptlzCode} #{isoptntNo}
		updateIsoptntExitService(msg, manageNo, "E103");
		
		// 5. 진료신청 생활치료센터의 잔여병상수 +1 #{ltctNo}	
		updateIncreaseRmndSckbdCntByLtctNoService(msg, fromLtctNo);

		// 6. 진료병원의 잔여병상수 +1 #{hsptNo}	
		updateIncreaseRmndSckbdCntByHsptNoService(msg, fromHsptNo);
		
		// 7. manage 테이블 수정 #{sttusCode} #{instNm} #{instNo} #{manageNo}
		updateManageChangeAllService(msg, manageNo, "A105", loginHspt);
		
		return msg;
	}

	@Override
	public String updateSckbdreqRejectByAll(String sckbdreqNo, HsptVO loginHspt) throws Exception {
		// 이원신청을 반려하는 메서드
		// (보건소 - 진료 - 진료완료 후 이원신청 - 반려 flow)
		// (생활치료센터 - 진료 - 진료완료 후 이원신청 - 반려 flow)
		// (입원환자 - 이원신청 - 반려 flow)
		//-------------------------------------------------
		// update	sckbdreq			|	#{sckbdreqNo} #{sckbdreqCode}
		//			hspt				|	#{hsptNo}	
		//--------------------------------------------------
		String msg = "success";
		
		// 1. 사전작업
		String hsptNo = loginHspt.getHsptNo();
		
		// 2. 병상신청 상태변경 (반려) #{sckbdreqNo} #{sckbdreqCode}
		updateSckbdreqCodeOnlyService(msg, sckbdreqNo, "H105");
		
		// 3. 로그인병원의 잔여병상수 +1 #{hsptNo}	
		updateIncreaseRmndSckbdCntByHsptNoService(msg, hsptNo);
		
		return msg;
	}

	@Override
	public String updateSckbdreqCancleToInptnt(String sckbdreqNo, String toHsptNo) throws Exception {
		// 병원으로 신청한 이원신청을 취소하는 메서드
		//-------------------------------------------------
		// update	sckbdreq			|	#{sckbdreqNo} #{sckbdreqCode}
		//			hspt				|	#{hsptNo}	
		//--------------------------------------------------
		
		// 1. 사전작업
		String msg = "success";
		
		
		// 2. 병상신청 상태변경 (취소) #{sckbdreqNo} #{sckbdreqCode}
		updateSckbdreqCodeOnlyService(msg, sckbdreqNo, "H104");
		
		// 3. 이원대상 병원의 잔여병상수 +1 #{hsptNo}	
		updateIncreaseRmndSckbdCntByHsptNoService(msg, toHsptNo);
		
		return msg;
		
	}

	@Override
	public String updateSckbdreqCancleToIsoptnt(String sckbdreqNo, String toLtctNo) throws Exception {
		// 생활치료센터로 신청한 입소신청을 취소하는 메서드
		//-------------------------------------------------
		// update	sckbdreq			|	#{sckbdreqNo} #{sckbdreqCode}
		//			ltct				|	#{ltctNo}	
		//--------------------------------------------------
		// 1. 사전작업
		String msg = "success";
		
		// 2. 병상신청 상태변경 (취소) #{sckbdreqNo} #{sckbdreqCode}
		updateSckbdreqCodeOnlyService(msg, sckbdreqNo, "H104");
		
		// 3. 입소대상 생활치료센터의 잔여병상수 +1 #{hsptNo}	
		updateIncreaseRmndSckbdCntByLtctNoService(msg, toLtctNo);
		
		return msg;
	}
	

}
