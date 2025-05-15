package ch07;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewsController
 */
@WebServlet("/news")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDAO newsDAO;
	private ServletContext context;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		newsDAO = new NewsDAO();
		context = getServletContext();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		String action = req.getParameter("action");
		
		System.out.println(method);
		System.out.println(action);
		if(action == null) {
			resp.sendRedirect("/news?action=list");
		} else {
			switch(action) {
			case "list" : 
				try {
					list(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} break;
			case "view" : 
				try {
					view(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} break;
			}
		}
	}
	
	private void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("list 처리중입니다.");
		List<News> news = newsDAO.getAll();
		req.setAttribute("newsList", news);
		System.out.println(news);
	}
	private void view(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("view 처리중입니다.");
		News news = newsDAO.getNews(1);
		req.setAttribute("news", news);
		System.out.println(news.toString());
	}
}
