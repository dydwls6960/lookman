<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="seller-div">
			<div>
 				<span><span id="b-g">&#10073;</span> 답변쓰기</span>
			</div>
				<div id="list-content">
					<form action="/app/seller/home/product/inquiry/update" method="post">
						<table id="user-search" class="userList">
							<tr>
								<th>
									답변내용
								</th>
								<td style="text-align: left">
					   				 <input type="text" name="askText" value="${spiVo.getRespContent()}">
								</td>
							</tr>
							
			
						</table>
					<div id="search-div">
						<input type="submit" value="답변하기">
						<input type="reset" value="초기화">
					</div>
				</form>
			</div>
		</div>