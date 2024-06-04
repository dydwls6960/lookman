<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="seller-div">
			<div>
 				<span><span id="b-g">&#10073;</span> 주문정렬</span>
			</div>
				<div id="list-content">
					<form action="/app/admin/order" method="post">
						<table id="user-search" class="userList">
							<tr>
								<th>
									정렬
								</th>
								<td style="text-align: left">
									<select name="s-len">
								        <option value="O.ORDERS_NO">최신순</option>
								        <option value="O.TOTAL_PRICE">총가격순</option>
								    </select>
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