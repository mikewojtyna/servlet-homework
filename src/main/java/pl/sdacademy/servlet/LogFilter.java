package pl.sdacademy.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LogFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse
		res, FilterChain chain) throws IOException, ServletException {
		req.getParameterMap().forEach((k, v) -> System.out.println
			("param key: " + k + "; param value: " + v
				.toString()));
		System.out.println("HTTP method: " + req.getMethod());
		chain.doFilter(req, res);
	}
}
