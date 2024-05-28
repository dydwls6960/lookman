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
				        <option value="P.NAME">상품명</option>
				        <option value="P.PRODUCT_NO">상품번호</option>
				    </select>
	   				 <input type="text" name="searchListText">
				</td>
			</tr>

			<tr>
				<th>
					카테고리
				</th>
				<td class="search-field" style="text-align: left">
			        <select name="s-cate">
			            <option value="all">전체</option>
			        	<c:forEach items="${cVoList}" var="cVo">
				            <option value="${cVo.getCategoryNo()}">${cVo.getName()}</option>    	
				  		</c:forEach>
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
			            <c:forEach items="${psVoList}" var="psVo">
				            <option value="${psVo.getSizeNo()}">${psVo.getName()}</option>    	
				  		</c:forEach>
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
			            <c:forEach items="${pcVoList}" var="pcVo">
				            <option value="${pcVo.getColorNo()}">${pcVo.getName()}</option>    	
				  		</c:forEach>
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