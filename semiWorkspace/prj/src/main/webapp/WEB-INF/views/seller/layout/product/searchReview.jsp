<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="seller-div">
			<div>
 				<span><span id="b-g">&#10073;</span> 상품리스트</span>
			</div>
				<div id="list-content">
					<form action="/app/seller/home/product/review/select" method="post">
						<table id="user-search" class="userList">
							<tr>
								<th>
									검색어
								</th>
								<td class="search-field" style="text-align: left">
							        <select name="s-len">
								        <option value="name">상품명</option>
								        <option value="nicl">상품번호</option>
								        <option value="title">작성자아이디</option>
								        <option value="content">작성자닉네임</option>
								        <option value="content">별점</option>
								    </select>
					   				 <input type="text">
				    			</td>
								
							</tr>
			
						</table>
					<div id="search-div">
						<input type="submit" value="검색">
						<input type="reset" value="초기화">
					</div>
				</form>
			</div>
		</div>