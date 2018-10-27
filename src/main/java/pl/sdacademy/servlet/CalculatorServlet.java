package pl.sdacademy.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse
		resp) throws ServletException, IOException {
		Integer firstNumber = Integer.valueOf(req.getParameter
			("firstNumber"));
		Integer secondNumber = Integer.valueOf(req.getParameter
			("secondNumber"));
		String operator = req.getParameter("operator");

		int result = 0;
		switch (operator) {
			case "+":
				result = firstNumber + secondNumber;
				break;
			case "-":
				result = firstNumber - secondNumber;
				break;
		}

		req.setAttribute("result", result);
		RequestDispatcher dispatcher = req.getRequestDispatcher
			("/calculator.jsp");
		dispatcher.forward(req, resp);
	}
}
