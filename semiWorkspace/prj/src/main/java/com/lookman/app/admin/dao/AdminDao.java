package com.lookman.app.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lookman.app.admin.member.vo.AdminOrderListVo;
import com.lookman.app.admin.vo.AdminVo;
import com.lookman.app.admin.vo.CouponListVo;
import com.lookman.app.admin.vo.ReportListVo;
import com.lookman.app.admin.vo.UserVo;
import com.lookman.app.db.JDBCTemplate;
import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.seller.vo.SellerStateVo;
import com.lookman.app.seller.vo.SellerVo;

public class AdminDao {

	public AdminVo getAdminVo(Connection conn, AdminVo vo) throws Exception {
		String sql="SELECT *\r\n"
				+ "FROM ADMIN\r\n"
				+ "WHERE ID = ?\r\n"
				+ "AND PWD = ?\r\n"
				+ "AND DELETED_YN ='N'";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, vo.getAdminId());
		pstmt.setString(2, vo.getAdminPwd());
		ResultSet rs=pstmt.executeQuery();
		
		AdminVo loginAdminVo=null;
		if(rs.next()) {
			String no=rs.getString("ADMIN_NO");
			String id=rs.getString("ID");
			String pwd=rs.getString("PWD");
			String nick=rs.getString("NICK");
			
			loginAdminVo=new AdminVo();
			loginAdminVo.setAdminNo(no);
			loginAdminVo.setAdminId(id);
			loginAdminVo.setAdminPwd(pwd);
			loginAdminVo.setAdminNick(nick);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return loginAdminVo;
	}

	public UserVo getUserCnt(Connection conn, AdminVo loginAdminVo) throws Exception {
		String sql="SELECT \r\n"
				+ "    일반회원,\r\n"
				+ "    멤버쉽회원,\r\n"
				+ "    판매자수,\r\n"
				+ "    (일반회원 + 멤버쉽회원 + 판매자수) AS 총사용자\r\n"
				+ "FROM (\r\n"
				+ "    SELECT \r\n"
				+ "        (SELECT COUNT(*) FROM MEMBER WHERE DELETED_YN ='N' AND PREMIUM_YN ='N') AS 일반회원,\r\n"
				+ "        (SELECT COUNT(*) FROM MEMBER WHERE DELETED_YN ='N' AND PREMIUM_YN ='Y') AS 멤버쉽회원,\r\n"
				+ "        (SELECT COUNT(*) FROM SELLER) AS 판매자수\r\n"
				+ "    FROM DUAL\r\n"
				+ ")";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		UserVo uVo=null;
		if(rs.next()) {
			String member=rs.getString("일반회원");
			String membershipMember=rs.getString("멤버쉽회원");
			String seller=rs.getString("판매자수");
			String total=rs.getString("총사용자");
			
			uVo=new UserVo();
			uVo.setMember(member);
			uVo.setMembershipMember(membershipMember);
			uVo.setSeller(seller);
			uVo.setTotalUser(total);
		}
		
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
		
		return uVo;
	}

