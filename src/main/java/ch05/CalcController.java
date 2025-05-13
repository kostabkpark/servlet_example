package ch05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/calcControl")
public class CalcController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Calculator cal = new Calculator();
		int n1 = Integer.parseInt(req.getParameter("n1"));
		int n2 = Integer.parseInt(req.getParameter("n2"));
		String op = req.getParameter("op");
		cal.setN1(n1);
		cal.setN2(n2);
		cal.setOp(op);
		long result = cal.calc();
		
		String path="/ch05/calcResult.jsp";
		req.setAttribute("result", result);
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
