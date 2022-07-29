package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
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
		try {
			String name = request.getParameter("search");
			request.setAttribute("name",name);
			
			int soSanPham = new ListProductDAO().soSanPham(name);
		    System.out.println(soSanPham);
			int end = (soSanPham%6 == 0)?(soSanPham/6):((soSanPham/6)+1);
			System.out.println(end);
			request.setAttribute("trangCuoi", end);
			String soTrang = request.getParameter("Trang");
			
			if (soSanPham == 0) {
				request.setAttribute("soTrang", "0");
                request.setAttribute("sl", soSanPham);
                request.getRequestDispatcher("search.jsp").forward(request, response);
			}
			
			if (soTrang == null) {
				soTrang = "1";
			}
			request.setAttribute("soTrang", soTrang);
			


			List<Product> list = new ListProductDAO().serch(name,soTrang);
			
			
			request.setAttribute("products", list);
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
