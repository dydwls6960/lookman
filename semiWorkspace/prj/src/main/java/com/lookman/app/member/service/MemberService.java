package com.lookman.app.member.service;

import static com.lookman.app.db.JDBCTemplate.close;
import static com.lookman.app.db.JDBCTemplate.commit;
import static com.lookman.app.db.JDBCTemplate.getConnection;
import static com.lookman.app.db.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.regex.Pattern;

import com.lookman.app.member.dao.MemberDao;
import com.lookman.app.member.vo.AddressVo;
import com.lookman.app.member.vo.MemberVo;

public class MemberService {

	private MemberDao dao;

	public MemberService() {
		this.dao = new MemberDao();
	}

	public int join(MemberVo mvo, AddressVo avo) throws Exception {

		// logic
		// 비밀번호 일치여부
		if (!mvo.getPwd().equals(mvo.getPwd2())) {
			throw new Exception("비밀번호가 일치하지 않습니다.");
		}

		// 비밀번호 강도
		String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		if (!Pattern.matches(passwordPattern, mvo.getPwd())) {
			throw new Exception("비밀번호는 최소 8자 이상이어야 하며, 문자, 숫자, 특수문자를 포함해야 합니다.");
		}

		// 전화번호 형식
		String phonePattern = "^01[0-9]{8,9}$";
		if (!Pattern.matches(phonePattern, mvo.getPhoneNo())) {
			throw new Exception("유효한 전화번호 형식이 아닙니다.");
		}

		// 주소 비어있는지 체크
		if (avo.getAddress() == null || avo.getAddress().isEmpty()) {
			throw new Exception("주소가 비어있습니다.");
		}

		// dao
		Connection conn = getConnection();

		// join
		int resultMember = dao.join(conn, mvo);

		if (resultMember != 1) {
			throw new Exception("회원가입 도중 에러...");
		}

		// 현재 멤버번호 가져오기
//		String currentMemberNo = dao.getMemberNo(conn, mvo);
//		if (currentMemberNo.equals("")) {
//			throw new Exception("회원번호 가져오는 중 에러...");
//		}
//
//		avo.setMemberNo(currentMemberNo);

		// 주소 입력
		int resultAddress = dao.insertAddress(conn, avo);

		if (resultAddress != 1) {
			throw new Exception("주소 insert 중 에러...");
		}

		if (resultMember * resultAddress == 1) {
			commit(conn);
		} else {
			rollback(conn);
			throw new Exception("회원가입 & 주소입력 실패");
		}

		close(conn);

		return resultMember * resultAddress;
	}

	public boolean checkIdDup(String id) throws Exception {
		Connection conn = getConnection();
		int result = dao.checkIdDup(conn, id);

		close(conn);

		return result == 0;
	}

	public MemberVo login(MemberVo mvo) throws Exception {

		Connection conn = getConnection();
		MemberVo loginMemberVo = dao.login(conn, mvo);

		close(conn);

		return loginMemberVo;
	}

	public int edit(MemberVo mvo) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();

			// logic
			// 전화번호 형식
			String phonePattern = "^01[0-9]{8,9}$";
			if (!Pattern.matches(phonePattern, mvo.getPhoneNo())) {
				throw new Exception("유효한 전화번호 형식이 아닙니다.");
			}

			// 현재 비밀번호 체크
			boolean isCurrentPwdValid = dao.validateCurrentPwd(conn, mvo);
			if (!isCurrentPwdValid) {
				throw new Exception("현재 비밀번호가 일치하지 않습니다.");
			}

			// 새 비밀번호 설정할건지 체크
			int pwdResult = 1;
			if (mvo.getNewPwd() != null && !mvo.getNewPwd().isEmpty() && mvo.getNewPwd2() != null
					&& !mvo.getNewPwd2().isEmpty()) {
				if (!mvo.getNewPwd().equals(mvo.getNewPwd2())) {
					throw new Exception("새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
				}

				// 비밀번호 강도
				String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
				if (!Pattern.matches(passwordPattern, mvo.getNewPwd())) {
					throw new Exception("비밀번호는 최소 8자 이상이어야 하며, 문자, 숫자, 특수문자를 포함해야 합니다.");
				}

				// 새 비밀번호 업데이트
				pwdResult = dao.updatePassword(conn, mvo);
				if (pwdResult != 1) {
					throw new Exception("비밀번호 수정 중 예외 발생.");
				}
			}

			// 다른 정보 수정
			int infoResult = dao.updateMemberInfo(conn, mvo);
			if (infoResult != 1) {
				throw new Exception("회원정보 수정 중 예외 발생.");
			}

			if (pwdResult * infoResult == 1) {
				commit(conn);
			} else {
				rollback(conn);
			}

			return pwdResult * infoResult;

		} catch (Exception e) {
			rollback(conn);
			return 0;
		} finally {
			close(conn);
		}
	}
}
