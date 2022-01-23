package com.spring.compass.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.spring.compass.vo.MberVO;

public class MberDAOImpl implements MberDAO {

	private SqlSession sqlSession;
	
	private String nameSpace="Mber-Mapper.";
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public MberVO selectMberById(String id) throws SQLException {
		return sqlSession.selectOne("Mber-Mapper.selectMberById", id);
	}

	@Override
	public MberVO findByInfo(MberVO mber) throws SQLException {
		return sqlSession.selectOne("Mber-Mapper.findByInfo", mber);
	}

	@Override
	public void updatePwd(MberVO mber) throws SQLException {
		sqlSession.update("Mber-Mapper.updatePwd", mber);
	}

	@Override
	public String selectMbserSeq() throws SQLException {
		String mberSeq = sqlSession.selectOne(nameSpace+"selectMbserSeq");
		return mberSeq;
	}

	@Override
	public void insertMberRepresent(MberVO mber) throws SQLException {
		sqlSession.update(nameSpace+"insertMberRepresent", mber);
	}

}
