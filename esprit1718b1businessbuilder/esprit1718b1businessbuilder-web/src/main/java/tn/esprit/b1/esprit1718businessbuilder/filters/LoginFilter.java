package tn.esprit.b1.esprit1718businessbuilder.filters;

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

import tn.esprit.b1.esprit1718b1businessbuilder.mBeans.Identity;


@WebFilter("/home.jsf")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		
		Identity loginBean = (Identity) servletRequest.getSession().getAttribute("identity");
		
		if(loginBean != null && loginBean.getIsLogged()){
			
			chain.doFilter(servletRequest, servletResponse);
		
		} else {
			
			servletResponse.sendRedirect(servletRequest.getContextPath() + "/login.jsf");
			System.out.println(" url = " + ((HttpServletRequest) request).getRequestURL());
		}
        
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	

}
