package com.liberation.lab;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Redirect2
 */
@WebServlet("/test/r")
public class Redirect2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Redirect2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		 // Lấy parameter trên URL
        // http://localhost:8080/ServletTutorial/other/redirectDemo?redirect=true
        String redirect = request.getParameter("r");
 
        if ("true".equals(redirect)) {
            System.out.println("Redirect to ShowMeServlet");
            // contextPath luôn luôn là "" hoặc "/contextPath".
 
            String contextPath = request.getContextPath();
 
            // ==> /ServletTutorial/showMe
            response.sendRedirect(contextPath + "/welcome");

//            response.sendRedirect("http://google.vn");
            return;
        }
 
        ServletOutputStream out = response.getOutputStream();
        out.println("<h3>Text of RedirectDemoServlet</h3>");
        out.println("- servletPath=" + request.getServletPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
