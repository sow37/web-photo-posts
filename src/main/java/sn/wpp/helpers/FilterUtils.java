package sn.wpp.helpers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterUtils
 */
@WebFilter({"/user", "/logout", "/update", "/delete","/user/profile","/user/upgrade",
	"/user/delete", "/user/add", "/user/settings", "/user/list", "/user/list-admin", 
	"/user/edit","/user/album/images", "/user/album/image/add", "/user/album/image/update",
	"/user/album/image/delete","/user/albums", "/user/album/add", "/user/album/update", 
	"/user/album/delete", "/user/gallery"})
public class FilterUtils implements Filter {

    /**
     * Default constructor. 
     */
    public FilterUtils() {
        // TODO Auto-generated constructor stub
    }

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
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		if(session.getAttribute("utilisateur") == null) {
			res.sendRedirect(req.getContextPath()+"/login");
		}else {

		// pass the request along the filter chain
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
