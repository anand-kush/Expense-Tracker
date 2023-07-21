package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;

@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		ExpenseDao dao=new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean f=dao.deleteExpense(id);
		
		HttpSession session=req.getSession();
		
		if (f) {
			session.setAttribute("msg","Delete Successfully");
			res.sendRedirect("user/view_expense.jsp");
			
		} else {
			session.setAttribute("msg","Something went wrong");
			res.sendRedirect("user/view_expense.jsp");
		}
		
		
	}

	

}
