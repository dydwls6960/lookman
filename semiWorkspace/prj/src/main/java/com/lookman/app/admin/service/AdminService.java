package com.lookman.app.admin.service;

import java.sql.Connection;
import java.util.List;

import com.lookman.app.admin.dao.AdminDao;
import com.lookman.app.admin.member.vo.AdminOrderListVo;
import com.lookman.app.admin.vo.AdminVo;
import com.lookman.app.admin.vo.CouponListVo;
import com.lookman.app.admin.vo.ReportListVo;
import com.lookman.app.admin.vo.UserVo;
import com.lookman.app.db.JDBCTemplate;
import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.seller.vo.SellerStateVo;
import com.lookman.app.seller.vo.SellerVo;

public class AdminService {
	private final AdminDao dao;
	
	public AdminService() {
		this.dao=new AdminDao();
	}

	public AdminVo login(AdminVo vo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		AdminVo loginAdminVo=dao.getAdminVo(conn,vo);
		
		JDBCTemplate.close(conn);
		
		return loginAdminVo;
	}

	public UserVo getUserCnt(AdminVo loginAdminVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		UserVo uVo=dao.getUserCnt(conn,loginAdminVo);
		JDBCTemplate.close(conn);
		
		return uVo;
	}

	public SellerStateVo getTotalPrice() throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		SellerStateVo spsVo=dao.getTotalPrice(conn);
		
		JDBCTemplate.close(conn);
		
		return spsVo;
	}

	public List<CouponListVo> getCouponList() throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<CouponListVo> clVoList=dao.getCouponList(conn);
		
		JDBCTemplate.close(conn);
		return clVoList;
	}

	public List<ReportListVo> getReportList() throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<ReportListVo> rlVoList=dao.getReportList(conn);
		
		JDBCTemplate.close(conn);
		return rlVoList;
	}

	public List<AdminOrderListVo> getOrserList() throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<AdminOrderListVo> aolVoList=dao.getOrderList(conn);
		
		JDBCTemplate.close(conn);
		return aolVoList;
	}

	public List<MemberVo> getMemberList() throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<MemberVo> mVoList=dao.getMemberList(conn);
		
		JDBCTemplate.close(conn);
		return mVoList;
	}

	public List<SellerVo> getSellerList() throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerVo> sVoList=dao.getSellerList(conn);
		
		JDBCTemplate.close(conn);
		return sVoList;
	}

}
