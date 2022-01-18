package com.spring.compass.dao;

import java.sql.SQLException;

import com.spring.compass.vo.MberVO;

public interface MberDAO {

	MberVO selectMberById(String id) throws SQLException;
	
	MberVO findByInfo(MberVO mber) throws SQLException; // 아이디찾기
	
	void updatePwd(MberVO mber) throws SQLException;
	
	public String selectMbserSeq() throws SQLException;
	
	public void insertMberRepresent(MberVO mber) throws SQLException;
}
