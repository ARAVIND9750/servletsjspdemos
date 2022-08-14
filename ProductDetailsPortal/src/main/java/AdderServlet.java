import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.Product;

@WebServlet("/AdderServlet")
public class AdderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		Product product=new Product(Long.parseLong(request.getParameter("id")),request.getParameter("pName"),Float.parseFloat(request.getParameter("pPrice")));
		PrintWriter out=response.getWriter();
		session.setAttribute("id", product.getID());
		session.setAttribute("pname", product.getpName());
		session.setAttribute("pprice", product.getpPrice());
		out.println("<a href='display.jsp'>Display Details</a>");
	}


}