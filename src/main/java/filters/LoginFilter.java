package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managedBeans.AccountBean;
import managers.UserManager;

public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		AccountBean loginBean = (AccountBean) ((HttpServletRequest) request).getSession().getAttribute("accountBean");

		if (loginBean == null || !loginBean.isLoggedIn()) {
			String contextPath = ((HttpServletRequest) request).getContextPath();
			((HttpServletResponse) response).sendRedirect(contextPath + "/faces/Login.xhtml");
		}

		chain.doFilter(request, response);

	}

	public void init(FilterConfig config) throws ServletException {
		
	}

	public void destroy() {

	}

}