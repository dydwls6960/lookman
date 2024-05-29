package com.lookman.app.payment.service;

import static com.lookman.app.db.SQLSessionTemplate.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.cart.dao.CartDao;
import com.lookman.app.inventory.dao.InventoryDao;
import com.lookman.app.order.dao.OrderDao;
import com.lookman.app.order.detail.dao.OrderDetailDao;
import com.lookman.app.payment.dao.PaymentDao;
import com.lookman.app.payment.dto.PaymentResponseDto;

public class PaymentService {

	private final PaymentDao pdao;
	private final OrderDao odao;
	private final OrderDetailDao oddao;
	private final CartDao cdao;
	private final InventoryDao idao;

	public PaymentService() {
		this.pdao = new PaymentDao();
		this.odao = new OrderDao();
		this.oddao = new OrderDetailDao();
		this.cdao = new CartDao();
		this.idao = new InventoryDao();
	}

	public int savePaymentInfo(PaymentResponseDto payResDto) throws Exception {
		SqlSession ss = getSqlSession();
		int orderResult = 0;
		int orderDetailResult = 0;
		int delResult = 0;
		int decreResult = 0;
		int payResult = 0;

		try {
			// insert into orders table
			orderResult = odao.insertIntoOrders(ss, payResDto);

			if (orderResult == 1) {
				ss.commit();

				// get current ordersNo
				String ordersNo = odao.getGeneratedOrdersNo(ss);
				payResDto.setOrdersNo(ordersNo);

				// insert into order_detail table
				orderDetailResult = oddao.insertIntoOrderDetail(ss, payResDto);
				if (orderDetailResult <= 0) {
					throw new Exception("주문상세 삽입 중 에러");
				}
				ss.commit();

				// delete from cart where memberNo = ? and inventoryNo in (?, ?)
				delResult = cdao.deleteCartByMemberNoAndInventory(ss, payResDto);
				if (delResult <= 0) {
					throw new Exception("장바구니 아이템 삭제 중 에러");
				}
				ss.commit();

				// decrement inventory
				decreResult = idao.decrementInventories(ss, payResDto);
				if (decreResult != -1) {
					throw new Exception("재고 업데이트 중 에러");
				}
				ss.commit();

				// insert into payment table
				payResult = pdao.insertIntoPayment(ss, payResDto);
				if (payResult != 1) {
					throw new Exception("결제 테이블 삽입 중 에러");
				}
				ss.commit();

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

		// remove cart items for the paid products

		return orderResult * orderDetailResult * delResult * decreResult * payResult;
	}

}
