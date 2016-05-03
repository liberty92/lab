package com.liberation.filter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogInfo
 */
@WebServlet("/log")
public class LogInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
//		CANT USING BY DEPLOY WAR FILE
		try (BufferedReader br = new BufferedReader(new FileReader(request.getServletContext().getRealPath("log.txt"))))
		{
			String sCurrentLine;
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("<html><body><h1>LOGGING LIBERATION SYSTEM</h1>");
			
			while ((sCurrentLine = br.readLine()) != null) {
//				System.out.println(sCurrentLine);
				pw.println("<br/>"+sCurrentLine);
			}
			pw.println("</html>");
		} catch (IOException e) {
			e.printStackTrace();
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
