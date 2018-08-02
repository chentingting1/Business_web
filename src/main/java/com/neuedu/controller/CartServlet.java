package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.service.CartService;
import com.neuedu.service.impl.CartServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/view/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    CartService cs = new CartServiceImpl();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String operation = request.getParameter("operation");

		if(operation.equals("1")) {

			addCart(request,response);

		}else if(operation.equals("2")) {

			findCart(request,response);

		}else if(operation.equals("3")) {

			deleteCart(request,response);

		}else if(operation.equals("4")) {

			updateCart(request,response);

		}else if(operation.equals("5")) {

			getCartById(request,response);

		}
	
	}

     //修改
	public boolean updateCart(Cart cart) {

		return cs.updateCart(cart);
	}

	private void updateCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		int id =0;
		try {
			
			num = Integer.parseInt(request.getParameter("num"));
			id = Integer.parseInt(request.getParameter("id"));
			Cart cart = getCartById(id);
			cart.setProductnum(num);
			boolean result = updateCart(cart);

			if(result) {
				System.out.println("成功");
				findCart(request, response);
			}else {
				System.out.println("失败");
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}


    //通过id寻找购物车
	public Cart getCartById(int id) {
		
		return cs.getCartById(id);

	}

	private void getCartById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			Cart cart = getCartById(id);
			if(cart!=null) {
				request.setAttribute("cart", cart);
				request.getRequestDispatcher("findByid.jsp").forward(request, response);
			}else {
				System.out.println("Fail");
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		
	}

	//删除购物车
	public boolean deleteCart(int id) {

		return cs.deleteCart(id);
	}

	private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		boolean result = false;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			result = deleteCart(id);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result){
			System.out.println("success");
			findCart(request, response);
		}else {
			System.out.println("fail");
		}

		
	}

    //添加购物车
	public boolean addCart(Cart cart) {

		return cs.addCart(cart);
	}

	private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		int num = 0;
		boolean result = false;
		Cart cart = new Cart();
		ProductServlet p = new ProductServlet();
		try {
			id = Integer.parseInt(request.getParameter("id"));
			num = Integer.parseInt(request.getParameter("num"));
			Product product = p.findProductById(id);
			cart.setProductnum(num);
			cart.setProduct(product);
			result = addCart(cart);
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("成功");
			ProductServlet pservlet = new ProductServlet();
			findCart(request, response);
		}else{
			System.out.println("失败");
		}
		
	}


	/*
	 * 查询购物车
	 * */
	public void findCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*String methed = request.getParameter("methed");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");*/

		PrintWriter pw = response.getWriter();

		CartService cs = new CartServiceImpl();
		List<Cart> carts = cs.findCart();
		String callback=request.getParameter("callback");
		Gson gson = new Gson();
		String json = gson.toJson(carts);
		pw.write(callback+"("+json+")");
		/*
		System.out.println(result);
		pw.println(result);
		request.setAttribute("carts", carts);
		request.getRequestDispatcher("findcart.jsp").forward(request, response);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
