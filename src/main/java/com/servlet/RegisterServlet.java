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

@WebServlet("/userRegister")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String fullname=req.getParameter("fullname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String about=req.getParameter("about");
		
		UserData u= new UserData(fullname,email,password,about);
		
//		System.out.println(u);
		
		UserDao dao=new UserDao(HibernateUtil.getSessionFactory());
		boolean f=dao.saveuser(u);
		
		HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("msg","Register Successfully");
			res.sendRedirect("register.jsp");
			
		}else {
			session.setAttribute("msg","Something went wrong!");
			res.sendRedirect("register.jsp");
		}
		
	}

}
