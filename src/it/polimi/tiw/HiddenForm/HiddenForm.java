package it.polimi.tiw.HiddenForm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenForm
 */
@WebServlet(description = "Testing an hidden form attribute", urlPatterns = { "/HiddenForm" })
public class HiddenForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int count;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiddenForm() {
        super();
    }
    
    public void init() {
    	count = 0;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.append("<HTML>");
		out.append("<body>");
		if(request.getParameter("custId")!=null) {
			out.append("<h1>Welcome!</h1> You're customer number "+ request.getParameter("custId")+"<br>");
			out.append("here are some informations on this connection.<br>");
			out.append("<h2>Query string</h2>"+ request.getQueryString()+"<br>");
			
			ArrayList<String> headerList = Collections.list(request.getHeaderNames());
			ArrayList<String> paramsList = Collections.list(request.getParameterNames());
			
			out.append("<h2>Headers</h2>");
			for(String hn : headerList)
				out.append("Header "+hn+": "+request.getHeader(hn)+"<br>");
			
			out.append("<h2>Parameters</h2>");
			for(String pn : paramsList)
				out.append("Parameter "+pn+": "+request.getParameter(pn)+"<br>");
			
			out.append("<h2>Body</h2>");
			BufferedReader buf = request.getReader();
			String line=buf.readLine();
			if(line==null) out.append("The body of the request seems to be empty :(");
			while(line!=null) {
				out.append(line+"<br>");
				line=buf.readLine();
			}
		
		}
		else {
			count++;
			out.append("<form>");
			out.append("<input type=\"hidden\" id=\"custId\" name=\"custId\" value="+Integer.toString(count)+">");
			out.append("<input type=\"text\" id=\"fname\" name=\"fname\"> <br><br>");
			out.append("<input type=\"submit\" value=\"Submit\">");
			out.append("</form>");
			
			
		}
		out.append("</body>");
		out.append("</HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.append(request.toString());
	}

}
