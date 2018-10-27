package pl.sdacademy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/name")
public class NameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		req.setAttribute("name", req.getSession().getAttribute
			("name"));
		req.getRequestDispatcher("/name.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse
		resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		HttpSession session = req.getSession();
		session.setAttribute("name", name);
		resp.sendRedirect("/name");
	}
}
