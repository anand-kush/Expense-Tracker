package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entities.UserData;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		UserDao dao=new UserDao(HibernateUtil.getSessionFactory());
		UserData u=dao.login(email, password);
		
		HttpSession session=req.getSession();
		
		if (u==null) {
			session.setAttribute("msg","invalid Email or Password");
			res.sendRedirect("login.jsp");
		} else {
			session.setAttribute("loginUser", u);
			res.sendRedirect("user/home.jsp");
		}
	}

}
