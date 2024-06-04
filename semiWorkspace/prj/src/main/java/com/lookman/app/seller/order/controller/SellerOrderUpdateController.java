package com.lookman.app.seller.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lookman.app.seller.order.vo.SellerOrderListVo;
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/order/update")
public class SellerOrderUpdateController extends HttpServlet{
	private SellerService ss;
	public SellerOrderUpdateController() {
		this.ss=new SellerService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
	        	HttpSession session = req.getSession();
				
				SellerVo loginSellerVo=(SellerVo)req.getSession().getAttribute("loginSellerVo");
	        	if(loginSellerVo!=null) {
	        		String orderDetailNo = req.getParameter("orderDetailNo");
	        		String status = req.getParameter("status");
	        		
	        		System.out.println("Order Detail No: " + orderDetailNo);
	        		System.out.println("Status: " + status);      
	        		
	        		int result=0;
	        		if(status.equals("prepare")) {
	        			result = ss.getOrderUpdatePrepare(orderDetailNo);
	        		}else if(status.equals("start")){
	        			result = ss.getOrderUpdateStart(orderDetailNo);
	        		}else if (status.equals("complete")) {
	                    result = ss.getOrderUpdateComplete(orderDetailNo);
	                }
	        		List<SellerOrderListVo> solVoList=ss.getSimplerOrderList(loginSellerVo);	
					req.setAttribute("solVoList", solVoList);
					req.getRequestDispatcher("/WEB-INF/views/seller/order/list.jsp").forward(req, resp);
	        		
	        	}else {
	        		session.setAttribute("alertMsg", "로그인 하고 와주세요");
					req.getRequestDispatcher("/WEB-INF/views/seller/login.jsp").forward(req, resp);
	        	}
				
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("errMsg", "[ERROR-S0024] 배송변경 중 에러 발생...");
				req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       

        
	}
}
