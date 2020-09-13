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
 * Servlet implementation class ProductDetails
 */
@WebServlet("/product-details")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		//open a connection
		try {
			SessionFactory factory=hibernateUtil.buildSessionFactory();
			Session session=factory.openSession();
			Transaction trans = session.beginTransaction();

			List<EProduct> list=session.createQuery("from EProduct e").list();
			
			//Print products
			out.print("<h5>Product details</h5>");
			
			for (EProduct eProduct : list) {
				out.println("id ->"+eProduct.getP_id()+
						"\nname ->"+eProduct.getName()+
						"\nprice ->"+eProduct.getPrice());
			}
			trans.commit();
			out.close();
		}catch (Exception e) {
		e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
