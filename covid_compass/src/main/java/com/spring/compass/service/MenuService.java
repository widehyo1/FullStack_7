package com.spring.compass.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.compass.vo.MenuVO;

public interface MenuService {

	public List<MenuVO> test() throws SQLException;
	
	public MenuVO getMenu(String menuInnb) throws SQLException;
	
	public List<MenuVO> getMenuList() throws SQLException;
	
}
