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
import com.entities.Expense;
import com.entities.UserData;

@WebServlet("/saveExpense")
public class SaveExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String title=req.getParameter("title");
		String date=req.getParameter("date");
		String time=req.getParameter("time");
		String description=req.getParameter("description");
		String price=req.getParameter("price");
		 
		
		HttpSession session=req.getSession();
		UserData user=(UserData)session.getAttribute("loginUser");
		
		Expense ex=new Expense(title, date, time, description, price, user);
		
		
		ExpenseDao dao=new ExpenseDao(HibernateUtil.getSessionFactory());
		boolean f=dao.saveExpense(ex);
		
		if(f) {
			session.setAttribute("msg","Expense added Successfully");
			res.sendRedirect("user/add_expense.jsp");
			
		}else {
			session.setAttribute("msg","Something went wrong!");
			res.sendRedirect("user/add_expense.jsp");
		}
		
	}

}
