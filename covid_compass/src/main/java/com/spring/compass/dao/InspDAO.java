package com.spring.compass.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.compass.command.InspPstiRegistCommand;
import com.spring.compass.command.InspPstiSearchCommand;
import com.spring.compass.command.InspSmplRequestCommand;
import com.spring.compass.command.VInspPstiResultVO;
import com.spring.compass.command.VInspPstiVO;
import com.spring.compass.vo.InspVO;
import com.spring.compass.vo.KitHistVO;
import com.spring.compass.vo.PcrKitVO;
import com.spring.compass.vo.PstiVO;

public interface InspDAO {

	/**
	 * 인풋 : 피검자 번호
	 * 아웃풋 : 피검자VO
	 * @param pstiNo
	 * @return
	 * @throws SQLException
	 */
	public PstiVO selectPstiByPstiNo(String pstiNo) throws SQLException;

	/**
	 * 인풋 : 없음
	 * 아웃풋 : pstiSeq의 다음 값
	 * @return
	 * @throws SQLException
	 */
	public String selectPstiSeqNextval() throws SQLException;

	/**
	 * 인풋 : pstiSeq 값
	 * 아웃풋 : psti의 pk 값 (PSTI + yyyyMMdd + pstiSeq)
	 * @param pstiSeq
	 * @return
	 * @throws SQLException
	 */
	public String selectPstiNo(String pstiSeq) throws SQLException;

	/**
	 * 인풋 : pstiVO
	 * 아웃풋 : 없음
	 * @param pstiVO
	 * @throws SQLException
	 */
	public void insertPsti(PstiVO psti) throws SQLException;

	/**
	 * 인풋 : instNo
	 * 아웃풋 : 해당 기관번호를 가지는 inspVO
	 * @param instNo
	 * @return
	 * @throws SQLException
	 */
	public InspVO selectInspByInstNo(String instNo) throws SQLException;
	
	/**
	 * 인풋: 없음
	 * 아웃풋 : 검사소지역번호
	 * @param city
	 * @return string
	 * @throws SQLException
	 */
	public String selectInspCityNo(String city) throws SQLException;
	
	/**
	 * 인풋: 없음
	 * 아웃풋 : 검사소번호시퀀스
	 * @param  
	 * @return string
	 * @throws SQLException
	 */
	public String selectInspNextval() throws SQLException;
	
	/**
	 * 인풋: 없음
	 * 아웃풋 : 기관번호시퀀스
	 * @param  
	 * @return string
	 * @throws SQLException
	 */
	public String selectInstNextval() throws SQLException;
	
	/**
	 * 인풋: inspVO
	 * 아웃풋 : 영향받은 행수
	 * @param  
	 * @return int
	 * @throws SQLException
	 */
	public int insertInsp(InspVO insp) throws SQLException;
	
	/**
	 * 인풋: inspVO
	 * 아웃풋 : 영향받은 행수
	 * @param  
	 * @return int
	 * @throws SQLException
	 */
	public int insertInst(InspVO insp) throws SQLException;
	
	/**
	 * 인풋 : inspNo 기관 고유번호
	 * 아웃풋 : PstiVO 피검자리스트
	 * @param inspNo
	 * @return
	 * @throws SQLException
	 */
	
	
	
	public String selectResponsibleAgency(String responsible) throws SQLException;
	
	public String selectJobByCode(String jobCode) throws SQLException;
	
	public String selectVacByCode(String vacCode) throws SQLException;
	
	
	// 리스트
	public List<VInspPstiVO> selectPstiList(InspPstiSearchCommand cri) throws SQLException;
	public int selectPstiListCount(InspPstiSearchCommand cri) throws SQLException;

	public List<VInspPstiVO> selectChckdList(InspPstiSearchCommand cri) throws SQLException;
	public int selectChckdListCount(InspPstiSearchCommand cri) throws SQLException;
	
	public List<VInspPstiResultVO> selectResultList(InspPstiSearchCommand cri) throws SQLException;
	public int selectResultListCount(InspPstiSearchCommand cri) throws SQLException;
	
	//디테일
	public VInspPstiVO selectPstiDetail(String pstiNo) throws SQLException;
	
	public VInspPstiVO selectChckdDetail(String pstiNo) throws SQLException;
	
	public VInspPstiResultVO selectResultDetail(String pstiNo)throws SQLException;
	
	public List<PcrKitVO> selectPcrKitList(String inspNo) throws SQLException;
	
	public int selectPcrKitCount(String inspNo) throws SQLException;
	
	public int selectTotalKitCount(String inspNo) throws SQLException;
	
	void updatePstiInfo(VInspPstiVO psti) throws SQLException;
	
	// 문진표 등록
	void insertHtscQuestion(InspPstiRegistCommand pstiInfo) throws SQLException;
	void insertPstiQuestion(String pstiNo) throws SQLException;
	void updateInspKit(InspPstiRegistCommand inspInfo) throws SQLException;
	
	// 검사요청
	String selectSmplSeq() throws SQLException;
	String selectManageSeq() throws SQLException;
	void insertSmplInfo(InspSmplRequestCommand smplInfo) throws SQLException;
	void insertManageInfo(InspSmplRequestCommand manageInfo) throws SQLException;
	void updateManageInfo(InspSmplRequestCommand manageNo) throws SQLException;
	String selectManageNoByPstiNo(String pstiNo) throws SQLException;
	
	//진단키트 등록
	String selectKitHistSeq() throws SQLException;
	void insertKitHist(KitHistVO kitHist) throws SQLException;
}
