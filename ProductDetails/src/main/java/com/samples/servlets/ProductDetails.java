package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productdetailsservlet")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	@Override
	public void init() throws ServletException {
		try {
			System.out.println("Inside Product Details init() method. DB Connection Created");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Caravind@9750");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		int productid = Integer.parseInt(req.getParameter("productid"));

		try (Statement statement = connection.createStatement();) {
			String query = "(select * from product where productid=" + productid + ")";

			ResultSet resultset = statement.executeQuery(query);
			PrintWriter out = res.getWriter();
			if (!resultset.isBeforeFirst()) {
				out.println("<h2>Invalid ProductID</h2>");
			} else {
				
				out.println("<table>");
				out.println("<tr>");
				out.println("<th>ProductID</th>");
				out.println("<th>ProductName</th>");
				out.println("<th>ProductCost</th>");
				out.println("</tr>");
				while (resultset.next()) {
					out.println("<tr>");
					out.println("<th>" + resultset.getString(1) + "</th>");
					out.println("<th>" + resultset.getString(2) + "</th>");
					out.println("<th>" + resultset.getString(3) + "</th>");
					out.println("</tr>");
				}
				out.println("</table>");
			}
			out.println("<p><a href=\"homepage.html\">Return to Home-Page</a></p>");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		try {
			System.out.println("Inside Product Details destroy() method.DB connection destroyed");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}