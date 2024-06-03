package com.lookman.app.seller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lookman.app.category.vo.CategoryVo;
import com.lookman.app.db.JDBCTemplate;
import com.lookman.app.product.vo.ProductColorVo;
import com.lookman.app.product.vo.ProductSizeVo;
import com.lookman.app.product.vo.ProductVo;
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

	public SellerStateVo getSellerStatus(Connection conn, String sellerNo) throws Exception {
		String sql="WITH 전체상품 AS (\r\n"
				+ "    SELECT COUNT(*) AS 전체상품\r\n"
				+ "    FROM PRODUCT P\r\n"
				+ "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "    WHERE S.SELLER_NO = "+sellerNo
				+ "),\r\n"
				+ "찜목록 AS (\r\n"
				+ "    SELECT COUNT(*) AS 찜목록\r\n"
				+ "    FROM PRODUCT P\r\n"
				+ "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "    JOIN FAVORITE F ON F.PRODUCT_NO = P.PRODUCT_NO \r\n"
				+ "    WHERE S.SELLER_NO = "+sellerNo
				+ "),\r\n"
				+ "주문량 AS (\r\n"
				+ "    SELECT \r\n"
				+ "        COUNT(*) AS 주문량,\r\n"
				+ "        SUM(P.PRICE) AS 총판매금액,\r\n"
				+ "        FLOOR(SUM(P.PRICE) * 0.1) AS 수수료,\r\n"
				+ "        SUM(P.PRICE) - FLOOR(SUM(P.PRICE) * 0.1) AS 순이익\r\n"
				+ "    FROM PRODUCT P\r\n"
				+ "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "    JOIN ORDER_DETAIL OD ON OD.PRODUCT_NO = P.PRODUCT_NO \r\n"
				+ "    WHERE S.SELLER_NO = "+sellerNo
				+ ")\r\n"
				+ "SELECT \r\n"
				+ "    (SELECT 전체상품 FROM 전체상품) AS 전체상품,\r\n"
				+ "    (SELECT 찜목록 FROM 찜목록) AS 찜목록,\r\n"
				+ "    주문량,\r\n"
				+ "    TO_CHAR(총판매금액, 'FM999,999,999,999,999,999') || '원' AS 총판매금액,\r\n"
				+ "    TO_CHAR(수수료, 'FM999,999,999,999,999,999') || '원' AS 수수료,\r\n"
				+ "    TO_CHAR(순이익, 'FM999,999,999,999,999,999') || '원' AS 순이익\r\n"
				+ "FROM 주문량";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		SellerStateVo spsVo=null;
		if(rs.next()) {
			String productCnt=rs.getString("전체상품");
			String favoriteCnt=rs.getString("찜목록");
			String orderCnt=rs.getString("주문량");
			String totalPrice=rs.getString("총판매금액");
			String charge=rs.getString("수수료");
			String netProfit=rs.getString("순이익");
			
			spsVo=new SellerStateVo();
			spsVo.setProductCnt(productCnt);
			spsVo.setFavoriteCnt(favoriteCnt);
			spsVo.setOrderCnt(orderCnt);
			spsVo.setTotalPrice(totalPrice);
			spsVo.setCharge(charge);
			spsVo.setNetProfit(netProfit);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return spsVo;
	}

	public List<SellerProductListVo> getProductListRowNum3(Connection conn, SellerVo loginSellerVo) throws Exception {
		String sql = "WITH RankedProducts AS (\r\n"
				+ "    SELECT \r\n"
				+ "        P.PRODUCT_NO,\r\n"
				+ "        C.NAME AS 카테고리,\r\n"
				+ "       	C.CATEGORY_NO AS 카테고리번호,\r\n"
				+ "       	PI.IMG_NO 이미지번호,\r\n"
				+ "        PI.FILENAME 이미지이름,\r\n"
				+ "        P.NAME AS 상품명,\r\n"
				+ "        P.PRICE AS 상품가격,\r\n"
				+ "        S.NAME AS 판매자,\r\n"
				+ "        TO_CHAR(P.CREATED_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') AS 등록일,\r\n"
				+ "        ROW_NUMBER() OVER (PARTITION BY P.PRODUCT_NO ORDER BY P.CREATED_DATE DESC) AS RN\r\n"
				+ "    FROM PRODUCT P \r\n"
				+ "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO\r\n"
				+ "    JOIN INVENTORY I ON P.PRODUCT_NO = I.PRODUCT_NO \r\n"
				+ "    JOIN COLOR C2 ON C2.COLOR_NO = I.COLOR_NO \r\n"
				+ "    JOIN PRODUCT_SIZE PS ON PS.SIZE_NO = I.SIZE_NO \r\n"
				+ "    JOIN PRODUCT_IMG PI ON PI.PRODUCT_NO = P.PRODUCT_NO\r\n"
				+ "    JOIN CATEGORY C ON C.CATEGORY_NO = P.CATEGORY_NO \r\n"
				+ "    WHERE S.SELLER_NO = "+loginSellerVo.getSellerNo()
				+ "    AND P.DELETED_YN = 'N'\r\n"
				+ ")\r\n"
				+ "SELECT \r\n"
				+ "    PRODUCT_NO AS 상품번호,\r\n"
				+ "    카테고리,\r\n"
				+ "    카테고리번호,\r\n"
				+ "    이미지이름,\r\n"
				+ "    이미지번호,\r\n"
				+ "    상품명,\r\n"
				+ "    TO_CHAR(상품가격, 'FM999,999,999,999,999,999') || '원' AS 상품가격,\r\n"
				+ "    판매자,\r\n"
				+ "    등록일\r\n"
				+ "FROM (\r\n"
				+ "    SELECT \r\n"
				+ "        PRODUCT_NO,\r\n"
				+ "        카테고리,\r\n"
				+ "        카테고리번호,\r\n"
				+ "        이미지이름,\r\n"
				+ "        이미지번호,\r\n"
				+ "        상품명,\r\n"
				+ "        상품가격,\r\n"
				+ "        판매자,\r\n"
				+ "        등록일,\r\n"
				+ "        ROWNUM AS RNUM\r\n"
				+ "    FROM (\r\n"
				+ "        SELECT *\r\n"
				+ "        FROM RankedProducts\r\n"
				+ "        WHERE RN = 1\r\n"
				+ "        ORDER BY 등록일 DESC\r\n"
				+ "    )\r\n"
				+ ")\r\n"
				+ "WHERE RNUM <= 3";

		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerProductListVo> splVoList=new ArrayList<SellerProductListVo>();
		while(rs.next()) {
			String productNo=rs.getString("상품번호");
			String categoryNo=rs.getString("카테고리번호");
			String categoryName=rs.getString("카테고리");
			String imgNo=rs.getString("이미지번호");
			String imgName=rs.getString("이미지이름");
			String productName=rs.getString("상품명");
			String productPrice=rs.getString("상품가격");
			String sellerName=rs.getString("판매자");
			String createDate=rs.getString("등록일");
			
			
			SellerProductListVo splVo=new SellerProductListVo();
			splVo.setProductNo(productNo);
			splVo.setCategoryNo(categoryNo);
			splVo.setCategoryName(categoryName);
			splVo.setImgNo(imgNo);
			splVo.setImgName(imgName);
			splVo.setProductName(productName);
			splVo.setProductPrice(productPrice);
			splVo.setSellerName(sellerName);
			splVo.setCreateDate(createDate);
			
			splVoList.add(splVo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		
		return splVoList;
	}

	public List<SellerProductInquiryVo> getProductInquiryListRowNum3(Connection conn, SellerVo loginSellerVo) throws Exception {
		String sql="SELECT *\r\n"
				+ "FROM (\r\n"
				+ "    SELECT \r\n"
				+ "        PI.PRODUCT_INQUIRY_NO AS 문의번호,\r\n"
				+ "        P.PRODUCT_NO AS 상품번호,\r\n"
				+ "        M.MEMBER_NO AS 회원번호,\r\n"
				+ "        M.NAME AS 회원닉네임,\r\n"
				+ "        PI.TITLE AS 문의제목,\r\n"
				+ "        S.SELLER_NO AS 판매자번호,\r\n"
				+ "        S2.STATUS_NO 상태번호,\r\n"
				+ "		S2.NAME 상태,\r\n"
				+ "        TO_CHAR(PI.ASK_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') AS 묻는날짜,\r\n"
				+ "        ROW_NUMBER() OVER (ORDER BY PI.ASK_DATE DESC) AS RN\r\n"
				+ "    FROM PRODUCT P\r\n"
				+ "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "    JOIN PRODUCT_INQUIRY PI ON PI.PRODUCT_NO = P.PRODUCT_NO \r\n"
				+ "    JOIN MEMBER M ON M.MEMBER_NO = PI.MEMBER_NO \r\n"
				+ "    JOIN STATUS S2 ON S2.STATUS_NO = PI.STATUS_NO \r\n"
				+ "    WHERE S.SELLER_NO = "+loginSellerVo.getSellerNo()
				+ ")\r\n"
				+ "WHERE RN <= 3\r\n"
				+ "ORDER BY 문의번호 DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerProductInquiryVo> spiVoList=new ArrayList<SellerProductInquiryVo>();
		while(rs.next()) {
			String productInquiryNo=rs.getString("문의번호");
			String productNo=rs.getString("상품번호");
			String sellerNo=rs.getString("판매자번호");
			String statusNo=rs.getString("상태번호");
			String statusName=rs.getString("상태");
			String memberName=rs.getString("회원닉네임");
			String memberNo=rs.getString("회원번호");
			String productInquiryTitle=rs.getString("문의제목");
			String askDate=rs.getString("묻는날짜");
			
			SellerProductInquiryVo spiVo=new SellerProductInquiryVo();
			spiVo.setProductInquiryNo(productInquiryNo);
			spiVo.setProductNo(productNo);
			spiVo.setSellerNo(sellerNo);
			spiVo.setStatusNo(statusNo);
			spiVo.setStatusName(statusName);
			spiVo.setMemberNo(memberNo);
			spiVo.setMemberName(memberName);
			spiVo.setProductInquiryTitle(productInquiryTitle);
			spiVo.setAskDate(askDate);
	        spiVoList.add(spiVo);

		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return spiVoList;
	}

	public List<SellerOrderListVo> getSimpleOrderListRowNum3(Connection conn, SellerVo loginSellerVo) throws Exception {
		String sql="SELECT \r\n"
				+ "    주문상세번호,\r\n"
				+ "    회원번호,\r\n"
				+ "    상품번호,\r\n"
				+ "    주문자,\r\n"
				+ "    상태번호,\r\n"
				+ "    주문상태,\r\n"
				+ "    판매자번호,\r\n"
				+ "    주문일\r\n"
				+ "FROM (\r\n"
				+ "    SELECT \r\n"
				+ "        OD.ORDERS_NO AS 주문상세번호,\r\n"
				+ "        M.MEMBER_NO AS 회원번호,\r\n"
				+ "        P.PRODUCT_NO AS 상품번호,\r\n"
				+ "        M.NAME AS 주문자,\r\n"
				+ "        s2.status_no AS 상태번호,\r\n"
				+ "        S2.NAME AS 주문상태,\r\n"
				+ "    	s.SELLER_NO 판매자번호,\r\n"
				+ "    	TO_CHAR(O.CREATED_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') AS 주문일,\r\n"
				+ "        ROW_NUMBER() OVER (ORDER BY O.ORDERS_NO DESC) AS RN\r\n"
				+ "    FROM PRODUCT P\r\n"
				+ "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "    JOIN ORDER_DETAIL OD ON OD.PRODUCT_NO = P.PRODUCT_NO\r\n"
				+ "    JOIN ORDERS O ON O.ORDERS_NO = OD.ORDERS_NO \r\n"
				+ "    JOIN MEMBER M ON M.MEMBER_NO = O.MEMBER_NO \r\n"
				+ "    JOIN STATUS S2 ON S2.STATUS_NO = OD.STATUS_NO \r\n"
				+ "    WHERE S.SELLER_NO = "+loginSellerVo.getSellerNo()
				+ ") \r\n"
				+ "WHERE RN <= 3";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerOrderListVo> solVoList=new ArrayList<SellerOrderListVo>();
		while(rs.next()) {
			String orderDetailNo=rs.getString("주문상세번호");
			String memberNo=rs.getString("회원번호");
			String memberName=rs.getString("주문자");
			String statusNo=rs.getString("상태번호");
			String statusName=rs.getString("주문상태");
			String productNo=rs.getString("상품번호");
			String sellerNo=rs.getString("판매자번호");
			String createdDate=rs.getString("주문일");
	        
	        SellerOrderListVo solVo=new SellerOrderListVo();
	        solVo.setOrderDetailNo(orderDetailNo);
	        solVo.setMemberNo(memberNo);
	        solVo.setMemberName(memberName);
	        solVo.setStatusNo(statusNo);
	        solVo.setStatusName(statusName);
	        solVo.setProductNo(productNo);
	        solVo.setSellerNo(sellerNo);
	        solVo.setCreateDate(createdDate);
            
            solVoList.add(solVo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
	
		return solVoList;
	}

	public List<ProductVo> getProductList(Connection conn, SellerVo loginSellerVo) throws Exception {
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
		           + "WHERE PI_RANKED.RN = 1 "
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

	public List<CategoryVo> getCategoryList(Connection conn) throws Exception {
		String sql="SELECT * FROM CATEGORY";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<CategoryVo> cVoList=new ArrayList<CategoryVo>();
		while(rs.next()) {
			String categoryNo = rs.getString("CATEGORY_NO");
			String categoryName = rs.getString("NAME");
			
			CategoryVo cVo=new CategoryVo();
			cVo.setCategoryNo(categoryNo);
			cVo.setName(categoryName);
			
			cVoList.add(cVo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return cVoList;
	}

	public List<ProductSizeVo> getSizeList(Connection conn) throws Exception {
		String sql="SELECT * FROM PRODUCT_SIZE";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs= pstmt.executeQuery();
		
		List<ProductSizeVo> psVoList=new ArrayList<ProductSizeVo>();
		while(rs.next()) {
			String sizeNo=rs.getString("SIZE_NO");
			String name=rs.getString("NAME");
			
			ProductSizeVo psVo=new ProductSizeVo();
			psVo.setSizeNo(sizeNo);
			psVo.setName(name);
			
			psVoList.add(psVo);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return psVoList;
	}

	public List<ProductColorVo> getColorList(Connection conn) throws Exception {
		String sql="SELECT * FROM COLOR";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<ProductColorVo> pcVoList=new ArrayList<ProductColorVo>();
		while(rs.next()) {
			String colorNo=rs.getString("COLOR_NO");
			String name=rs.getString("NAME");
			String hexcode=rs.getString("HEXCODE");
			
			ProductColorVo pcVo=new ProductColorVo();
			pcVo.setColorNo(colorNo);
			pcVo.setName(name);
			pcVo.setHexcode(hexcode);
			pcVoList.add(pcVo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return pcVoList;
	}

	public List<SellerProductListVo> getProductSearchList(Connection conn, SellerProductSearchVo spsVo, SellerVo loginSellerVo) throws Exception {
		String sql = "WITH RankedProducts AS ( " +
	             "SELECT P.PRODUCT_NO, C.NAME AS 카테고리, C.CATEGORY_NO AS 카테고리번호, " +
	             "P.NAME AS 상품명, PI.IMG_NO AS 이미지번호, PI.FILENAME AS 이미지이름, P.PRICE AS 상품가격, " +
	             "S.NAME AS 판매자, TO_CHAR(P.CREATED_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') AS 등록일, " +
	             "ROW_NUMBER() OVER (PARTITION BY P.PRODUCT_NO ORDER BY P.CREATED_DATE DESC) AS RN " +
	             "FROM PRODUCT P " +
	             "JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO " +
	             "JOIN INVENTORY I ON P.PRODUCT_NO = I.PRODUCT_NO " +
	             "JOIN COLOR C2 ON C2.COLOR_NO = I.COLOR_NO " +
	             "JOIN PRODUCT_SIZE PS ON PS.SIZE_NO = I.SIZE_NO " +
	             "JOIN PRODUCT_IMG PI ON PI.PRODUCT_NO = P.PRODUCT_NO " +
	             "JOIN CATEGORY C ON C.CATEGORY_NO = P.CATEGORY_NO " +
	             "WHERE S.SELLER_NO = " + loginSellerVo.getSellerNo() +
	             " AND P.DELETED_YN = 'N' ";

	if (!spsVo.getSearchText().equals("all")) {          
	    sql += "AND " + spsVo.getSearch() + " = '" + spsVo.getSearchText() + "' ";
	}

	if (!spsVo.getCategoryNo().equals("all")) {
	    sql += "AND C.CATEGORY_NO = '" + spsVo.getCategoryNo() + "' ";
	}

	sql += ") " +
	       "SELECT PRODUCT_NO AS 상품번호, 카테고리, 카테고리번호, 상품명, 이미지번호, 이미지이름, " +
	       "TO_CHAR(상품가격, 'FM999,999,999,999,999,999') || '원' AS 상품가격, " +
	       "판매자, 등록일 " +
	       "FROM ( " +
	       "SELECT PRODUCT_NO, 카테고리, 카테고리번호, 상품명, 이미지번호, 이미지이름, 상품가격, 판매자, 등록일, ROWNUM AS RNUM " +
	       "FROM ( " +
	       "SELECT * FROM RankedProducts WHERE RN = 1 ORDER BY 등록일 DESC " +
	       ") " +
	       ")";





	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery(sql);

	    List<SellerProductListVo> splVoList = new ArrayList<SellerProductListVo>();
	    while (rs.next()) {
	    	String productNo=rs.getString("상품번호");
			String categoryNo=rs.getString("카테고리번호");
			String categoryName=rs.getString("카테고리");
			String imgNo=rs.getString("이미지번호");
			String imgName=rs.getString("이미지이름");
			String productName=rs.getString("상품명");
			String productPrice=rs.getString("상품가격");
			String sellerName=rs.getString("판매자");
			String createDate=rs.getString("등록일");
			
			
			SellerProductListVo splVo=new SellerProductListVo();
			splVo.setProductNo(productNo);
			splVo.setCategoryNo(categoryNo);
			splVo.setCategoryName(categoryName);
			splVo.setImgNo(imgNo);
			splVo.setImgName(imgName);
			splVo.setProductName(productName);
			splVo.setProductPrice(productPrice);
			splVo.setSellerName(sellerName);
			splVo.setCreateDate(createDate);
			
			splVoList.add(splVo);
	    }

	
	    JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		

	    return splVoList;
	}

	public SellerInquiryVo getSellerInquiryVo(Connection conn, String sellerNo) throws Exception {
		String sql="SELECT\r\n"
				+ "    COUNT(*) AS \"전체 문의수\",\r\n"
				+ "    SUM(CASE WHEN PI.DELETED_YN = 'N' AND S2.STATUS_NO = 11 THEN 1 ELSE 0 END) AS \"미처리 문의수\",\r\n"
				+ "    SUM(CASE WHEN PI.DELETED_YN = 'N' AND S2.STATUS_NO = 12 THEN 1 ELSE 0 END) AS \"처리 문의수\",\r\n"
				+ "    SUM(CASE WHEN PI.DELETED_YN = 'Y' THEN 1 ELSE 0 END) AS \"삭제된 문의수\"\r\n"
				+ "FROM\r\n"
				+ "    PRODUCT P\r\n"
				+ "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO\r\n"
				+ "    JOIN PRODUCT_INQUIRY PI ON PI.PRODUCT_NO = P.PRODUCT_NO\r\n"
				+ "    LEFT JOIN STATUS S2 ON S2.STATUS_NO = PI.STATUS_NO\r\n"
				+ "WHERE\r\n"
				+ "    S.SELLER_NO = "+sellerNo;
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		
		SellerInquiryVo siVo=null;
		if(rs.next()) {
			String inquiryCnt=rs.getString("전체 문의수");
			String beforeInquiryCnt=rs.getString("미처리 문의수");
			String afterInquiryCnt=rs.getString("처리 문의수");
			String deleteInquiryCnt=rs.getString("삭제된 문의수");
			
			siVo=new SellerInquiryVo();
			siVo.setInquiryCnt(inquiryCnt);
			siVo.setBeforeInquiryCnt(beforeInquiryCnt);
			siVo.setAfterInquiryCnt(afterInquiryCnt);
			siVo.setDeleteInquiryCnt(deleteInquiryCnt);
		}
		return siVo;
	}

	public List<SellerProductListVo> getProductListDetail(Connection conn, SellerVo loginSellerVo,String productNo) throws Exception {
		String sql="SELECT \r\n"
				+ "	P.PRODUCT_NO 상품번호,\r\n"
				+ "	C.NAME 카테고리,\r\n"
				+ "	P.NAME 상품명,\r\n"
				+ "	P.PRICE 상품가격,\r\n"
				+ "	C2.NAME 색상,\r\n"
				+ "	PS.NAME 사이즈,\r\n"
				+ "	PI.IMG_NO 이미지번호,\r\n"
				+ "	PI.FILENAME 이미지이름,\r\n"
				+ "	I.QUANTITY 개수,\r\n"
				+ "	S.NAME 판매자,\r\n"
				+ "	S.SELLER_NO 판매자번호,\r\n"
				+ "	TO_CHAR(P.CREATED_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') AS 등록일\r\n"
				+ "FROM PRODUCT P \r\n"
				+ "JOIN SELLER S ON P.SELLER_NO =S.SELLER_NO\r\n"
				+ "JOIN INVENTORY I ON P.PRODUCT_NO =I.PRODUCT_NO \r\n"
				+ "JOIN COLOR C2 ON C2.COLOR_NO =I.COLOR_NO \r\n"
				+ "JOIN PRODUCT_SIZE PS ON PS.SIZE_NO =I.SIZE_NO \r\n"
				+ "JOIN PRODUCT_IMG PI ON PI.PRODUCT_NO =P.PRODUCT_NO\r\n"
				+ "JOIN CATEGORY C ON C.CATEGORY_NO =P.CATEGORY_NO \r\n"
				+ "WHERE S.SELLER_NO="+loginSellerVo.getSellerNo()
				+ "AND PI.THUMBNAIL_YN ='Y'"
				+ "AND P.DELETED_YN='N'\r\n"
				+ "AND P.PRODUCT_NO ="+productNo;
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerProductListVo> splVoList = new ArrayList<SellerProductListVo>();
		while(rs.next()) {
			String categoryName=rs.getString("카테고리");
			String colorName=rs.getString("색상");
			String sizeName=rs.getString("사이즈");
			String imgNo=rs.getString("이미지번호");
			String imgName=rs.getString("이미지이름");
			String productName=rs.getString("상품명");
			String productPrice=rs.getString("상품가격");
			String sellerName=rs.getString("판매자");
			String createDate=rs.getString("등록일");
			String quantity=rs.getString("개수");
			
			
			SellerProductListVo splVo=new SellerProductListVo();
			splVo.setProductNo(productNo);
			splVo.setCategoryName(categoryName);
			splVo.setColorName(colorName);
			splVo.setSizeName(sizeName);
			splVo.setImgName(imgName);
			splVo.setSellerName(sellerName);
			splVo.setProductName(productName);
			splVo.setProductPrice(productPrice);
			splVo.setCreateDate(createDate);
			splVo.setQuantity(quantity);
			
			splVoList.add(splVo);
		}
		
		return splVoList;
	}

	public List<SellerProductListVo> getProductDetailSearchList(Connection conn, SellerVo loginSellerVo,
			SellerProductSearchVo spsVo,String productNo) throws Exception {
		String sql = "SELECT \r\n"
				+ "	P.PRODUCT_NO 상품번호,\r\n"
				+ "	P.NAME 상품명,\r\n"
				+ "	C.CATEGORY_NO 카테고리번호,\r\n"
				+ "	C.NAME 카테고리,\r\n"
				+ "	P.PRICE 상품가격,\r\n"
				+ "	C2.COLOR_NO 색상번호,\r\n"
				+ "	C2.NAME 색상,\r\n"
				+ "	ps.SIZE_NO 사이즈번호,\r\n"
				+ "	PS.NAME 사이즈,\r\n"
				+ "	PI.IMG_NO 이미지번호,\r\n"
				+ "	PI.FILENAME 이미지이름,\r\n"
				+ "	I.QUANTITY 개수,\r\n"
				+ "	S.NAME 판매자,\r\n"
				+ "	S.SELLER_NO 판매자번호,\r\n"
				+ "	TO_CHAR(P.CREATED_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') AS 등록일\r\n"
				+ "FROM PRODUCT P \r\n"
				+ "JOIN SELLER S ON P.SELLER_NO =S.SELLER_NO\r\n"
				+ "JOIN INVENTORY I ON P.PRODUCT_NO =I.PRODUCT_NO \r\n"
				+ "JOIN COLOR C2 ON C2.COLOR_NO =I.COLOR_NO \r\n"
				+ "JOIN PRODUCT_SIZE PS ON PS.SIZE_NO =I.SIZE_NO \r\n"
				+ "JOIN PRODUCT_IMG PI ON PI.PRODUCT_NO =P.PRODUCT_NO\r\n"
				+ "JOIN CATEGORY C ON C.CATEGORY_NO =P.CATEGORY_NO \r\n"
				+ "WHERE S.SELLER_NO="+loginSellerVo.getSellerNo()
				+ "AND P.DELETED_YN='N'\r\n"
				+ "AND PI.THUMBNAIL_YN ='Y'"
				+ "AND P.PRODUCT_NO ="+productNo;
		if (!spsVo.getCategoryNo().equals("all")) {
		    sql += "AND C.CATEGORY_NO = '" + spsVo.getCategoryNo() + "' ";
		}
		if (!spsVo.getColorNo().equals("all")) {          
			sql += "AND C2.COLOR_NO = '" + spsVo.getColorNo() + "' ";
		}
		if (!spsVo.getSizeNo().equals("all")) {
		    sql += "AND PS.SIZE_NO = '" + spsVo.getSizeNo() + "' ";
		}


	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery(sql);

	    List<SellerProductListVo> splVoList = new ArrayList<SellerProductListVo>();
	    while (rs.next()) {
	    	String categoryName=rs.getString("카테고리");
			String colorName=rs.getString("색상");
			String sizeName=rs.getString("사이즈");
			String imgNo=rs.getString("이미지번호");
			String imgName=rs.getString("이미지이름");
			String productName=rs.getString("상품명");
			String productPrice=rs.getString("상품가격");
			String sellerName=rs.getString("판매자");
			String createDate=rs.getString("등록일");
			String quantity=rs.getString("개수");
			
			
			SellerProductListVo splVo=new SellerProductListVo();
			splVo.setProductNo(productNo);
			splVo.setCategoryName(categoryName);
			splVo.setColorName(colorName);
			splVo.setSizeName(sizeName);
			splVo.setImgName(imgName);
			splVo.setSellerName(sellerName);
			splVo.setProductName(productName);
			splVo.setProductPrice(productPrice);
			splVo.setCreateDate(createDate);
			splVo.setQuantity(quantity);
			
			splVoList.add(splVo);
	    }

	
	    JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		

	    return splVoList;
	}

	public List<SellerProductInquiryVo> getProductInquiryList(Connection conn, SellerVo loginSellerVo) throws Exception {
		String sql="SELECT \r\n"
				+ "	PI.PRODUCT_INQUIRY_NO 문의번호,\r\n"
				+ "	P.PRODUCT_NO 상품번호,\r\n"
				+ "	M.MEMBER_NO  회원번호,\r\n"
				+ "	M.NAME 회원닉네임,\r\n"
				+ "	PI.TITLE 문의제목,\r\n"
				+ "	S.SELLER_NO 판매자번호,\r\n"
				+ "	S2.STATUS_NO 상태번호,\r\n"
				+ "	S2.NAME 상태,\r\n"
				+ "	TO_CHAR(PI.ASK_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') 묻는날짜\r\n"
				+ "FROM PRODUCT P\r\n"
				+ "JOIN SELLER S ON P.SELLER_NO =S.SELLER_NO \r\n"
				+ "JOIN PRODUCT_INQUIRY PI ON PI.PRODUCT_NO = P.PRODUCT_NO \r\n"
				+ "JOIN MEMBER M ON M.MEMBER_NO =PI.MEMBER_NO \r\n"
				+ "JOIN STATUS S2 ON S2.STATUS_NO =PI.STATUS_NO \r\n"
				+ "WHERE S.SELLER_NO ="+loginSellerVo.getSellerNo()
				+ "ORDER BY 문의번호 DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerProductInquiryVo> spiVoList=new ArrayList<SellerProductInquiryVo>();
		while(rs.next()) {
			String productInquiryNo=rs.getString("문의번호");
			String productNo=rs.getString("상품번호");
			String sellerNo=rs.getString("판매자번호");
			String statusNo=rs.getString("상태번호");
			String statusName=rs.getString("상태");
			String memberName=rs.getString("회원닉네임");
			String memberNo=rs.getString("회원번호");
			String productInquiryTitle=rs.getString("문의제목");
			String askDate=rs.getString("묻는날짜");
			
			SellerProductInquiryVo spiVo=new SellerProductInquiryVo();
			spiVo.setProductInquiryNo(productInquiryNo);
			spiVo.setProductNo(productNo);
			spiVo.setSellerNo(sellerNo);
			spiVo.setStatusNo(statusNo);
			spiVo.setStatusName(statusName);
			spiVo.setMemberNo(memberNo);
			spiVo.setMemberName(memberName);
			spiVo.setProductInquiryTitle(productInquiryTitle);
			spiVo.setAskDate(askDate);
	        spiVoList.add(spiVo);

		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return spiVoList;
	}

	public List<SellerProductInquiryVo> getProductInquirySelectList(Connection conn, SellerVo loginSellerVo,
			SellerProductSearchVo spsVo) throws Exception {
		String sql="SELECT \r\n"
			    + "    PI.PRODUCT_INQUIRY_NO 문의번호,\r\n"
			    + "    P.PRODUCT_NO 상품번호,\r\n"
			    + "    M.MEMBER_NO  회원번호,\r\n"
			    + "    M.NAME 회원닉네임,\r\n"
			    + "    PI.TITLE 문의제목,\r\n"
			    + "    S.SELLER_NO 판매자번호,\r\n"
			    + "    S2.STATUS_NO 상태번호,\r\n"
			    + "    S2.NAME 상태,\r\n"
			    + "    TO_CHAR(PI.ASK_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') 묻는날짜\r\n"
			    + "FROM PRODUCT P\r\n"
			    + "JOIN SELLER S ON P.SELLER_NO =S.SELLER_NO \r\n"
			    + "JOIN PRODUCT_INQUIRY PI ON PI.PRODUCT_NO = P.PRODUCT_NO \r\n"
			    + "JOIN MEMBER M ON M.MEMBER_NO =PI.MEMBER_NO \r\n"
			    + "JOIN STATUS S2 ON S2.STATUS_NO =PI.STATUS_NO \r\n"
			    + "WHERE S.SELLER_NO =" + loginSellerVo.getSellerNo();

			// 검색어 및 카테고리 조건 추가
			if (!spsVo.getSearchText().equals("all")) {
			    sql += " AND " + spsVo.getSearch() + " = '" + spsVo.getSearchText() + "'";
			}

			if (!spsVo.getStatusNo().equals("all")) {
			    sql += " AND S2.STATUS_NO = '" + spsVo.getStatusNo() + "'";
			}

			// ORDER BY 문 추가
			sql += " ORDER BY 문의번호 DESC";

		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerProductInquiryVo> spiVoList=new ArrayList<SellerProductInquiryVo>();
		while(rs.next()) {
			String productInquiryNo=rs.getString("문의번호");
			String productNo=rs.getString("상품번호");
			String sellerNo=rs.getString("판매자번호");
			String statusNo=rs.getString("상태번호");
			String statusName=rs.getString("상태");
			String memberName=rs.getString("회원닉네임");
			String memberNo=rs.getString("회원번호");
			String productInquiryTitle=rs.getString("문의제목");
			String askDate=rs.getString("묻는날짜");
			
			SellerProductInquiryVo spiVo=new SellerProductInquiryVo();
			spiVo.setProductInquiryNo(productInquiryNo);
			spiVo.setProductNo(productNo);
			spiVo.setSellerNo(sellerNo);
			spiVo.setStatusNo(statusNo);
			spiVo.setStatusName(statusName);
			spiVo.setMemberNo(memberNo);
			spiVo.setMemberName(memberName);
			spiVo.setProductInquiryTitle(productInquiryTitle);
			spiVo.setAskDate(askDate);
	        spiVoList.add(spiVo);

		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return spiVoList;
	}

	public List<SellerProductReviewListVo> getReviewListRownum3(Connection conn, SellerVo loginSellerVo) throws Exception {
		String sql="SELECT \r\n"
				+ "	R.REVIEW_NO 리뷰번호,\r\n"
				+ "	P.PRODUCT_NO 상품번호,\r\n"
				+ "	M.MEMBER_NO 회원번호,\r\n"
				+ "	M.NAME 회원이름,\r\n"
				+ "	R.RATING 별점,\r\n"
				+ "	R.CONTENT 후기내용,\r\n"
				+ "	TO_CHAR(R.CREATED_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') AS 등록일\r\n"
				+ "FROM PRODUCT P\r\n"
				+ "JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "JOIN REVIEW R ON R.PRODUCT_NO = P.PRODUCT_NO \r\n"
				+ "JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO \r\n"
				+ "WHERE S.SELLER_NO ="+loginSellerVo.getSellerNo()
				+ "AND S.DELETED_YN ='N' "
				+ "ORDER BY R.REVIEW_NO DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerProductReviewListVo> sprListVo=new ArrayList<SellerProductReviewListVo>();
		while(rs.next()) {
			String reviewNo=rs.getString("리뷰번호");
			String productNo=rs.getString("상품번호");
			String memberNo=rs.getString("회원번호");
			String memberName=rs.getString("회원이름");
			String rating=rs.getString("별점");
			String content=rs.getString("후기내용");
			String createdDate=rs.getString("등록일");
			
			SellerProductReviewListVo sprVo=new SellerProductReviewListVo();
			sprVo.setReviewNo(reviewNo);
			sprVo.setProductNo(productNo);
			sprVo.setMemberNo(memberNo);
			sprVo.setMemberName(memberName);
			sprVo.setRating(rating);
			sprVo.setContent(content);
			sprVo.setCreatedDate(createdDate);
			
			sprListVo.add(sprVo);
		}
		return sprListVo;
	}

	public List<SellerProductReviewListVo> getReviewList(Connection conn, SellerVo loginSellerVo,
			SellerProductSearchVo spsVo) throws Exception {
		String sql="SELECT \r\n"
				+ "	R.REVIEW_NO 리뷰번호,\r\n"
				+ "	P.PRODUCT_NO 상품번호,\r\n"
				+ "	M.MEMBER_NO 회원번호,\r\n"
				+ "	M.NAME 회원이름,\r\n"
				+ "	R.RATING 별점,\r\n"
				+ "	R.CONTENT 후기내용,\r\n"
				+ "	TO_CHAR(R.CREATED_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') AS 등록일\r\n"
				+ "FROM PRODUCT P\r\n"
				+ "JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "JOIN REVIEW R ON R.PRODUCT_NO = P.PRODUCT_NO \r\n"
				+ "JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO \r\n"
				+ "WHERE S.SELLER_NO ="+loginSellerVo.getSellerNo()
				+ "AND S.DELETED_YN ='N' ";
		if (!spsVo.getSearchText().equals("all")) {          
		    sql += "AND " + spsVo.getSearch() + " = '" + spsVo.getSearchText() + "' ";
		}
		sql	+= "ORDER BY R.REVIEW_NO DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerProductReviewListVo> sprListVo=new ArrayList<SellerProductReviewListVo>();
		while(rs.next()) {
			String reviewNo=rs.getString("리뷰번호");
			String productNo=rs.getString("상품번호");
			String memberNo=rs.getString("회원번호");
			String memberName=rs.getString("회원이름");
			String rating=rs.getString("별점");
			String content=rs.getString("후기내용");
			String createdDate=rs.getString("등록일");
			
			SellerProductReviewListVo sprVo=new SellerProductReviewListVo();
			sprVo.setReviewNo(reviewNo);
			sprVo.setProductNo(productNo);
			sprVo.setMemberNo(memberNo);
			sprVo.setMemberName(memberName);
			sprVo.setRating(rating);
			sprVo.setContent(content);
			sprVo.setCreatedDate(createdDate);
			
			sprListVo.add(sprVo);
		}
		return sprListVo;
	}

	public List<SellerOrderListVo> getSimpleOrderList(Connection conn, SellerVo loginSellerVo) throws Exception {
		String sql="SELECT \r\n"
				+ "    주문상세번호,\r\n"
				+ "    회원번호,\r\n"
				+ "    상품번호,\r\n"
				+ "    주문자,\r\n"
				+ "    상태번호,\r\n"
				+ "    주문상태,\r\n"
				+ "    판매자번호,\r\n"
				+ "    주문일\r\n"
				+ "FROM (\r\n"
				+ "    SELECT \r\n"
				+ "        OD.ORDERS_NO AS 주문상세번호,\r\n"
				+ "        M.MEMBER_NO AS 회원번호,\r\n"
				+ "        P.PRODUCT_NO AS 상품번호,\r\n"
				+ "        M.NAME AS 주문자,\r\n"
				+ "        s2.status_no AS 상태번호,\r\n"
				+ "        S2.NAME AS 주문상태,\r\n"
				+ "    	s.SELLER_NO 판매자번호,\r\n"
				+ "    	TO_CHAR(O.CREATED_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') AS 주문일,\r\n"
				+ "        ROW_NUMBER() OVER (ORDER BY O.ORDERS_NO DESC) AS RN\r\n"
				+ "    FROM PRODUCT P\r\n"
				+ "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "    JOIN ORDER_DETAIL OD ON OD.PRODUCT_NO = P.PRODUCT_NO\r\n"
				+ "    JOIN ORDERS O ON O.ORDERS_NO = OD.ORDERS_NO \r\n"
				+ "    JOIN MEMBER M ON M.MEMBER_NO = O.MEMBER_NO \r\n"
				+ "    JOIN STATUS S2 ON S2.STATUS_NO = OD.STATUS_NO \r\n"
				+ "    WHERE S.SELLER_NO = "+loginSellerVo.getSellerNo()
				+ ") \r\n";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerOrderListVo> solVoList=new ArrayList<SellerOrderListVo>();
		while(rs.next()) {
			String orderDetailNo=rs.getString("주문상세번호");
			String memberNo=rs.getString("회원번호");
			String memberName=rs.getString("주문자");
			String statusNo=rs.getString("상태번호");
			String statusName=rs.getString("주문상태");
			String productNo=rs.getString("상품번호");
			String sellerNo=rs.getString("판매자번호");
			String createdDate=rs.getString("주문일");
	        
	        SellerOrderListVo solVo=new SellerOrderListVo();
	        solVo.setOrderDetailNo(orderDetailNo);
	        solVo.setMemberNo(memberNo);
	        solVo.setMemberName(memberName);
	        solVo.setStatusNo(statusNo);
	        solVo.setStatusName(statusName);
	        solVo.setProductNo(productNo);
	        solVo.setSellerNo(sellerNo);
	        solVo.setCreateDate(createdDate);
            
            solVoList.add(solVo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
	
		return solVoList;
	}

	public List<SellerOrderListVo> getSimpleOrderSearchList(Connection conn, SellerVo loginSellerVo,
			SellerProductSearchVo spsVo) throws Exception {
		String sql="SELECT \r\n"
				+ "    주문상세번호,\r\n"
				+ "    회원번호,\r\n"
				+ "    상품번호,\r\n"
				+ "    주문자,\r\n"
				+ "    상태번호,\r\n"
				+ "    주문상태,\r\n"
				+ "    판매자번호,\r\n"
				+ "    주문일\r\n"
				+ "FROM (\r\n"
				+ "    SELECT \r\n"
				+ "        OD.ORDERS_NO AS 주문상세번호,\r\n"
				+ "        M.MEMBER_NO AS 회원번호,\r\n"
				+ "        P.PRODUCT_NO AS 상품번호,\r\n"
				+ "        M.NAME AS 주문자,\r\n"
				+ "        s2.status_no AS 상태번호,\r\n"
				+ "        S2.NAME AS 주문상태,\r\n"
				+ "    	s.SELLER_NO 판매자번호,\r\n"
				+ "    	TO_CHAR(O.CREATED_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') AS 주문일,\r\n"
				+ "        ROW_NUMBER() OVER (ORDER BY O.ORDERS_NO DESC) AS RN\r\n"
				+ "    FROM PRODUCT P\r\n"
				+ "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "    JOIN ORDER_DETAIL OD ON OD.PRODUCT_NO = P.PRODUCT_NO\r\n"
				+ "    JOIN ORDERS O ON O.ORDERS_NO = OD.ORDERS_NO \r\n"
				+ "    JOIN MEMBER M ON M.MEMBER_NO = O.MEMBER_NO \r\n"
				+ "    JOIN STATUS S2 ON S2.STATUS_NO = OD.STATUS_NO \r\n"
				+ "    WHERE S.SELLER_NO = "+loginSellerVo.getSellerNo();
		if (!spsVo.getSearchText().equals("all")) {
		    sql += " AND " + spsVo.getSearch() + " = '" + spsVo.getSearchText() + "'";
		}

		if (!spsVo.getStatusNo().equals("all")) {
		    sql += " AND S2.STATUS_NO = '" + spsVo.getStatusNo() + "'";
		}
		sql += ") \r\n";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerOrderListVo> solVoList=new ArrayList<SellerOrderListVo>();
		while(rs.next()) {
			String orderDetailNo=rs.getString("주문상세번호");
			String memberNo=rs.getString("회원번호");
			String memberName=rs.getString("주문자");
			String statusNo=rs.getString("상태번호");
			String statusName=rs.getString("주문상태");
			String productNo=rs.getString("상품번호");
			String sellerNo=rs.getString("판매자번호");
			String createdDate=rs.getString("주문일");
	        
	        SellerOrderListVo solVo=new SellerOrderListVo();
	        solVo.setOrderDetailNo(orderDetailNo);
	        solVo.setMemberNo(memberNo);
	        solVo.setMemberName(memberName);
	        solVo.setStatusNo(statusNo);
	        solVo.setStatusName(statusName);
	        solVo.setProductNo(productNo);
	        solVo.setSellerNo(sellerNo);
	        solVo.setCreateDate(createdDate);
            
            solVoList.add(solVo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
	
		return solVoList;
	}

	public List<SellerOrderListVo> getSimpleOrderSearchListPrice(Connection conn, SellerVo loginSellerVo) throws Exception {
		String sql="SELECT \r\n"
				+ "	OD.ORDERS_NO 주문상세번호,\r\n"
				+ "	P.PRODUCT_NO 상품번호,\r\n"
				+ "	M.NAME 주문자,\r\n"
				+ "	s2.NAME  주문상태,\r\n"
				+ "	P.PRICE 상품가격\r\n"
				+ "FROM PRODUCT P\r\n"
				+ "JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "JOIN ORDER_DETAIL OD ON OD.PRODUCT_NO =P.PRODUCT_NO\r\n"
				+ "JOIN ORDERS O ON O.ORDERS_NO =OD.ORDERS_NO \r\n"
				+ "JOIN MEMBER M ON M.MEMBER_NO =O.MEMBER_NO \r\n"
				+ "JOIN STATUS S2 ON S2.STATUS_NO =OD.STATUS_NO\r\n"
				+ "WHERE S.SELLER_NO ="+loginSellerVo.getSellerNo();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerOrderListVo> solVoList=new ArrayList<SellerOrderListVo>();
		while(rs.next()) {
			String orderDetailNo=rs.getString("주문상세번호");
			String memberName=rs.getString("주문자");
			String statusName=rs.getString("주문상태");
			String productNo=rs.getString("상품번호");
			String price=rs.getString("상품가격");
	        
	        SellerOrderListVo solVo=new SellerOrderListVo();
	        solVo.setOrderDetailNo(orderDetailNo);
	        solVo.setMemberName(memberName);
	        solVo.setStatusName(statusName);
	        solVo.setProductNo(productNo);
	        solVo.setPrice(price);
            
            solVoList.add(solVo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
	
		return solVoList;
	}

	public SellerStatisticsVo getSellerStatistics(Connection conn, SellerVo loginSellerVo) throws Exception {
		String sql="SELECT \r\n"
				+ "    FLOOR(AVG(P.PRICE)) AS 평균가격,\r\n"
				+ "    SUM(P.PRICE) AS 총가격,\r\n"
				+ "    MIN(P.PRICE) AS 최소가격,\r\n"
				+ "    MAX(P.PRICE) AS 최대가격,\r\n"
				+ "    COUNT(P.PRICE) AS 가격개수\r\n"
				+ "FROM PRODUCT P\r\n"
				+ "JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "JOIN ORDER_DETAIL OD ON OD.PRODUCT_NO = P.PRODUCT_NO\r\n"
				+ "JOIN ORDERS O ON O.ORDERS_NO = OD.ORDERS_NO \r\n"
				+ "JOIN MEMBER M ON M.MEMBER_NO = O.MEMBER_NO \r\n"
				+ "JOIN STATUS S2 ON S2.STATUS_NO = OD.STATUS_NO\r\n"
				+ "WHERE S.SELLER_NO = "+loginSellerVo.getSellerNo();
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		SellerStatisticsVo sssVo=null;
		if(rs.next()) {
			String avg =rs.getString("평균가격");
			String total=rs.getString("총가격");
			String max=rs.getString("최대가격");
			String min=rs.getString("최소가격");
			String cnt=rs.getString("가격개수");
			
			sssVo=new SellerStatisticsVo();
			sssVo.setAvg(avg);
			sssVo.setTotal(total);
			sssVo.setMax(max);
			sssVo.setMin(min);
			sssVo.setCnt(cnt);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return sssVo;
	}

	public SellerProductInquiryVo getSellerInquirySelect(Connection conn, SellerVo loginSellerVo,
			String productInquiryNo) throws Exception {
		String sql="SELECT \r\n"
				+ "	PI.PRODUCT_INQUIRY_NO 문의번호,\r\n"
				+ "	P.PRODUCT_NO 상품번호,\r\n"
				+ "	M.MEMBER_NO  회원번호,\r\n"
				+ "	M.NAME 회원닉네임,\r\n"
				+ "	PI.TITLE 문의제목,\r\n"
				+ "	S.SELLER_NO 판매자번호,\r\n"
				+ "	S2.STATUS_NO 상태번호,\r\n"
				+ "	S2.NAME 상태,\r\n"
				+ "	TO_CHAR(PI.ASK_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') 묻는날짜,\r\n"
				+ "	PI.QUESTION_CONTENT 문의내용,\r\n"
				+ "	PI.RESPONSE_CONTENT 문의답변,\r\n"
				+ "	TO_CHAR(PI.RESPONSE_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') 답변날짜\r\n"
				+ "FROM PRODUCT P\r\n"
				+ "JOIN SELLER S ON P.SELLER_NO =S.SELLER_NO \r\n"
				+ "JOIN PRODUCT_INQUIRY PI ON PI.PRODUCT_NO = P.PRODUCT_NO \r\n"
				+ "JOIN MEMBER M ON M.MEMBER_NO =PI.MEMBER_NO \r\n"
				+ "JOIN STATUS S2 ON S2.STATUS_NO =PI.STATUS_NO \r\n"
				+ "WHERE S.SELLER_NO ="+loginSellerVo.getSellerNo()+" "
				+ "AND PI.PRODUCT_INQUIRY_NO = "+productInquiryNo+" "
				+ "ORDER BY 문의번호 DESC";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		SellerProductInquiryVo spiVo=null;
		if(rs.next()) {
//			String productInquiryNo=rs.getString("문의번호");
			String productNo=rs.getString("상품번호");
			String sellerNo=rs.getString("판매자번호");
			String statusNo=rs.getString("상태번호");
			String statusName=rs.getString("상태");
			String memberName=rs.getString("회원닉네임");
			String memberNo=rs.getString("회원번호");
			String productInquiryTitle=rs.getString("문의제목");
			String askDate=rs.getString("묻는날짜");
			String qContent=rs.getString("문의내용");
			String respContent=rs.getString("문의답변");
			String respDate=rs.getString("묻는날짜");
			
			spiVo=new SellerProductInquiryVo();
			
			spiVo.setProductInquiryNo(productInquiryNo);
			spiVo.setProductNo(productNo);
			spiVo.setSellerNo(sellerNo);
			spiVo.setStatusNo(statusNo);
			spiVo.setStatusName(statusName);
			spiVo.setMemberNo(memberNo);
			spiVo.setMemberName(memberName);
			spiVo.setProductInquiryTitle(productInquiryTitle);
			spiVo.setAskDate(askDate);
			spiVo.setqContent(qContent);
			spiVo.setRespContent(respContent);
			spiVo.setRespDate(respDate);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return spiVo;
	}

	public int updateInquiry(Connection conn, SellerVo loginSellerVo, String productInquiryNo,String askText) throws Exception {
		String sql = "UPDATE PRODUCT_INQUIRY "
		           + "SET RESPONSE_CONTENT = ?, "
		           + "    RESPONSE_DATE = SYSDATE, "
		           + "    STATUS_NO =12 "
		           + "WHERE PRODUCT_INQUIRY_NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, askText); // 물음표(?)에 대응하는 값을 설정
		pstmt.setString(2, productInquiryNo); // 물음표(?)에 대응하는 값을 설정
		int result = pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
		return result;
	}

	public int getOrderUpdatePrepare(Connection conn,String orderDetailNo) throws Exception {
		String sql="UPDATE ORDER_DETAIL \r\n"
				+ "	SET STATUS_NO =3\r\n"
				+ "WHERE ORDER_DETAIL_NO =?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, orderDetailNo);
		int result=pstmt.executeUpdate();
		System.out.println("dao : "+orderDetailNo);
		System.out.println("result : "+result);
		JDBCTemplate.close(pstmt);
		return result;
	}

	public int getOrderUpdateStart(Connection conn, String orderDetailNo) throws Exception {
		String sql="UPDATE ORDER_DETAIL \r\n"
				+ "	SET STATUS_NO =4\r\n"
				+ "WHERE ORDER_DETAIL_NO =?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, orderDetailNo);
		int result=pstmt.executeUpdate();
		System.out.println("dao : "+orderDetailNo);
		System.out.println("result : "+result);
		JDBCTemplate.close(pstmt);
		return result;
	}

	public int getOrderUpdateComplete(Connection conn, String orderDetailNo) throws Exception {
		String sql="UPDATE ORDER_DETAIL \r\n"
				+ "	SET STATUS_NO =5\r\n"
				+ "WHERE ORDER_DETAIL_NO =?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, orderDetailNo);
		int result=pstmt.executeUpdate();
		System.out.println("dao : "+orderDetailNo);
		System.out.println("result : "+result);
		JDBCTemplate.close(pstmt);
		return result;
	}

	public void getProductInsert(Connection conn, SellerVo loginSellerVo, SellerProductInsertVo spInsertVo) throws Exception {
		String sql="DECLARE\r\n"
				+ "    v_product_no NUMBER;\r\n"
				+ "BEGIN\r\n"
				+ "    -- PRODUCT 테이블에 데이터 삽입\r\n"
				+ "    INSERT INTO PRODUCT (PRODUCT_NO,SELLER_NO,CATEGORY_NO,NAME,DETAILS,PRICE,CREATED_DATE)\r\n"
				+ "    VALUES(SEQ_PRODUCT.NEXTVAL,?,?,?,?,?,SYSDATE)\r\n"
				+ "    RETURNING PRODUCT_NO INTO v_product_no;\r\n"
				+ "\r\n"
				+ "    -- INVENTORY 테이블에 데이터 삽입\r\n"
				+ "    INSERT INTO INVENTORY(INVENTORY_NO,PRODUCT_NO,COLOR_NO,SIZE_NO,QUANTITY)\r\n"
				+ "    VALUES(SEQ_INVENTORY.NEXTVAL,v_product_no,?,?,?);\r\n"
				+ "\r\n"
				+ "    -- PRODUCT_IMG 테이블에 데이터 삽입\r\n"
				+ "    INSERT INTO PRODUCT_IMG (IMG_NO,PRODUCT_NO,FILENAME,THUMBNAIL_YN,CREATED_DATE)\r\n"
				+ "    VALUES(SEQ_PRODUCT_IMG.NEXTVAL,v_product_no,?,'Y',SYSDATE);\r\n"
				+ "    \r\n"
				+ "    COMMIT;\r\n"
				+ "END;\r\n";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, loginSellerVo.getSellerNo());
		pstmt.setString(2, spInsertVo.getCategory());
		pstmt.setString(3, spInsertVo.getTitle());
		pstmt.setString(4, spInsertVo.getContent());
		pstmt.setString(5, spInsertVo.getPrice());
		pstmt.setString(6, spInsertVo.getColor());
		pstmt.setString(7, spInsertVo.getSize());
		pstmt.setString(8, spInsertVo.getCnt());
		pstmt.setString(9, spInsertVo.getThumbnailFileName());
		pstmt.executeUpdate();
		JDBCTemplate.close(pstmt);
	}

	public SellerStateVo getSellerStatus(Connection conn) throws Exception {
		String sql="WITH 전체상품 AS (\r\n"
				+ "    SELECT COUNT(*) AS 전체상품\r\n"
				+ "    FROM PRODUCT P\r\n"
				+ "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "),\r\n"
				+ "찜목록 AS (\r\n"
				+ "    SELECT COUNT(*) AS 찜목록\r\n"
				+ "    FROM PRODUCT P\r\n"
				+ "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "    JOIN FAVORITE F ON F.PRODUCT_NO = P.PRODUCT_NO \r\n"
				+ "),\r\n"
				+ "주문량 AS (\r\n"
				+ "    SELECT \r\n"
				+ "        COUNT(*) AS 주문량,\r\n"
				+ "        SUM(P.PRICE) AS 총판매금액,\r\n"
				+ "        FLOOR(SUM(P.PRICE) * 0.1) AS 수수료,\r\n"
				+ "        SUM(P.PRICE) - FLOOR(SUM(P.PRICE) * 0.1) AS 순이익\r\n"
				+ "    FROM PRODUCT P\r\n"
				+ "    JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "    JOIN ORDER_DETAIL OD ON OD.PRODUCT_NO = P.PRODUCT_NO \r\n"
				+ ")\r\n"
				+ "SELECT \r\n"
				+ "    (SELECT 전체상품 FROM 전체상품) AS 전체상품,\r\n"
				+ "    (SELECT 찜목록 FROM 찜목록) AS 찜목록,\r\n"
				+ "    주문량,\r\n"
				+ "    TO_CHAR(총판매금액, 'FM999,999,999,999,999,999') || '원' AS 총판매금액,\r\n"
				+ "    TO_CHAR(수수료, 'FM999,999,999,999,999,999') || '원' AS 수수료,\r\n"
				+ "    TO_CHAR(순이익, 'FM999,999,999,999,999,999') || '원' AS 순이익\r\n"
				+ "FROM 주문량";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		SellerStateVo spsVo=null;
		if(rs.next()) {
			String productCnt=rs.getString("전체상품");
			String favoriteCnt=rs.getString("찜목록");
			String orderCnt=rs.getString("주문량");
			String totalPrice=rs.getString("총판매금액");
			String charge=rs.getString("수수료");
			String netProfit=rs.getString("순이익");
			
			spsVo=new SellerStateVo();
			spsVo.setProductCnt(productCnt);
			spsVo.setFavoriteCnt(favoriteCnt);
			spsVo.setOrderCnt(orderCnt);
			spsVo.setTotalPrice(totalPrice);
			spsVo.setCharge(charge);
			spsVo.setNetProfit(netProfit);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return spsVo;
	}

	public SellerStatisticsVo getSellerStatistics(Connection conn) throws Exception {
		String sql="SELECT \r\n"
				+ "    FLOOR(AVG(P.PRICE)) AS 평균가격,\r\n"
				+ "    SUM(P.PRICE) AS 총가격,\r\n"
				+ "    MIN(P.PRICE) AS 최소가격,\r\n"
				+ "    MAX(P.PRICE) AS 최대가격,\r\n"
				+ "    COUNT(P.PRICE) AS 가격개수\r\n"
				+ "FROM PRODUCT P\r\n"
				+ "JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "JOIN ORDER_DETAIL OD ON OD.PRODUCT_NO = P.PRODUCT_NO\r\n"
				+ "JOIN ORDERS O ON O.ORDERS_NO = OD.ORDERS_NO \r\n"
				+ "JOIN MEMBER M ON M.MEMBER_NO = O.MEMBER_NO \r\n"
				+ "JOIN STATUS S2 ON S2.STATUS_NO = OD.STATUS_NO\r\n";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		SellerStatisticsVo sssVo=null;
		if(rs.next()) {
			String avg =rs.getString("평균가격");
			String total=rs.getString("총가격");
			String max=rs.getString("최대가격");
			String min=rs.getString("최소가격");
			String cnt=rs.getString("가격개수");
			
			sssVo=new SellerStatisticsVo();
			sssVo.setAvg(avg);
			sssVo.setTotal(total);
			sssVo.setMax(max);
			sssVo.setMin(min);
			sssVo.setCnt(cnt);
		}
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		return sssVo;
	}

	public List<SellerOrderListVo> getSimpleOrderSearchListPrice(Connection conn) throws Exception {
		String sql="SELECT \r\n"
				+ "	OD.ORDERS_NO 주문상세번호,\r\n"
				+ "	P.PRODUCT_NO 상품번호,\r\n"
				+ "	M.NAME 주문자,\r\n"
				+ "	s2.NAME  주문상태,\r\n"
				+ "	P.PRICE 상품가격\r\n"
				+ "FROM PRODUCT P\r\n"
				+ "JOIN SELLER S ON P.SELLER_NO = S.SELLER_NO \r\n"
				+ "JOIN ORDER_DETAIL OD ON OD.PRODUCT_NO =P.PRODUCT_NO\r\n"
				+ "JOIN ORDERS O ON O.ORDERS_NO =OD.ORDERS_NO \r\n"
				+ "JOIN MEMBER M ON M.MEMBER_NO =O.MEMBER_NO \r\n"
				+ "JOIN STATUS S2 ON S2.STATUS_NO =OD.STATUS_NO\r\n";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerOrderListVo> solVoList=new ArrayList<SellerOrderListVo>();
		while(rs.next()) {
			String orderDetailNo=rs.getString("주문상세번호");
			String memberName=rs.getString("주문자");
			String statusName=rs.getString("주문상태");
			String productNo=rs.getString("상품번호");
			String price=rs.getString("상품가격");
	        
	        SellerOrderListVo solVo=new SellerOrderListVo();
	        solVo.setOrderDetailNo(orderDetailNo);
	        solVo.setMemberName(memberName);
	        solVo.setStatusName(statusName);
	        solVo.setProductNo(productNo);
	        solVo.setPrice(price);
            
            solVoList.add(solVo);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
	
		return solVoList;
	}

}
