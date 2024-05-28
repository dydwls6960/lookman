package com.lookman.app.seller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lookman.app.db.JDBCTemplate;
import com.lookman.app.product.vo.ProductVo;
import com.lookman.app.seller.vo.SellerProductInquiryVo;
import com.lookman.app.seller.vo.SellerSimpleOrderListVo;
import com.lookman.app.seller.vo.SellerStatusVo;
import com.lookman.app.seller.vo.SellerVo;

public class SellerDao {

	public SellerVo getSellerVo(Connection conn, SellerVo vo) throws Exception {
		String sql="SELECT * FROM SELLER WHERE ACC_NAME=? AND PWD=? AND DELETED_YN='N'";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getAccName());
		pstmt.setString(2, vo.getPwd());
		ResultSet rs=pstmt.executeQuery();
		
		SellerVo loginSellerVo=null;
		if(rs.next()) {
			String no=rs.getString("SELLER_NO");
			String id=rs.getString("ACC_NAME");
			String pwd=rs.getString("PWD");
			String nick=rs.getString("NAME");
			
			loginSellerVo=new SellerVo();
			loginSellerVo.setSellerNo(no);
			loginSellerVo.setAccName(id);
			loginSellerVo.setPwd(pwd);
			loginSellerVo.setName(nick);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginSellerVo;
	}

