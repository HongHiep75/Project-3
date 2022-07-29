package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import dao.AccountDao;
import dao.OrdersDao;
import model.Account;
import model.Cart;
import model.Orders;
import model.Product;

/**
 * Servlet implementation class PayController
 */
@WebServlet(urlPatterns = {"/pay"})
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setContentType("text/html;chatset-UTF8");
	  try {
		 String adress = request.getParameter("adderss");
		 if(adress == null) {
			 request.setAttribute("err", "Chưa nhập địa chỉ");
			 request.getRequestDispatcher("cart.jsp").forward(request, response);
		 }
		 String discount = request.getParameter("Discount");
		 if(discount.length() > 8) {
			 request.setAttribute("err", "discount không đúng ");
			 request.getRequestDispatcher("cart.jsp").forward(request, response);
		 }
		 HttpSession session = request.getSession();
		 Account acc = (Account) session.getAttribute("account");

		 if(acc.getAddress().length() == 0) {
			 AccountDao accDao = new AccountDao();
			 accDao.setAdress(acc.getUserMail(), adress);
		 }

	     Cart c = (Cart) session.getAttribute("Cart");
	     Orders o = new Orders(0, adress, "", acc.getUserMail(), null, discount);
	     OrdersDao od = new OrdersDao();
	     od.inserOrder(o);
	     int id = od.getOrderId(o, acc.getUserMail());
	     for(Product p : c.getItems()) {
	    	 System.out.println(p.getName());
	    	 
	     }
	     for(Product p : c.getItems()) {
	    	 new OrdersDao().insertOrders_detail(id, p);
	     }
	      
	     response.sendRedirect("home"); 	  
		  
	} catch (Exception e) {
		// TODO: handle exception
	}
	 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
