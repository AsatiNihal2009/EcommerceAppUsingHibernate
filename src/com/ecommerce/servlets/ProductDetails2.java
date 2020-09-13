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

import com.ecommerce.helper.hibernateUtil2;
import com.ecommerce.model.EProduct;
import com.ecommerce.model.Item;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/item-details")
public class ProductDetails2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails2() {
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
			SessionFactory factory=hibernateUtil2.buildSessionFactory();
			Session session=factory.openSession();
			Transaction trans = session.beginTransaction();

			List<Item> list=session.createQuery("from Item e").list();
			
			//Print products
			out.print("<h5>Product details</h5>");
			
			for (Item eProduct : list) {
				out.println("id ->"+eProduct.getID()+
						"\nname ->"+eProduct.getItemName()+
						"\nprice ->"+eProduct.getItemTotal());
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
