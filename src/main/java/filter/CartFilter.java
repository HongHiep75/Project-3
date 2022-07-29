package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;


@WebFilter("")
public class CartFilter extends HttpFilter implements Filter {
       
   private ServletContext context;
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req  = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String url = req.getRequestURI();
		HttpSession session = req.getSession();
		Account acc = (Account) session.getAttribute("account");
//		if(url.startsWith("/PRJ321x_A3/home")) {
			if(acc != null) {
//				if(acc.getRole() == 0){
					chain.doFilter(request, response);
//				}else {
//					req.setAttribute("err", "Không có quyền truy cập");
//					req.getRequestDispatcher("login").forward(req, res);
//				}
			}else {
				req.setAttribute("err", "Đăng nhập hoặc đăng ký");
				req.getRequestDispatcher("login").forward(req, res);
			}
			
//		}else {
//			chain.doFilter(request, response);
//		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
	}

}
