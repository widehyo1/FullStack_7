package com.spring.compass.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.compass.command.InspChckdPstiListCommand;
import com.spring.compass.command.InspListVO;
import com.spring.compass.command.InspPstiSearchCommand;
import com.spring.compass.command.VInspPstiResultVO;
import com.spring.compass.command.VInspPstiVO;
import com.spring.compass.vo.InspVO;
import com.spring.compass.vo.PstiVO;

public class InspDAOImpl implements InspDAO{

	private SqlSession sqlSession = null;
	private String nameSpace = "Insp-Mapper.";

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public PstiVO selectPstiByPstiNo(String pstiNo) throws SQLException {
		PstiVO psti = sqlSession.selectOne(nameSpace + "selectPstiByPstiNo", pstiNo);
		return psti;
	}

	@Override
	public String selectPstiSeqNextval() throws SQLException {
		String pstiSeq =  sqlSession.selectOne(nameSpace + "selectPstiSeqNextval");
		return pstiSeq;
	}

	@Override
	public String selectPstiNo(String pstiSeq) throws SQLException {
		String pstiNo =  sqlSession.selectOne(nameSpace + "selectPstiNo", pstiSeq);
		return pstiNo;
	}

	@Override
	public void insertPsti(PstiVO psti) throws SQLException {
		sqlSession.update(nameSpace + "insertPsti", psti);
	}

	@Override
	public InspVO selectInspByInstNo(String instNo) throws SQLException {
		InspVO insp = sqlSession.selectOne(nameSpace + "selectInspByInstNo", instNo);
		return insp;
	}

	@Override
	public String selectInspNextval() throws SQLException {
		String insp_seq = sqlSession.selectOne(nameSpace+"selectInspNextval");
		return insp_seq;
	}

	@Override
	public String selectInspCityNo(String city) throws SQLException {
		String cityNo = sqlSession.selectOne(nameSpace+"selectInspCityNo", city);
		return cityNo;
	}

	@Override
	public String selectInstNextval() throws SQLException {
		String inst_seq = sqlSession.selectOne(nameSpace+"selectInstNextval");
		return inst_seq;
	}

	@Override
	public int insertInsp(InspVO insp) throws SQLException {
		int result = sqlSession.update(nameSpace+"insertInsp", insp);
		return result;
	}

	@Override
	public int insertInst(InspVO insp) throws SQLException {
		System.out.println("insertInst before");
		System.out.println();
		int result = sqlSession.update(nameSpace+"insertInst", insp);
		System.out.println("insertInst after");
		return result;
	}

	@Override
	public String selectResponsibleAgency(String responsible) throws SQLException {
		String responsi = sqlSession.selectOne(nameSpace+"selectResponsibleAgency", responsible);
				
		return responsi;
	}

	@Override
	public String selectJobByCode(String jobCode) throws SQLException {
		String job = sqlSession.selectOne(nameSpace+"selectJobByCode", jobCode);
		return job;
	}

	@Override
	public String selectVacByCode(String vacCode) throws SQLException {
		String vac = sqlSession.selectOne(nameSpace+"selectVacByCode", vacCode);
		return vac;
	}

	@Override
	public List<VInspPstiVO> selectPstiList(InspPstiSearchCommand cri) throws SQLException {
		List<VInspPstiVO> pstiList = sqlSession.selectList(nameSpace+"selectPstiList", cri);
		return pstiList;
	}

	@Override
	public int selectPstiListCount(InspPstiSearchCommand cri) throws SQLException {
		int pstiListCount = sqlSession.selectOne(nameSpace+"selectPstiListCount", cri);
		return pstiListCount;
	}

	@Override
	public List<VInspPstiVO> selectChckdList(InspPstiSearchCommand cri) throws SQLException {
		List<VInspPstiVO> ChckdList = sqlSession.selectList(nameSpace+"selectChckdList", cri);
		return ChckdList;
	}

	@Override
	public int selectChckdListCount(InspPstiSearchCommand cri) throws SQLException {
		int chckdListCount = sqlSession.selectOne(nameSpace+"selectChckdListCount", cri);
		return chckdListCount;
	}

	@Override
	public List<VInspPstiResultVO> selectResultList(InspPstiSearchCommand cri) throws SQLException {
		List<VInspPstiResultVO> resultList = sqlSession.selectList(nameSpace+"selectResultList", cri);
		return resultList;
	}

	@Override
	public int selectResultListCount(InspPstiSearchCommand cri) throws SQLException {
		int resultListCount = sqlSession.selectOne(nameSpace+"selectResultListCount", cri);
		return resultListCount;
	}

	@Override
	public VInspPstiVO selectPstiDetail(String pstiNo) throws SQLException {
		VInspPstiVO psti = sqlSession.selectOne(nameSpace+"selectPstiDetail", pstiNo);
		return psti;
	}

	@Override
	public VInspPstiResultVO selectResultDetail(String pstiNo) throws SQLException {
		VInspPstiResultVO result = sqlSession.selectOne(nameSpace+"selectResultDetail", pstiNo);
		return result;
	}


}