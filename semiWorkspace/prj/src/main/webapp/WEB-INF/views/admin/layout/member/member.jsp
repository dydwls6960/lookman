<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="seller-div">
			<div>
 				<span><span id="b-g">&#10073;</span> 회원검색</span>
			</div>
				<div id="list-content">
					<form action="/app/admin/member" method="post">
						<table id="user-search" class="userList">
							<tr>
								<th>
									검색어
								</th>
								<td style="text-align: left">
									<select name="s-len">
								        <option value="M.NAME">회원이름</option>
								        <option value="M.MEMBER_NO">회원번호</option>
								    </select>
					   				 <input type="text" name="searchListText">
								</td>
							</tr>
						</table>
					<div id="search-div">
						<input type="submit" value="정렬">
						<input type="reset" value="초기화">
					</div>
				</form>
			</div>
		</div>