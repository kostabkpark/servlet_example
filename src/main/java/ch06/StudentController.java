package ch06;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/studentControl")
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	StudentDAO dao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new StudentDAO();
	}
	
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
		req.setAttribute("students", dao.findAll());
		return "studentInfo.jsp";
	}
	
	private String insert(HttpServletRequest req, HttpServletResponse resp) {
		Student s = new Student();
		try {
			BeanUtils.populate(s, req.getParameterMap());	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dao.insert(s);
//		s.setUsername(req.getParameter("username"));
//		s.setUniv(req.getParameter("univ"));
//		s.setBirth(req.getParameter("birth")); // type mismatch
//		s.setEmail(req.getParameter("email"));
		
		return list(req, resp);
	}
}
