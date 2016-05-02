package com.liberation.lab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Redirect
 */
@WebServlet(urlPatterns = { "/abc" , "/xyz" })
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = request.getParameter("request");
		if(url.equals("r1")){
			request.getRequestDispatcher("http://google.vn").forward(request, response);
		}
		else{
			request.getRequestDispatcher("welcome").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		ServletOutputStream out = response.getOutputStream();
		out.println("There're 2 ways to print");
		out.println("1: Using PrintWriter");
		out.println("2: Using ServletOutputStream");
		out.println("YOUR INPUT CONTENT IS:");
		
		
		String url = request.getParameter("request");
		out.println("YOUR INPUT CONTENT IS:"+url);
		
		if(url.equals("pistachio")){
			request.getRequestDispatcher("welcome").forward(request, response);
		}
		else{
			request.getRequestDispatcher("test").forward(request, response);
		}
	}

}
