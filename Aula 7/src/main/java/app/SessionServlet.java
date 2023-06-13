package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessao")
public class SessionServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessao = req.getSession();
		
		if (sessao.isNew()) {
			resp.getWriter().println("Sessão nova!");
			
			sessao.setAttribute("usuario_logado","Carlos");
		
		} else {
			String usuario = (String) sessao.getAttribute("usuario_logado");
			
			
		}
	}
}
