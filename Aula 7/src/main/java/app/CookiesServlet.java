package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookiesServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		
		if (cookies.length == 0) {
			Cookie cookie1 = new Cookie("usuario","Carlos");
			cookie1.setMaxAge(24*3600*60);
			
			resp.addCookie(cookie1);
		
		} else {
			for (int i= 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("usuario")) {
					resp.getWriter().println(cookies[i].getValue());
				
				} else {
					resp.getWriter().println("O cookie foi criado!");
					
					Cookie cookie1 = new Cookie("usuario","Carlos");
					cookie1.setMaxAge(24*3600*60);
					
					resp.addCookie(cookie1);
				}
				
			}
		}
	}
}
