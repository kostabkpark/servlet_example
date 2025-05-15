package ch07;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class NewsController
 */
@WebServlet("/news")
@MultipartConfig(maxFileSize = 1024*1024*2, location = "/img")
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
		req.setCharacterEncoding("utf-8");
		String method = req.getMethod();
		String action = req.getParameter("action");
		String path = "/ch07/";
		String view = "";
		
		if(action == null) {
			resp.sendRedirect("/news?action=list");
		} else {
			switch(action) {
			case "list" : 
				try {
					view = list(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} break;
			case "view" : 
				try {
					view = view(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} break;
			case "addNews" : view = addNews(req, resp); break;
			case "delNews" : view = delNews(req, resp); break;
			}
			context.getRequestDispatcher(path + view).forward(req, resp);
		}
	}
	
	private String list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<News> news = newsDAO.getAll();
		req.setAttribute("newsList", news);
		return "newsList.jsp";
	}
	private String view(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int aid = Integer.parseInt(req.getParameter("aid"));
		News news = newsDAO.getNews(aid);
		req.setAttribute("news", news);
		return "newsView.jsp";
	}
	
	private String addNews(HttpServletRequest req, HttpServletResponse resp)  {
		News n = new News();
		Part part = req.getPart("img");
		return "newsList.jsp";
	}
	
	private String delNews(HttpServletRequest req, HttpServletResponse resp)  {
		
		return "newsList.jsp";
	}
}
