package controllers;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cadastro;

@WebServlet("/processa")
public class ProcessaFormServelet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("call doPost");
		
		String nome = req.getParameter("field_nome");
		String dataStr = req.getParameter("field_data");
		String idioma = req.getParameter("field_idioma");
		String[] habilidades = req.getParameterValues("habilidades");
		
		Cadastro cadastro =  new Cadastro();
		
		try {
			cadastro.setNome(nome);
			cadastro.setIdioma(idioma);
			cadastro.setDataNascimento(dataStr);
			cadastro.setHabilidades(habilidades);
			
			resp.getWriter().println("Nome: "+ nome);
			resp.getWriter().println("Data: "+ dataStr);
			resp.getWriter().println("Idioma: "+ idioma);
			resp.getWriter().println("Habilidades:");
			
			int i;
			
			for (i=0;habilidades[i] != null;i++) {
				resp.getWriter().println(habilidades[i]);
			}
		} catch (Exception e) {
			req.setAttribute("erro", e.getMessage());
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("Index.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
