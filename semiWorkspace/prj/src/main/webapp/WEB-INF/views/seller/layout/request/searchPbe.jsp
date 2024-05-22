<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="seller-div">
	<div>
 		<span><span id="b-g">&#10073;</span> 상품리스트</span>
	</div>
	<div id="list-content">
	<form action="/app/seller/home/order/pbe/select" method="post">
		<table id="user-search" class="userList">
			<tr>
				<th>
					검색어
				</th>
				<td style="text-align: left">
					<select name="s-len">
				        <option>주문현황</option>
				        <option value="be">입금전</option>
				        <option value="fin">결제완료</option>
				    </select>
				</td>
			</tr>

			<tr>
				<th>
					배송현황
				</th>
				<td style="text-align: left">
					<select name="s-len">
				        <option>주문현황</option>
				        <option value="be">배송전</option>
				        <option value="fin">배송완료</option>
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