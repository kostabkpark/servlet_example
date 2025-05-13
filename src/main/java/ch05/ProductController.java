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
		String view="";
		if(action == null) {
			action = "list";
		}
		switch(action) {
		case "list" : view = list(req,resp); break;
		case "info" : view = info(req,resp); break;
		}
		req.getRequestDispatcher("/ch05/" + view).forward(req, resp);
	}
	
	private String list(HttpServletRequest req, HttpServletResponse resp) {
		// 데이터는 service.findAll() 를 넘긴다.
		req.setAttribute("plist", service.findAll());
		// productList.jsp 화면 이동
		return "productList.jsp";
	}
	
	private String info(HttpServletRequest req, HttpServletResponse resp) {
		// pid 을 매개변수로 하는 service.find(pid) 를 호출한 후 
		req.setAttribute("p", service.find(req.getParameter("pid")));
		// productInfo.jsp로 화면 이동
		return "productInfo.jsp";
	}
}