	public SellerStatusVo getSellerStatus(Connection conn, String sellerNo) throws Exception {
		String sql="SELECT\r\n"
				+ "    (SELECT COUNT(*) \r\n"
				+ "     FROM PRODUCT P\r\n"
				+ "     WHERE P.SELLER_NO = S.SELLER_NO) AS 상품개수,\r\n"
				+ "    (SELECT SUM(P.HIT) \r\n"
				+ "     FROM PRODUCT P\r\n"
				+ "     WHERE P.SELLER_NO = S.SELLER_NO) AS 상품조회수,\r\n"
				+ "    (SELECT COUNT(*) \r\n"
				+ "     FROM PRODUCT P\r\n"
				+ "     JOIN FAVORITE F ON P.PRODUCT_NO = F.PRODUCT_NO\r\n"
				+ "     WHERE P.SELLER_NO = S.SELLER_NO) AS 찜개수,\r\n"
				+ "    (SELECT COUNT(*) \r\n"
				+ "     FROM ORDERS O\r\n"
				+ "     JOIN ORDER_DETAIL OD ON O.ORDERS_NO = OD.ORDERS_NO\r\n"
				+ "     JOIN PRODUCT P ON P.PRODUCT_NO = OD.PRODUCT_NO\r\n"
				+ "     WHERE P.SELLER_NO = S.SELLER_NO) AS 주문수,\r\n"
				+ "    (SELECT SUM(PRICE) \r\n"
				+ "     FROM ORDERS O\r\n"
				+ "     JOIN ORDER_DETAIL OD ON O.ORDERS_NO = OD.ORDERS_NO\r\n"
				+ "     JOIN PRODUCT P ON P.PRODUCT_NO = OD.PRODUCT_NO\r\n"
				+ "     WHERE P.SELLER_NO = S.SELLER_NO) AS 총주문금액\r\n"
				+ "FROM SELLER S\r\n"
				+ "WHERE S.SELLER_NO = "+sellerNo;
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		SellerStatusVo ssVo=null;
		if(rs.next()) {
			String allProductCnt=rs.getString("상품개수");
			String allHitSum=rs.getString("상품조회수");
			String allFavoriteCnt=rs.getString("찜개수");
			String allOrderCnt=rs.getString("주문수");
			String allPriceSum=rs.getString("총주문금액");
			
			ssVo=new SellerStatusVo();
			ssVo.setAllProductCnt(allProductCnt);
			ssVo.setAllHitSum(allHitSum);
			ssVo.setAllFavoriteCnt(allFavoriteCnt);
			ssVo.setAllOrderCnt(allOrderCnt);
			ssVo.setAllPriceSum(allPriceSum);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return ssVo;
	}

	public List<ProductVo> getProductListRowNum3(Connection conn, SellerVo loginSellerVo) throws Exception {
		String sql = "SELECT * FROM ("
		           + "    SELECT "
		           + "        P.PRODUCT_NO, "
		           + "        P.SELLER_NO, "
		           + "        P.NAME, "
		           + "        P.DETAILS, "
		           + "        P.PRICE, "
		           + "        PI.FILENAME, "
		           + "        P.CREATED_DATE, "
		           + "        P.HIT, "
		           + "        ROW_NUMBER() OVER (PARTITION BY P.PRODUCT_NO ORDER BY PI.FILENAME) AS RN, "
		           + "        C.NAME AS 카테고리 "
		           + "    FROM PRODUCT P "
		           + "    JOIN PRODUCT_IMG PI ON P.PRODUCT_NO = PI.PRODUCT_NO "
		           + "    JOIN CATEGORY C ON P.CATEGORY_NO = C.CATEGORY_NO "
		           + "    WHERE P.SELLER_NO = " + loginSellerVo.getSellerNo() + " "
		           + "    ORDER BY P.CREATED_DATE DESC"  // 내부 쿼리에서 정렬
		           + ") PI_RANKED "
		           + "WHERE ROWNUM <= 3 "  // 외부 쿼리에서 제한
		           + "AND PI_RANKED.RN = 1 "
		           + "ORDER BY PI_RANKED.PRODUCT_NO DESC";

		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<ProductVo> pVoList=new ArrayList<ProductVo>();
		while(rs.next()) {
			String productNo=rs.getString("PRODUCT_NO");
//			String sellerName=rs.getString(); loginSellerVo.getName
			String categoryNo=rs.getString("카테고리");
			String name=rs.getString("NAME");
			String details=rs.getString("DETAILS");
			String price=rs.getString("PRICE");
			String createdDate=rs.getString("CREATED_DATE");
			String file=rs.getString("FILENAME");
			String hit=rs.getString("HIT");
			
			ProductVo pVo=new ProductVo();
			pVo.setProductNo(productNo);
			pVo.setSellerNo(loginSellerVo.getName());
			pVo.setCategoryNo(categoryNo);
			pVo.setName(name);
			pVo.setDetails(details);
			pVo.setPrice(price);
			pVo.setCreatedDate(createdDate);
			pVo.setHit(hit);
			pVo.setDeletedYn(file);
			
			pVoList.add(pVo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		
		return pVoList;
	}

	public List<SellerProductInquiryVo> getProductInquiryListRowNum3(Connection conn, SellerVo loginSellerVo) throws Exception {
		String sql="SELECT *\r\n"
				+ "FROM (\r\n"
				+ "    SELECT \r\n"
				+ "        PIN.PRODUCT_INQUIRY_NO,\r\n"
				+ "        P.PRODUCT_NO,\r\n"
				+ "        P.NAME AS PRODUCT_NAME,\r\n"
				+ "        S.NAME AS SELLER_NAME,\r\n"
				+ "        SS.NAME AS STATUS_NAME,\r\n"
				+ "        M.NAME AS MEMBER_NAME,\r\n"
				+ "        M.ID AS MEMBER_ID,\r\n"
				+ "        PIN.TITLE,\r\n"
				+ "        PIN.QUESTION_CONTENT,\r\n"
				+ "        PIN.RESPONSE_CONTENT,\r\n"
				+ "        PIN.ASK_DATE,\r\n"
				+ "        PIN.RESPONSE_DATE,\r\n"
				+ "        PIN.PRIVATE_YN,\r\n"
				+ "        PIN.DELETED_YN,\r\n"
				+ "        ROW_NUMBER() OVER (ORDER BY PIN.ASK_DATE DESC) AS RN\r\n"
				+ "    FROM PRODUCT_INQUIRY PIN\r\n"
				+ "    JOIN STATUS SS ON PIN.STATUS_NO = SS.STATUS_NO\r\n"
				+ "    JOIN MEMBER M ON PIN.MEMBER_NO = M.MEMBER_NO\r\n"
				+ "    JOIN PRODUCT P ON PIN.PRODUCT_NO = P.PRODUCT_NO\r\n"
				+ "    JOIN SELLER S ON PIN.SELLER_NO = S.SELLER_NO\r\n"
				+ "    WHERE PIN.SELLER_NO = "+loginSellerVo.getSellerNo()
				+ ") PI_RANKED\r\n"
				+ "WHERE PI_RANKED.RN <= 3\r\n"
				+ "ORDER BY PI_RANKED.ASK_DATE DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerProductInquiryVo> spiVoList=new ArrayList<SellerProductInquiryVo>();
		while(rs.next()) {
			String product_inquiry_no = rs.getString("PRODUCT_INQUIRY_NO");
			String product_no = rs.getString("PRODUCT_NO");
			String product_name = rs.getString("PRODUCT_NAME");
			String seller_name = rs.getString("SELLER_NAME");
			String status_name = rs.getString("STATUS_NAME");
			String member_name = rs.getString("MEMBER_NAME");
			String member_id=rs.getString("MEMBER_ID");
			String title = rs.getString("TITLE");
			String question_content = rs.getString("QUESTION_CONTENT");
			String response_content = rs.getString("RESPONSE_CONTENT");
			String ask_date = rs.getString("ASK_DATE");
			String response_date = rs.getString("RESPONSE_DATE");
			String private_yn = rs.getString("PRIVATE_YN");
			String deleted_yn = rs.getString("DELETED_YN");
			
			SellerProductInquiryVo spiVo=new SellerProductInquiryVo();
			spiVo.setProduct_inquiry_no(product_inquiry_no);
	        spiVo.setProduct_no(product_no);
	        spiVo.setProduct_name(product_name);
	        spiVo.setSeller_name(seller_name);
	        spiVo.setStatus_name(status_name);
	        spiVo.setMember_name(member_name);
	        spiVo.setMember_id(member_id);
	        spiVo.setTitle(title);
	        spiVo.setQuestion_content(question_content);
	        spiVo.setResponse_content(response_content);
	        spiVo.setAsk_date(ask_date);
	        spiVo.setResponse_date(response_date);
	        spiVo.setPrivate_yn(private_yn);
	        spiVo.setDeleted_yn(deleted_yn);
	        
	        spiVoList.add(spiVo);

		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return spiVoList;
	}

	public List<SellerSimpleOrderListVo> getSimpleOrderListRowNum3(Connection conn, SellerVo loginSellerVo) throws Exception {
		String sql="SELECT * FROM (\r\n"
		           + "    SELECT O.ORDERS_NO, M.ID AS MEMBER_ID, M.NAME AS MEMBER_NAME, SS.NAME AS STATUS_NAME, C.NAME AS CARD_COMPANY_NAME, \r\n"
		           + "           O.SHIPPING_FEE, P.PRICE, \r\n"
		           + "           TO_CHAR(O.CREATED_DATE, 'YY\"년\"MM\"월\"DD\"일\" HH24:MI') AS FORMATTED_DATE\r\n"
		           + "    FROM ORDERS O\r\n"
		           + "    JOIN ORDER_DETAIL OD ON O.ORDERS_NO = OD.ORDER_DETAIL_NO\r\n"
		           + "    JOIN PRODUCT P ON OD.PRODUCT_NO = P.PRODUCT_NO\r\n"
		           + "    JOIN MEMBER M ON O.MEMBER_NO = M.MEMBER_NO\r\n"
		           + "    JOIN ADDRESS A ON A.ADDRESS_NO = O.ADDRESS_NO\r\n"
		           + "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO\r\n"
		           + "    JOIN STATUS SS ON O.STATUS_NO = SS.STATUS_NO\r\n"
		           + "    JOIN PAYMENT PM ON O.ORDERS_NO = PM.ORDERS_NO\r\n"
		           + "    JOIN CARD_COMPANY C ON PM.CARD_COMPANY_NO = C.CARD_COMPANY_NO\r\n"
		           + "    WHERE P.SELLER_NO = "+loginSellerVo.getSellerNo()
		           + "    ORDER BY O.ORDERS_NO DESC\r\n"
		           + ")\r\n"
		           + "WHERE ROWNUM <= 3";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerSimpleOrderListVo> ssoVoList=new ArrayList<SellerSimpleOrderListVo>();
		while(rs.next()) {
			String ordersNo = rs.getString("ORDERS_NO");
	        String memberId = rs.getString("MEMBER_ID");
	        String memberName = rs.getString("MEMBER_NAME");
	        String statusName = rs.getString("STATUS_NAME");
	        String cardName = rs.getString("CARD_COMPANY_NAME");
	        String shippingFee = rs.getString("SHIPPING_FEE");
	        String productPrice = rs.getString("PRICE");
	        String createdDate = rs.getString("FORMATTED_DATE");
	        
	        SellerSimpleOrderListVo ssoVo=new SellerSimpleOrderListVo();
	        ssoVo.setOrdersNo(ordersNo);
            ssoVo.setMemberId(memberId);
            ssoVo.setMemberName(memberName);
            ssoVo.setStatusName(statusName);
            ssoVo.setCardName(cardName);
            ssoVo.setShippingFee(shippingFee);
            ssoVo.setProductPrice(productPrice);
            ssoVo.setCreatedDate(createdDate);
            
            ssoVoList.add(ssoVo);
		}
		
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return ssoVoList;
	}

}
