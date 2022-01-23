package com.spring.compass.service;

import java.util.List;
import java.util.Map;

import com.spring.compass.command.SearchCriteria;
import com.spring.compass.vo.AttachVO;
import com.spring.compass.vo.InstVO;
import com.spring.compass.vo.MberVO;
import com.spring.compass.vo.NoticeVO;

public interface AdminService {
	
	
	
	public Map<String, Object> getInstListPage(SearchCriteria cri) throws Exception;
	
	public void registInst(InstVO inst) throws Exception;
	
	public InstVO getInstDetail(String instNo) throws Exception;
	
	public MberVO getMberDetail(String instNo) throws Exception;
	
	public Map<String, Object> getAllInstDetail(String instNo) throws Exception;
	
	public int modifyInst(InstVO inst) throws Exception;
	
	public String getChildNoByInstNo(String instNo) throws Exception;
	
	public int removeMemberByInstNo(String instNo) throws Exception;
	
	public int removeInspByInspNo(String inspNo) throws Exception;
	
	public int removePbhtByPbhtNo(String pbhtNo) throws Exception;
	
	public int removeHsptByHsptNo(String hsptNo) throws Exception;
	
	public int removeLtctByLtctNo(String ltctNo) throws Exception;
	
	public int removeInstByInstNo(String instNo) throws Exception;
	
	public int removeInspByPbhtNo(String pbhtNo) throws Exception;
	
	public List<MberVO> getmberList(String instNo) throws Exception;
	
	public String getNoticeSeq() throws Exception;
	public int registNotice(NoticeVO notice) throws Exception;
	
	public String getAttachSeq() throws Exception;
	public int registAttach(AttachVO attach) throws Exception;
	
	public Map<String, Object> getNoticeList(SearchCriteria cri) throws Exception;
	
	public NoticeVO getNoticeByNoticeNo(String noticeNo) throws Exception;
	
	public AttachVO getAttachByNoticeNo(String noticeNo)throws Exception;
	
	public void removeNotice(String atchNo, String noticeNo) throws Exception;
	
	public void modifyNotice(NoticeVO notice) throws Exception;
	
	public void modifyAttach(AttachVO attach) throws Exception;
	
	public void removeAttachByfileName(String fileName) throws Exception;
	
	public String getInstNoByMberNo(String mberNo) throws Exception;
	
	public String getInstTelNoByInstNo(String instNo) throws Exception;
	
	public int modifyPasswordMber(MberVO mber) throws Exception;
	
	public MberVO getMberBymberNo(String mberNo) throws Exception;
	
}
