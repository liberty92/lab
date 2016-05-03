package com.liberation.filter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/LogFilter")
public class LogFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LogFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;

		String servletPath = req.getServletPath();

		String log = ("#LOG INFO" + new Date() + " - ServletPath :" + servletPath + ", URL =" + req.getRequestURL());
		System.out.println(log);
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("logdata.txt", true))); 
		out.println(log); 
		out.close();
		
//		CANT USE WITH WAR FILE ------- OK NOW FUCK THIS SHIT HAHAHAHA
		PrintWriter pw = null;
		try {
			File file = new File(request.getServletContext().getRealPath("log.txt"));
			FileWriter fw = new FileWriter(file, true);
			pw = new PrintWriter(fw);
			pw.println(log);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

		// FileWriter writer = new FileWriter("log.txt", true);
		// BufferedWriter out = new BufferedWriter(writer);
		// out.write(log);
		// out.close();

		// Cho phép request được đi tiếp. (Vượt qua Filter này).
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
