package ch05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ProductService service ;
	
	public ProductController() {
		service = new ProductService();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		System.out.println(action);
	}
}
