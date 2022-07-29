package controller.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDao;
import model.Account;

/**
 * Servlet implementation class RegisterSeverlet
 */
@WebServlet(urlPatterns = { "/register" })
public class RegisterSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterSeverlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;chatset-UTF8");
		response.sendRedirect("register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;chatset-UTF8");
		try {
			String mame = request.getParameter("username");
			String gmail = request.getParameter("userGmail");
			String pass = request.getParameter("password");
			String rePass = request.getParameter("Repass");

			AccountDao accDao = new AccountDao();

			if (!pass.equals(rePass)) { // trung mat khau
				request.setAttribute("mess", "Mật khẩu không trùng khớp nhập lại mật khẩu");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else if (accDao.checkGmail(gmail)) {
				Account acc = new Account(gmail, pass, 0, mame, "", "");
				accDao.signUp(acc);
				response.sendRedirect("login.jsp");
			} else {
				System.out.println("sai");
				request.setAttribute("mess", "Gmail đã tồn tại");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
