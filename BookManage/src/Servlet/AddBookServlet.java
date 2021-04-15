package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import daopack.BookDAO;
import daopack.Book;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double price=Double.parseDouble(request.getParameter("price"));
		String author=request.getParameter("author");
		
        BookDAO dao = new BookDAO();
        Book b=new Book(id,name,price,author);
        
        if(dao.addBook(b)) {
        	response.sendRedirect("BookServlet");
        }
        else {
        	RequestDispatcher rd = request.getRequestDispatcher("BookServlet");
        	out.println("<p>Error in Adding</p>");
        	rd.include(request, response);
        }

	}


}
