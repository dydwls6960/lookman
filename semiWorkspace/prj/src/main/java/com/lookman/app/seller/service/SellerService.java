package com.lookman.app.seller.service;

import java.sql.Connection;
import java.util.List;

import com.lookman.app.category.vo.CategoryVo;
import com.lookman.app.db.JDBCTemplate;
import com.lookman.app.product.vo.ProductColorVo;
import com.lookman.app.product.vo.ProductSizeVo;
import com.lookman.app.product.vo.ProductVo;
import com.lookman.app.seller.dao.SellerDao;
import com.lookman.app.seller.order.vo.SellerOrderListVo;
import com.lookman.app.seller.product.vo.SellerProductInquiryVo;
import com.lookman.app.seller.product.vo.SellerProductListVo;
import com.lookman.app.seller.product.vo.SellerProductReviewListVo;
import com.lookman.app.seller.product.vo.SellerProductSearchVo;
import com.lookman.app.seller.vo.SellerInquiryVo;
import com.lookman.app.seller.vo.SellerProductInsertVo;
import com.lookman.app.seller.vo.SellerStateVo;
import com.lookman.app.seller.vo.SellerStatisticsVo;
import com.lookman.app.seller.vo.SellerSimpleOrderListVo;
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

	public SellerStateVo getSellerStatus(String sellerNo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		SellerStateVo spsVo=dao.getSellerStatus(conn,sellerNo);
		
		JDBCTemplate.close(conn);
		
		return spsVo;
	}

	public List<SellerProductListVo> getProductListRowNum3(SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerProductListVo> splVoList=dao.getProductListRowNum3(conn,loginSellerVo);
		
		JDBCTemplate.close(conn);
		
		return splVoList;
	}

	public List<SellerProductInquiryVo> getProductInquiryListRowNum3(SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerProductInquiryVo> spiVoList=dao.getProductInquiryListRowNum3(conn,loginSellerVo);
		
		JDBCTemplate.close(conn);
		
		return spiVoList;
	}

	public List<SellerOrderListVo> getSimplerOrderListRowNum3(SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerOrderListVo> solVoList=dao.getSimpleOrderListRowNum3(conn,loginSellerVo);
		
		JDBCTemplate.close(conn);
		
		return solVoList;
	}

	public List<ProductVo> getProductList(SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<ProductVo> pVoList=dao.getProductList(conn,loginSellerVo);
		
		JDBCTemplate.close(conn);
		
		return pVoList;
	}

	public List<CategoryVo> getCategoryList() throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<CategoryVo> cVoList=dao.getCategoryList(conn);
		
		JDBCTemplate.close(conn);
		return cVoList;
	}

	public List<ProductSizeVo> getSizeList() throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<ProductSizeVo> psVoList=dao.getSizeList(conn);
		
		JDBCTemplate.close(conn);
		return psVoList;
	}

	public List<ProductColorVo> getColorList() throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<ProductColorVo> pcVoList=dao.getColorList(conn);
		
		JDBCTemplate.close(conn);
		return pcVoList;
	}

	public List<SellerProductListVo> getProductSearchList(SellerProductSearchVo spsVo, SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerProductListVo> splVoList=dao.getProductSearchList(conn,spsVo,loginSellerVo);
		
		JDBCTemplate.close(conn);
		
		return splVoList;
	}

	public SellerInquiryVo getSellerInquiryVo(String sellerNo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		SellerInquiryVo siVo=dao.getSellerInquiryVo(conn,sellerNo);
		
		JDBCTemplate.close(conn);
		
		return siVo;
	}

	public List<SellerProductListVo> getProductListDetail(SellerVo loginSellerVo,String productNo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerProductListVo> splVoList=dao.getProductListDetail(conn,loginSellerVo,productNo);
		
		JDBCTemplate.close(conn);
		return splVoList;
	}

	public List<SellerProductListVo> getProductDetailSearchList(SellerProductSearchVo spsVo, SellerVo loginSellerVo,String productNo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerProductListVo> splVoList=dao.getProductDetailSearchList(conn,loginSellerVo,spsVo,productNo);
		
		JDBCTemplate.close(conn);
		return splVoList;
	}

	public List<SellerProductInquiryVo> getProductInquiryList(SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerProductInquiryVo> spiVoList=dao.getProductInquiryList(conn,loginSellerVo);
		
		JDBCTemplate.close(conn);
		
		return spiVoList;
	}

	public List<SellerProductInquiryVo> getProductInquirySelectList(SellerProductSearchVo spsVo,
			SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerProductInquiryVo> spiVoList=dao.getProductInquirySelectList(conn,loginSellerVo,spsVo);
		
		JDBCTemplate.close(conn);
		
		return spiVoList;
	}

	public List<SellerProductReviewListVo> getReviewListRownum3(SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerProductReviewListVo> sprVoList=dao.getReviewListRownum3(conn,loginSellerVo);
		
		JDBCTemplate.close(conn);
		return sprVoList;
	}

	public List<SellerProductReviewListVo> getReviewList(SellerVo loginSellerVo, SellerProductSearchVo spsVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerProductReviewListVo> sprVoList=dao.getReviewList(conn,loginSellerVo,spsVo);
		
		JDBCTemplate.close(conn);
		return sprVoList;
	}

	public List<SellerOrderListVo> getSimplerOrderList(SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerOrderListVo> solVoList=dao.getSimpleOrderList(conn,loginSellerVo);
		
		JDBCTemplate.close(conn);
		
		return solVoList;
	}

	public List<SellerOrderListVo> getSimplerOrderSearchList(SellerVo loginSellerVo, SellerProductSearchVo spsVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerOrderListVo> solVoList=dao.getSimpleOrderSearchList(conn,loginSellerVo,spsVo);
		
		JDBCTemplate.close(conn);
		
		return solVoList;
	}

	public List<SellerOrderListVo> getSimplerOrderListPrice(SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerOrderListVo> solVoList=dao.getSimpleOrderSearchListPrice(conn,loginSellerVo);
		
		JDBCTemplate.close(conn);
		
		return solVoList;
	}

	public SellerStatisticsVo getSellerStatistics(SellerVo loginSellerVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		SellerStatisticsVo sssVo=dao.getSellerStatistics(conn,loginSellerVo);
		
		JDBCTemplate.close(conn);
		return sssVo;
	}

	public SellerProductInquiryVo getProductInquirySelect(SellerVo loginSellerVo, String productInquiryNo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		SellerProductInquiryVo spiVo=dao.getSellerInquirySelect(conn,loginSellerVo,productInquiryNo);
		
		JDBCTemplate.close(conn);
		
		return spiVo;
	}

	public int updateInquiry(SellerVo loginSellerVo, String productInquiryNo,String askText) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		int result= dao.updateInquiry(conn,loginSellerVo,productInquiryNo,askText);
		System.out.println(result);
		if(result!=0) {
			JDBCTemplate.commit(conn);			
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public int getOrderUpdatePrepare(String orderDetailNo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		int result=dao.getOrderUpdatePrepare(conn,orderDetailNo);
		
		if(result!=0) {
			JDBCTemplate.commit(conn);			
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int getOrderUpdateStart(String orderDetailNo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		int result=dao.getOrderUpdateStart(conn,orderDetailNo);
		
		if(result!=0) {
			JDBCTemplate.commit(conn);			
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int getOrderUpdateComplete(String orderDetailNo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		int result=dao.getOrderUpdateComplete(conn,orderDetailNo);
		
		
		if(result!=0) {
			JDBCTemplate.commit(conn);			
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public void getProductInsert(SellerVo loginSellerVo, SellerProductInsertVo spInsertVo) throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		dao.getProductInsert(conn,loginSellerVo,spInsertVo);
		
		JDBCTemplate.close(conn);
	}

	public SellerStateVo getSellerStatus() throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		SellerStateVo spsVo=dao.getSellerStatus(conn);
		
		JDBCTemplate.close(conn);
		
		return spsVo;
	}

	public SellerStatisticsVo getSellerStatistics() throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		SellerStatisticsVo sssVo=dao.getSellerStatistics(conn);
		
		JDBCTemplate.close(conn);
		return sssVo;
	}

	public List<SellerOrderListVo> getSimplerOrderListPrice() throws Exception {
		Connection conn=JDBCTemplate.getConnection();
		
		List<SellerOrderListVo> solVoList=dao.getSimpleOrderSearchListPrice(conn);
		
		JDBCTemplate.close(conn);
		
		return solVoList;
	}

	

}
