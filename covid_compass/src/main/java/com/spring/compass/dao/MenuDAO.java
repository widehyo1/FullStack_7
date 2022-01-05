package com.spring.compass.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.compass.vo.MenuVO;

public interface MenuDAO {
	
	public List<MenuVO> test() throws SQLException;
	
	public MenuVO selectMenuByMenuInnb(String menuInnb) throws SQLException;

	public List<MenuVO> selectMenuList() throws SQLException;
	
}