	public SellerStateVo getTotalPrice(Connection conn) throws Exception {
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

	public List<CouponListVo> getCouponList(Connection conn) throws Exception {
		String sql="SELECT \r\n"
				+ "    쿠폰번호,\r\n"
				+ "    쿠폰이름,\r\n"
				+ "    쿠폰코드,\r\n"
				+ "    할인가격,\r\n"
				+ "    남은수,\r\n"
				+ "    유효기간\r\n"
				+ "FROM (\r\n"
				+ "    SELECT \r\n"
				+ "        C.COUPON_NO 쿠폰번호,\r\n"
				+ "        C.NAME 쿠폰이름,\r\n"
				+ "        C.CODE 쿠폰코드,\r\n"
				+ "        C.DISCOUNT_PRICE 할인가격,\r\n"
				+ "        C.USAGE_LIMIT 남은수,\r\n"
				+ "        TO_CHAR(C.EXPIRY_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') 유효기간,\r\n"
				+ "        ROWNUM rnum\r\n"
				+ "    FROM (\r\n"
				+ "        SELECT \r\n"
				+ "            COUPON_NO,\r\n"
				+ "            NAME,\r\n"
				+ "            CODE,\r\n"
				+ "            DISCOUNT_PRICE,\r\n"
				+ "            USAGE_LIMIT,\r\n"
				+ "            EXPIRY_DATE\r\n"
				+ "        FROM COUPON\r\n"
				+ "        ORDER BY COUPON_NO DESC\r\n"
				+ "    ) C\r\n"
				+ "    WHERE ROWNUM <= 3\r\n"
				+ ")\r\n"
				+ "WHERE rnum <= 3";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<CouponListVo> clVoList=new ArrayList<CouponListVo>();
		while(rs.next()) {
			String couponNo=rs.getString("쿠폰번호");
			String name=rs.getString("쿠폰이름");
			String code=rs.getString("쿠폰코드");
			String discountPrice=rs.getString("할인가격");
			String expiryDate=rs.getString("유효기간");
			String usageLimit=rs.getString("남은수");
			
			CouponListVo clVo=new CouponListVo();
			clVo.setCouponNo(couponNo);
			clVo.setName(name);
			clVo.setCode(code);
			clVo.setDiscountPrice(discountPrice);
			clVo.setExpiryDate(expiryDate);
			clVo.setUsageLimit(usageLimit);
			clVoList.add(clVo);
		}
		
		return clVoList;
	}

	public List<ReportListVo> getReportList(Connection conn) throws Exception {
		String sql="SELECT * FROM (\r\n"
				+ "    SELECT \r\n"
				+ "        R.REPORT_NO 신고번호,\r\n"
				+ "        M.NAME 신고자,\r\n"
				+ "        R.TARGET_MEMBER_NO 신고할회원,\r\n"
				+ "        S.NAME 신고상태,\r\n"
				+ "        R.TITLE 신고제목,\r\n"
				+ "        R.CONTENT 신고내용,\r\n"
				+ "        TO_CHAR(R.CREATED_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') 신고일\r\n"
				+ "    FROM REPORT R \r\n"
				+ "    JOIN MEMBER M ON M.MEMBER_NO = R.MEMBER_NO\r\n"
				+ "    JOIN STATUS S ON S.STATUS_NO = R.STATUS_NO\r\n"
				+ "    ORDER BY R.REPORT_NO DESC\r\n"
				+ ")\r\n"
				+ "WHERE ROWNUM <= 3";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<ReportListVo> rlVoList=new ArrayList<ReportListVo>();
		while(rs.next()) {
			String reportNo=rs.getString("신고번호");
			String memberName=rs.getString("신고자");
			String targetMemberNo=rs.getString("신고할회원");
			String statusName=rs.getString("신고상태");
			String title=rs.getString("신고제목");
			String content=rs.getString("신고내용");
			String createdDate=rs.getString("신고일");
			
			ReportListVo rlVo=new ReportListVo();
			rlVo.setReportNo(reportNo);
			rlVo.setMemberName(memberName);
			rlVo.setTargetMemberNo(targetMemberNo);
			rlVo.setStatusName(statusName);
			rlVo.setTitle(title);
			rlVo.setContent(content);
			rlVo.setCreatedDate(createdDate);
			rlVoList.add(rlVo);
		}
		
		return rlVoList;
	}

	public List<AdminOrderListVo> getOrderList(Connection conn) throws Exception {
		String sql="SELECT \r\n"
				+ "	O.ORDERS_NO 주문번호,\r\n"
				+ "	M.NAME 주문자,\r\n"
				+ "	TO_CHAR(O.CREATED_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') 주문일,\r\n"
				+ "	O.TOTAL_PRICE 총가격\r\n"
				+ "FROM ORDERS O\r\n"
				+ "JOIN MEMBER M ON M.MEMBER_NO =O.ORDERS_NO \r\n";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<AdminOrderListVo> aolVoList=new ArrayList<AdminOrderListVo>();
		while(rs.next()) {
			String orderNo=rs.getString("주문번호");
			String memberName=rs.getString("주문자");
			String createdDate=rs.getString("주문일");
			String totalPrice=rs.getString("총가격");
			
			
			AdminOrderListVo aolVo=new AdminOrderListVo();
			aolVo.setOrderNo(orderNo);
			aolVo.setMemberName(memberName);
			aolVo.setCreatedDate(createdDate);
			aolVo.setTotalPrice(totalPrice);
			
			aolVoList.add(aolVo);
			
		}
		
		return aolVoList;
	}

	public List<MemberVo> getMemberList(Connection conn) throws Exception {
		String sql="SELECT \r\n"
				+ "    M.MEMBER_NO 회원번호,\r\n"
				+ "    M.ID 회원아이디,\r\n"
				+ "    M.NAME 회원이름,\r\n"
				+ "    SUBSTR(M.PHONE_NO, 1, 3) || '-' || SUBSTR(M.PHONE_NO, 4, 4) || '-' || SUBSTR(M.PHONE_NO, 8, 4) 전화번호,\r\n"
				+ "    TO_CHAR(M.CREATED_DATE , 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') 가입일\r\n"
				+ "FROM MEMBER M";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<MemberVo> mVoList=new ArrayList<MemberVo>();
		while(rs.next()) {
			String memberNo=rs.getString("회원번호");
			String memberId=rs.getString("회원아이디");
			String memberName=rs.getString("회원이름");
			String memberPhone=rs.getString("전화번호");
			String createdDate=rs.getString("가입일");
			
			
			MemberVo mVo=new MemberVo();
			mVo.setMemberNo(memberNo);
			mVo.setId(memberId);
			mVo.setName(memberName);
			mVo.setPhoneNo(memberPhone);
			mVo.setCreatedDate(createdDate);
			
			mVoList.add(mVo);
			
		}
		
		return mVoList;
	}

	public List<SellerVo> getSellerList(Connection conn) throws Exception {
		String sql="SELECT\r\n"
				+ "	S.SELLER_NO 판매자번호,\r\n"
				+ "	S.ACC_NAME 판매자아이디,\r\n"
				+ "	S.NAME 판매명,\r\n"
				+ "	S.INFO 소개,\r\n"
				+ "	TO_CHAR(S.CREATED_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24:MI') 가입일\r\n"
				+ "FROM SELLER S";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		List<SellerVo> sVoList=new ArrayList<SellerVo>();
		while(rs.next()) {
			String sellerNo=rs.getString("판매자번호");
			String sellerId=rs.getString("판매자아이디");
			String sellerName=rs.getString("판매명");
			String sellerInfo=rs.getString("소개");
			String createdDate=rs.getString("가입일");
			
			
			SellerVo sVo=new SellerVo();
			sVo.setSellerNo(sellerNo);
			sVo.setAccName(sellerId);
			sVo.setName(sellerName);
			sVo.setInfo(sellerInfo);
			sVo.setCreatedDate(createdDate);
			
			sVoList.add(sVo);
			
		}
		
		return sVoList;
	}

}
