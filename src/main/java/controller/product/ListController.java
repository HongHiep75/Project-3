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
 * Servlet implementation class ListController
 */
@WebServlet("/ListController")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			String soTrang = request.getParameter("Trang");
			if(soTrang == null) {
				soTrang = "1";
			}
			
			
			ListProductDAO lpd = new ListProductDAO();
			int soSanPham =  lpd.soSanPham(null);
			int trangCuoi = (soSanPham/6 != 0)?(soSanPham/6+1):(soSanPham/6); // so trang cuoi khi phan trang
			List<Product> list = lpd.listProduct(soTrang);
			
			request.setAttribute("trangCuoi",trangCuoi ); 
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("products", list);
			request.setAttribute("Trang", soTrang);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} catch (Exception e) {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
