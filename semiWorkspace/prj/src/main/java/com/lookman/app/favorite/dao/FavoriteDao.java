package com.lookman.app.favorite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.favorite.dto.FavoriteHomeDto;
import com.lookman.app.favorite.vo.FavoriteVo;
import com.lookman.app.member.vo.MemberVo;

public class FavoriteDao {

	public int isFavorite(SqlSession ss, FavoriteVo fvo) {
		return ss.selectOne("FavoriteMapper.isFavorite", fvo);
	}

	public int removeFavorite(SqlSession ss, FavoriteVo fvo) {
		return ss.delete("FavoriteMapper.removeFavorite", fvo);
	}

	public int addFavorite(SqlSession ss, FavoriteVo fvo) {
		return ss.insert("FavoriteMapper.addFavorite", fvo);
	}

	public List<FavoriteHomeDto> getFavoriteItems(SqlSession ss, MemberVo loginMemberVo) {
		return ss.selectList("FavoriteMapper.getFavoriteItems", loginMemberVo);
	}

}
