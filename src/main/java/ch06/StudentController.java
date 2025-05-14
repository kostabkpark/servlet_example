package ch06;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentControl")
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		String view = "";
		if(action == null){
			action = "list";
		}
		switch(action) {
		case "list" : view = list(req,resp); break;
		case "insert" : view = insert(req,resp); break;
		}
		req.getRequestDispatcher("/ch06/" + view).forward(req, resp);			
	}
	
	private String list(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("students", new ArrayList<>());
		return "studentInfo.jsp";
	}
	
	private String insert(HttpServletRequest req, HttpServletResponse resp) {
		return "studentInfo.jsp";
	}
}
