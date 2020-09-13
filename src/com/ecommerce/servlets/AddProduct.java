package com.ecommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.helper.hibernateUtil;
import com.ecommerce.model.EProduct;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/add-product")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("add-product.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String pname=request.getParameter("productName");
		String price=request.getParameter("price");
		
		//open a connection
		try {
			SessionFactory factory=hibernateUtil.buildSessionFactory();
			Session session=factory.openSession();
			Transaction trans=session.beginTransaction();
			EProduct p=new EProduct();
			p.setName(pname);
			p.setPrice(Double.valueOf(price));
			session.save(p);
			trans.commit();
			session.close();
			out.close();
		}catch (Exception e) {
		e.printStackTrace();
		}	
	}

}
