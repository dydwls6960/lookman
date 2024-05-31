package com.lookman.app.order.inquiry.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.inquiry.dto.OrderMemberInquiryDto;
import com.lookman.app.member.vo.MemberVo;
import com.lookman.app.order.inquiry.vo.OrderInquiryVo;

public class OrderInquiryDao {

	public int insertOrderInquiry(SqlSession ss, OrderInquiryVo oivo) {
		return ss.insert("OrderInquiryMapper.insertOrderInquiry", oivo);
	}

	public List<OrderMemberInquiryDto> selectOrderInquiriesByMemberNo(SqlSession ss, MemberVo loginMemberVo) {
		return ss.selectList("OrderInquiryMapper.selectOrderInquiriesByMemberNo", loginMemberVo);
	}

	public int deleteInquiry(SqlSession ss, OrderInquiryVo oivo) {
		return ss.update("OrderInquiryMapper.deleteInquiry", oivo);
	}

	public int editInquiry(SqlSession ss, OrderInquiryVo oivo) {
		return ss.update("OrderInquiryMapper.editInquiry", oivo);
	}

}
