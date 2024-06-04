package com.lookman.app.seller.product.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.lookman.app.category.vo.CategoryVo;
import com.lookman.app.product.vo.ProductColorVo;
import com.lookman.app.product.vo.ProductSizeVo;
import com.lookman.app.seller.order.vo.SellerOrderListVo;
import com.lookman.app.seller.product.vo.SellerProductInquiryVo;
import com.lookman.app.seller.product.vo.SellerProductListVo;
import com.lookman.app.seller.product.vo.SellerProductSearchVo;
import com.lookman.app.seller.service.SellerService;
import com.lookman.app.seller.vo.SellerInquiryVo;
import com.lookman.app.seller.vo.SellerProductInsertVo;
import com.lookman.app.seller.vo.SellerStateVo;
import com.lookman.app.seller.vo.SellerVo;

@WebServlet("/seller/product/insert")
@MultipartConfig(
	    maxFileSize = 1024*1024*50, // 최대 파일 크기 50MB
	    maxRequestSize = 1024*1024*500, // 요청 전체 크기 500MB
	    fileSizeThreshold = 1024*1024*50 // 50MB를 넘어가면 디스크에 기록
	)
public class SellerProductInsertController extends HttpServlet {
	private SellerService ss;
	public SellerProductInsertController() {
		this.ss=new SellerService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			SellerVo loginSellerVo=(SellerVo)req.getSession().getAttribute("loginSellerVo");
			
			String categoryNo=req.getParameter("s-cate");
			String sizeNo=req.getParameter("s-size");
			String colorNo=req.getParameter("s-color");
			
			SellerProductSearchVo spsVo=new SellerProductSearchVo();
			spsVo.setCategoryNo(categoryNo);
			spsVo.setSizeNo(sizeNo);
			spsVo.setColorNo(colorNo);
			
			List<CategoryVo> cVoList=ss.getCategoryList();
			List<ProductColorVo> pcVoList=ss.getColorList();
			List<ProductSizeVo> psVoList=ss.getSizeList();
			
			req.setAttribute("cVoList",cVoList );
			req.setAttribute("pcVoList",pcVoList );
			req.setAttribute("psVoList",psVoList );
						
			req.getRequestDispatcher("/WEB-INF/views/seller/product/productInsert.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", "[ERROR-S0002]판매자 상품상세검색 중 에러 발생...");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 폼에서 전송된 텍스트 데이터 받기
	        String category = req.getParameter("s-cate");
	        String size = req.getParameter("s-size");
	        String color = req.getParameter("s-color");
	        String title = req.getParameter("title");
	        String content = req.getParameter("content");
	        String price = req.getParameter("price");
	        String cnt = req.getParameter("cnt");

	        // 썸네일 파일 받기
	        Part thumbnailPart = req.getPart("first");

	        // 썸네일 파일명
	        String thumbnailFileName = thumbnailPart.getSubmittedFileName();
	        
	        
	        
	        

	        // 파일 저장 경로
	        String uploadPath = getServletContext().getRealPath("/resources/img/product/") + thumbnailFileName;

	        // 파일 저장
	        try (InputStream input = thumbnailPart.getInputStream();
	             FileOutputStream output = new FileOutputStream(uploadPath)) {
	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = input.read(buffer)) != -1) {
	                output.write(buffer, 0, bytesRead);
	            }
	        }
	        HttpSession session = req.getSession();
			
			SellerVo loginSellerVo=(SellerVo)req.getSession().getAttribute("loginSellerVo");

	        SellerProductInsertVo spInsertVo=new SellerProductInsertVo();
	        spInsertVo.setCategory(category);
	        spInsertVo.setSize(size);
	        spInsertVo.setColor(color);
	        spInsertVo.setTitle(title);
	        spInsertVo.setContent(content);
	        spInsertVo.setPrice(price);
	        spInsertVo.setCnt(cnt);
	        spInsertVo.setThumbnailFileName(thumbnailFileName);
	        
	        ss.getProductInsert(loginSellerVo,spInsertVo);

	        String sellerNo=loginSellerVo.getSellerNo();
			SellerStateVo spsVo= ss.getSellerStatus(sellerNo); 										//수정완료
			SellerInquiryVo siVo=ss.getSellerInquiryVo(sellerNo);									//수정완료
			List<SellerProductListVo> splVoList=ss.getProductListRowNum3(loginSellerVo);			//수정완료
			List<SellerProductInquiryVo> spiVoList=ss.getProductInquiryListRowNum3(loginSellerVo);	//수정완료
			List<SellerOrderListVo> solVoList=ss.getSimplerOrderListRowNum3(loginSellerVo);			//수정완료
			
			req.setAttribute("spsVo", spsVo);
			req.setAttribute("siVo", siVo);
			req.setAttribute("splVoList", splVoList);
			req.setAttribute("spiVoList", spiVoList);
			req.setAttribute("solVoList", solVoList);
	        
	        req.getRequestDispatcher("/WEB-INF/views/seller/home.jsp").forward(req, resp);
	    } catch (Exception e) {
	        e.printStackTrace();
	        req.setAttribute("errMsg", "[ERROR-S0002] 판매자 상품상세검 중 에러 발생...");
	        req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
	    }
	}
}
