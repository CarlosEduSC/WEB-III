package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServelet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("field-email");
		String senha = req.getParameter("field-senha");
		
		Usuario usu = verificaLogin(email, senha);
		
		if (usu != null) {
			HttpSession sessao = req.getSession(true);
			
			sessao.setAttribute("usuario", usu);
			sessao.setAttribute("esta_logado", true);
			
			resp.sendRedirect("Index.jsp");
			
		} else {
			resp.sendRedirect("Login.jsp");
		}
	}
	
	public Usuario verificaLogin(String email, String senha) {
		Usuario u1 = new Usuario("carloseduardodas.c@gmail.com", "1234567");
		Usuario u2 = new Usuario("asdasdadasd@gmail.com", "12345678");
		Usuario u3 = new Usuario("ikliuikuik@gmail.com", "123456789");
		
		ArrayList<Usuario> bancoDados = new ArrayList<Usuario>();
		
		bancoDados.add(u1);
		bancoDados.add(u2);
		bancoDados.add(u3);
		
		Usuario usuarioLogin = new Usuario(email, senha);
		
		if (bancoDados.contains(usuarioLogin)) {
			return usuarioLogin;
		
		} else {
			return null;
		}
	}
}