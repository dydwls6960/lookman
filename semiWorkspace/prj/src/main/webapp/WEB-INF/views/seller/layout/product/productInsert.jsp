<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="seller-div">
			<div>
 				<span><span id="b-g">&#10073;</span> 답변쓰기</span>
			</div>
				<div id="list-content">
					<form action="/app/seller/product/insert" method="post" enctype="multipart/form-data">
						<table id="user-search" class="userList">
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
							<tr>
								<th>
									상품명
								</th>
								<td style="text-align: left">
					   				 <input type="text" name="title">
								</td>
							</tr>
							<tr>
								<th>
									상품내용
								</th>
								<td style="text-align: left">
					   				 <input type="text" name="content">
								</td>
							</tr>
							<tr>
								<th>
									상품가격
								</th>
								<td style="text-align: left">
					   				 <input type="text" name="price">
								</td>
							</tr>
							<tr>
								<th>
									개수
								</th>
								<td style="text-align: left">
					   				 <input type="text" name="cnt">
								</td>
							</tr>
							
							<tr>
								<th>
									썸네일
								</th>
								<td>
									<input type="file" name="first">
								</td>
							</tr>
							
			
						</table>
					<div id="search-div">
						<input type="submit" value="추가하기">
						<input type="reset" value="초기화">
					</div>
				</form>
			</div>
		</div>