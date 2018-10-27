package pl.sdacademy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

@WebServlet("/name-cookie")
public class NameCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		String cookieValue = null;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			cookieValue = Stream.of(cookies).filter(cookie ->
				"nameCookie".equals(cookie.getName())).findAny
				().map(Cookie::getValue).orElse("DEFAULTNAME");
		}
		req.setAttribute("nameAttrFromCookie", cookieValue);
		req.getRequestDispatcher("/name-cookie.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse
		resp) throws ServletException, IOException {
		resp.addCookie(new Cookie("nameCookie", req.getParameter
			("name")));
		resp.sendRedirect("/name-cookie");
	}
}
