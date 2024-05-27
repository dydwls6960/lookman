package com.lookman.app.favorite.service;

import com.lookman.app.favorite.dao.FavoriteDao;
import com.lookman.app.favorite.vo.FavoriteVo;
import static com.lookman.app.db.SQLSessionTemplate.*;

import org.apache.ibatis.session.SqlSession;

public class FavoriteService {
	private final FavoriteDao fdao;

	public FavoriteService() {
		this.fdao = new FavoriteDao();
	}

	public int toggleFavorite(FavoriteVo fvo) throws Exception {
		if (isFavorite(fvo)) {
			return removeFavorite(fvo);
		} else {
			return addFavorite(fvo);
		}
	}

	private int addFavorite(FavoriteVo fvo) throws Exception {
		SqlSession ss = getSqlSession();
		int result = fdao.addFavorite(ss, fvo);
		
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		
		return result;
	}

	private int removeFavorite(FavoriteVo fvo) throws Exception {
		SqlSession ss = getSqlSession();
		
		int result = fdao.removeFavorite(ss, fvo);
		
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		
		ss.close();
		return result;
	}

	private boolean isFavorite(FavoriteVo fvo) throws Exception {
		SqlSession ss = getSqlSession();
		
		int count = fdao.isFavorite(ss, fvo);
		ss.close();
		
		return count == 1;
	}

}
