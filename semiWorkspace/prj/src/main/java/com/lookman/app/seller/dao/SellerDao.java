package com.lookman.app.seller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lookman.app.db.JDBCTemplate;
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

}
