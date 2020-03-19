package it.polimi.tiw.UnsafeCounter;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UnsafeCounter
 */
@WebServlet(description = "servlet that counts the number of visit", urlPatterns = { "/UnsafeCounter" })
public class UnsafeCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int counter;
	private Boolean reset;
      
	public void init() {
		counter = 0;
		reset = false;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnsafeCounter() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String reset_param = request.getParameter("reset");
		if (reset_param!=null && reset_param.equals("true")) {
			reset=true;
			counter = 0;
		}
		counter++;
		
		out.append("This servlet was visited " + counter + " times");
		if(reset) out.append(" since last reset");
		out.append(".");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
