package com.lookman.app.seller.service;

import java.sql.Connection;
import java.util.List;

import com.lookman.app.db.JDBCTemplate;
import com.lookman.app.product.vo.ProductVo;
import com.lookman.app.seller.dao.SellerDao;
import com.lookman.app.seller.vo.SellerProductInquiryVo;
import com.lookman.app.seller.vo.SellerSimpleOrderListVo;
import com.lookman.app.seller.vo.SellerStatusVo;
import com.lookman.app.seller.vo.SellerVo;

public class SellerService {
	private final SellerDao dao;
	
	public SellerService() {
		this.dao=new SellerDao();
	}
	
	public SellerVo login(SellerVo vo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		SellerVo loginSellerVo=dao.getSellerVo(conn,vo);
		
		JDBCTemplate.close(conn);
		
		return loginSellerVo;
	}

	public SellerStatusVo getSellerStatus(String sellerNo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		SellerStatusVo ssVo=dao.getSellerStatus(conn,sellerNo);
		
		JDBCTemplate.close(conn);
		
		return ssVo;
	}

	public List<ProductVo> getProductListRowNum3(SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<ProductVo> pVoList=dao.getProductListRowNum3(conn,loginSellerVo);
		
		JDBCTemplate.close(conn);
		
		return pVoList;
	}

	public List<SellerProductInquiryVo> getProductInquiryListRowNum3(SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerProductInquiryVo> spiVoList=dao.getProductInquiryListRowNum3(conn,loginSellerVo);
		
		JDBCTemplate.close(conn);
		
		return spiVoList;
	}

	public List<SellerSimpleOrderListVo> getSimplerOrderListRowNum3(SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerSimpleOrderListVo> ssoVoList=dao.getSimpleOrderListRowNum3(conn,loginSellerVo);
		
		JDBCTemplate.close(conn);
		
		return null;
	}

}
