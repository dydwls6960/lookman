<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="seller-div">
	<div>
 		<span><span id="b-g">&#10073;</span> 상품리스트</span>
	</div>
	<div id="list-content">
	<form action="/app/seller/home/product/list/select" method="post">
		<table id="user-search" class="userList">
			<tr>
				<th>
					정렬
				</th>
				<td style="text-align: left">
					<select name="s-len">
				        <option value="O.ORDERS_NO">최근순</option>
				        <option value="O.TOTAL_PRICE">가격순</option>
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