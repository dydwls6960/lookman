<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="seller-div">
			<div>
 				<span><span id="b-g">&#10073;</span> 상품리스트</span>
			</div>
				<div id="list-content">
					<form action="/app/seller/home/product/inquiry/select" method="post">
						<table id="user-search" class="userList">
							<tr>
								<th>
									검색어
								</th>
								<td class="search-field" style="text-align: left">
							        <select name="s-cate">
							            <option value="all">전체</option>
							            <option value="1">카테고리1</option>
							            <option value="2">카테고리2</option>
							            <option value="3">카테고리3</option>
							            <option value="4">카테고리4</option>
							        </select>
							        
							        <select name="s-len">
								        <option value="name">작성자 아이디</option>
								        <option value="nicl">작성자 닉네임</option>
								        <option value="title">문의제목</option>
								        <option value="content">문의내용</option>
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