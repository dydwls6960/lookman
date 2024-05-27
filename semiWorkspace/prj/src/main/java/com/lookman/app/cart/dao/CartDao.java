package com.lookman.app.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.cart.dto.CartHomeDto;
import com.lookman.app.cart.vo.CartItemVo;
import com.lookman.app.member.vo.MemberVo;

public class CartDao {

	public int addToCart(SqlSession ss, List<CartItemVo> items) {
		return ss.insert("CartMapper.addToCart", items);
	}

	public List<CartHomeDto> getCartItems(SqlSession ss, MemberVo loginMemberVo) {
		return ss.selectList("CartMapper.getCartItems", loginMemberVo);
	}

}
