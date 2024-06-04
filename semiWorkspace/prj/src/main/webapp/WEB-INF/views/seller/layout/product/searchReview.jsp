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
							        	<option value="all">전체</option>
								        <option value="R.RATING">별점</option>
								        <option value="P.PRODUCT_NO">상품번호</option>
								        <option value="M.NAME">작성자</option>
								    </select>
					   				 <input type="text" name="searchListText">
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