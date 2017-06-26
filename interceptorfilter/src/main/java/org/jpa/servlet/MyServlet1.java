package org.jpa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println(">>>>>>>>>>doGet()<<<<<<<<<<<");
		super.doGet(req, resp);
	//	doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		/*System.out.println(">>>>>>>>>>doPost()<<<<<<<<<<<");

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<html>");

		out.println("<head>");

		out.println("<title>HelloWorld</title>");

		out.println("</head>");

		out.println("<body>");

		out.println("<h1>这是：MyServlet1</h1>");

		out.println("</body>");

		out.println("</html>");*/

	}

}