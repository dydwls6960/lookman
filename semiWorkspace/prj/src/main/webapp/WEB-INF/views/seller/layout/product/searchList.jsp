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
					검색어
				</th>
				<td style="text-align: left">
					<select name="s-len">
				        <option value="name">상품명</option>
				        <option value="no">상품번호</option>
				    </select>
	   				 <input type="text">
				</td>
			</tr>

			<tr>
				<th>
					카테고리
				</th>
				<td class="search-field" style="text-align: left">
			        <select name="s-cate">
			            <option value="all">전체</option>
			            <option value="1">카테고리1</option>
			            <option value="2">카테고리2</option>
			            <option value="3">카테고리3</option>
			            <option value="4">카테고리4</option>
			        </select>
    			</td>
			</tr>
			
			<tr>
				<th>
					사이즈
				</th>
				<td class="membership-checkboxes" style="text-align: left">
			        <select name="s-size">
			            <option value="all">전체</option>
			            <option value="1">사이즈1</option>
			            <option value="2">사이즈2</option>
			            <option value="3">사이즈3</option>
			            <option value="4">사이즈4</option>
			        </select>
    			</td>
			</tr>
			
			<tr>
				<th>
					색상
				</th>
				<td class="membership-checkboxes" style="text-align: left">
			        <select name="s-color">
			            <option value="all">전체</option>
			            <option value="1">색상1</option>
			            <option value="2">색상2</option>
			            <option value="3">색상3</option>
			            <option value="4">색상4</option>
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