package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/addproductservlet")
public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection connection;
    @Override
    public void init() throws ServletException {
    	try {
    		System.out.println("Inside Add Product init() method. DB Connection Created");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Caravind@9750");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		int productid=Integer.parseInt(req.getParameter("productid"));
		String productname=req.getParameter("productname");
		int productcost=Integer.parseInt(req.getParameter("productcost"));
		
		try(Statement statement=connection.createStatement();){
			String query="insert into product values("+productid+",'"+productname+"',"+productcost+")";
			System.out.println("Query being Executed: "+query);
			int rowsInserted=statement.executeUpdate(query);
			System.out.println("Number of rows inserted: "+rowsInserted);
			PrintWriter pw=res.getWriter();
			pw.write("<h2>Product successfully Added</h2>");
			pw.println("<p><a href=\"homepage.html\">Return to Home-Page</a></p>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		try {
			System.out.println("Inside Add Product destroy() method. DB Connection destroyed");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.destroy();
	}

}