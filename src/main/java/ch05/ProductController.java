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
		String path="";
		if(action == null) {
			action = "list";
		}
		if(action.equals("list")) {
			path = "/ch05/productList.jsp";
			// 데이터는 service.findAll() 를 넘긴다.
			req.setAttribute("plist", service.findAll());
			// productList.jsp 화면 이동
			req.getRequestDispatcher(path).forward(req, resp);
		} else if(action.equals("info")) {
			String pid = req.getParameter("pid");
			// pid 을 매개변수로 하는 service.find(pid) 를 호출한 후 
			req.setAttribute("p", service.find(pid));
			path = "/ch05/productInfo.jsp";
			// productInfo.jsp로 화면 이동
			req.getRequestDispatcher(path).forward(req, resp);
		}
	}
}
