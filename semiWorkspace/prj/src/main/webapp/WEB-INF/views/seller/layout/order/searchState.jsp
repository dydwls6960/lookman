<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="seller-div">
	<div>
 		<span><span id="b-g">&#10073;</span> 상품리스트</span>
	</div>
	<div id="list-content">
	<form action="/app/seller/home/order/state/select" method="post">
		<table id="user-search" class="userList">
			<tr>
				<th>
					검색어
				</th>
				<td style="text-align: left">
					<select name="s-len">
				        <option value="P.NAME">상품명</option>
				        <option value="P.PRODUCT_NO">상품번호</option>
				    </select>
	   				<input type="text" name="searchListText">
				</td>
			</tr>

			<tr>
				<th>
					처리상태
				</th>
				<td class="search-field" style="text-align: left">
			        <select name="s-status">
			            <option value="all">전체</option>
			            <option value="1">입금/결제</option>
			            <option value="2">결제완료</option>
			            <option value="3">배송준비중</option>
			            <option value="4">배송중</option>
			            <option value="5">배송완료</option>
			        </select>
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