package controller.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;
import model.Account;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset-UTF8");

		Cookie arr[] = request.getCookies();
		for (Cookie c : arr) {
			if (c.getName().equals("gmail")) {
				request.setAttribute("gmail", c.getValue());
			}
			if (c.getName().equals("pass")) {
				request.setAttribute("pass", c.getValue());
			}
		}

		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset-UTF8");
		try {
			String username = request.getParameter("username");
			String pass = request.getParameter("password");
			String remembere = request.getParameter("remembere");

			Account acc = new AccountDao().getAccount(username, pass);
			if (acc != null) {
				HttpSession session = request.getSession();
				session.setAttribute("account", acc); // them account vao session
				Cookie gmail = new Cookie("gmail", username);
				Cookie paw = new Cookie("pass", pass);
				paw.setMaxAge(0);
				response.addCookie(paw);
				if (remembere != null) {
					paw.setMaxAge(60 * 60);
					response.addCookie(paw);
				}
				gmail.setMaxAge(60 * 60);
				response.addCookie(gmail);

				if (acc.getRole() == 0) {
					response.sendRedirect("home");
				} else if (acc.getRole() == 1) {
					response.sendRedirect("admin.jsp");
				}
			} else {
				request.setAttribute("mess", "Mật khẩu hoặc gmail không đúng");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
