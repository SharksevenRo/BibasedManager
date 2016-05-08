package com.nchu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		String url = request.getRequestURL().toString();
		if(url.endsWith(".css")||url.endsWith(".js")||url.endsWith(".jpg")||url.endsWith(".png")||url.endsWith("login.jsp")){
			arg2.doFilter(arg0, arg1);
		}else{
			if(request.getSession().getAttribute("user")!=null){
				arg2.doFilter(request, response);
			}else{
				response.sendRedirect("http://localhost:8080/BibasedManager/login.jsp");
			}

		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
