package com.lookman.app.payment.service;

import static com.lookman.app.db.SQLSessionTemplate.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.cart.dao.CartDao;
import com.lookman.app.order.dao.OrderDao;
import com.lookman.app.order.detail.dao.OrderDetailDao;
import com.lookman.app.payment.dao.PaymentDao;
import com.lookman.app.payment.dto.PaymentResponseDto;

public class PaymentService {

	private final PaymentDao pdao;
	private final OrderDao odao;
	private final OrderDetailDao oddao;
	private final CartDao cdao;

	public PaymentService() {
		this.pdao = new PaymentDao();
		this.odao = new OrderDao();
		this.oddao = new OrderDetailDao();
		this.cdao = new CartDao();
	}

	public int savePaymentInfo(PaymentResponseDto payResDto) throws Exception {
		SqlSession ss = getSqlSession();
		int orderResult = 0;
		int orderDetailResult = 0;

		try {
			// insert into orders table
			orderResult = odao.insertIntoOrders(ss, payResDto);
			System.out.println("result: " + orderResult);

			if (orderResult == 1) {
				ss.commit();

				// get current ordersNo
				String ordersNo = odao.getGeneratedOrdersNo(ss);
				payResDto.setOrdersNo(ordersNo);

				// insert into order_detail table
				orderDetailResult = oddao.insertIntoOrderDetail(ss, payResDto);
				if (orderDetailResult <= 0) {
					throw new Exception("주문상세 삽입 중 에러");
				} else {
					ss.commit();
				}

				// delete from cart where memberNo = ?
				int delResult = cdao.deleteCartByMemberNo(ss, payResDto);
				if (delResult > 0) {
					ss.commit();
				}
				System.out.println("delResult: " + delResult);

				// decrement inventory

			} else {
				ss.rollback();
			}

		} catch (Exception e) {
			ss.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			ss.close();
		}

		// insert into payment table

		// remove cart items for the paid products

		return orderResult;
	}

}
