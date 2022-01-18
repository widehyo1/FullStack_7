package com.spring.compass.dao;

import java.sql.SQLException;

import com.spring.compass.vo.PbhtVO;

public interface PbhtDAO {
	
	/**
	 * 인풋 : 기관번호
	 * 아웃풋 : 해당기관번호를 가지는 보건소 vo
	 * @param instNo
	 * @return
	 * @throws SQLException
	 */
	public PbhtVO selectPbhtByInstNo(String instNo) throws SQLException;
	
	/**
	 * 인풋 : 없음
	 * 아웃풋: 해당보건소 지역번호
	 * @param 
	 * @return String
	 * @throws SQLException
	 * 
	 */
	public String selectPbhtCityNo(String city) throws SQLException;
	
	/**
	 * 인풋 : 없음
	 * 아웃풋: 보건소 시퀀스번호
	 * @param 
	 * @return String
	 * @throws SQLException
	 * 
	 */
	public int selectPbhtNextVal() throws SQLException;
	
	/**
	 * 인풋 : 없음
	 * 아웃풋: 기관 시퀀스번호
	 * @param 
	 * @return String
	 * @throws SQLException
	 * 
	 */
	public int selectInstNextval() throws SQLException;
	
	/**
	 * 인풋 : pbhtvo
	 * 아웃풋: int
	 * @param 
	 * @return int
	 * @throws SQLException
	 * 
	 */
	public int insertPbht(PbhtVO pbht) throws SQLException;
	
	/**
	 * 인풋 : pbhtvo
	 * 아웃풋: int
	 * @param 
	 * @return int
	 * @throws SQLException
	 * 
	 */
	public int insertInst(PbhtVO pbht) throws SQLException;
	
	
	public PbhtVO selectPbhtByPbhtNo(String pbhtNo) throws SQLException;
	

}
