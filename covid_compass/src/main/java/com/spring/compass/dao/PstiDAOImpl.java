package com.spring.compass.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.compass.command.VPstiCommand;
import com.spring.compass.vo.DgnssResultVO;
import com.spring.compass.command.SearchCriteria;
import com.spring.compass.vo.InspVO;
import com.spring.compass.vo.PstiVO;
import com.spring.compass.vo.SckbdreqVO;
import com.spring.compass.vo.SmplResultVO;

public class PstiDAOImpl implements PstiDAO{
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	private String nameSpace = "Psti-Mapper.";
	@Override
	public PstiVO selectPstiByPstiNo(String pstiNo) throws SQLException {
		PstiVO psti = sqlSession.selectOne(nameSpace + "selectPstiByPstiNo", pstiNo);
		return psti;
	}
	
	@Override
	public PstiVO selectPstiByManageNo(String manageNo) throws SQLException {
		PstiVO psti = sqlSession.selectOne(nameSpace + "selectPstiByManageNo", manageNo);
		return psti;
	}
	
	@Override
	public List<PstiVO> selectPstiListByInspNo(String inspNo) throws SQLException {
		
		RowBounds rowBound = new RowBounds(0, 15);
		
		List<PstiVO> pstiList = sqlSession.selectList(nameSpace + "selectPstiListByInspNo", inspNo, rowBound);
		return pstiList;
	}

	@Override
	public int registPsti(PstiVO psti) throws SQLException {
		
		int cnt = sqlSession.update(nameSpace + "registPsti", psti);

		return cnt;
	}

	@Override
	public int selectPstiNextVal() throws SQLException {
		
		int instNo = sqlSession.selectOne(nameSpace + "selectPstiNextVal"); 
		
		return instNo;
	}
	

	@Override
	public List<InspVO> selectInspList(SearchCriteria cri) throws SQLException {
		
		int offset=cri.getStartRowNum() - 1;
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);		
		
		List<InspVO> inspList =
				sqlSession.selectList(nameSpace + "selectInspList",cri,rowBounds);
		return inspList;
	}

	@Override
	public int selectSearchInspListCount(SearchCriteria cri) throws SQLException {
		int count=sqlSession.selectOne(nameSpace + "selectSearchInspListCount",cri);
		return count;
	}
	
	@Override
	public VPstiCommand selectVPstiByPstiNo(String pstiNo) throws SQLException {
		VPstiCommand vPsti = sqlSession.selectOne(nameSpace + "selectVPstiByPstiNo", pstiNo);
		return vPsti;
	}

	@Override
	public VPstiCommand selectVPstiByManageNo(String manageNo) throws SQLException {
		VPstiCommand vPsti = sqlSession.selectOne(nameSpace + "selectVPstiByManageNo", manageNo);
		return vPsti;
	}

	@Override
	public SmplResultVO selectVSmplResultBySmplNo(String smplNo) throws SQLException {
		SmplResultVO smplRes = sqlSession.selectOne(nameSpace + "selectVSmplResultBySmplNo", smplNo);
		return smplRes;
	}

	@Override
	public SmplResultVO selectVSmplResultByManageNo(String manageNo) throws SQLException {
		SmplResultVO smplRes = sqlSession.selectOne(nameSpace + "selectVSmplResultByManageNo", manageNo);
		return smplRes;
	}

	@Override
	public DgnssResultVO selectVDgnssResultByManageNo(String manageNo) throws SQLException {
		DgnssResultVO dgnssRes = sqlSession.selectOne(nameSpace + "selectVDgnssResultByManageNo", manageNo);
		return dgnssRes;
	}

	@Override
	public DgnssResultVO selectVDgnssResultByDgnssNo(String dgnssNo) throws SQLException {
		DgnssResultVO dgnssRes = sqlSession.selectOne(nameSpace + "selectVDgnssResultByDgnssNo", dgnssNo);
		return dgnssRes;
	}
	@Override
	public String selectPstiCityNo(String city) throws SQLException {
		String cityNo = sqlSession.selectOne(nameSpace + "selectPstiCityNo", city);
		
		return cityNo;
	}

	@Override
	public SckbdreqVO selectSckbdreqBySckbdreqNo(String sckbdreqNo) throws SQLException {
		SckbdreqVO sckbdreq = sqlSession.selectOne(nameSpace + "selectSckbdreqBySckbdreqNo", sckbdreqNo);
		return sckbdreq;
	}

	@Override
	public SckbdreqVO selectSckbdreqByManageNo(String manageNo) throws SQLException {
		SckbdreqVO sckbdreq = sqlSession.selectOne(nameSpace + "selectSckbdreqByManageNo", manageNo);
		return sckbdreq;
	}
	
}
