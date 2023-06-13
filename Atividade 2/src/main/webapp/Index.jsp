<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<title>Insert title here</title>
	</head>
	
	<body>
	
		<%
			String erro = (String) request.getAttribute("erro");
		%>
		
		<%if (erro != null) {%>
			<p><% out.println(erro);%></p>
		<%}%>
		<form method="post" action="http://localhost:8080/Atividade2/processa">
			
			<input type="text" name="field_nome"/> <br/>
			<input type="date" name="field_data"/> <br/>
			
			<select name="field_idioma" id="">
				<option value="Ingles">Inglês</option>
				<option value="Portugues">Português</option>
				<option value="Alemao">Alemão</option>
			</select> <br/>
			
			<span><input type="checkbox" name="habilidades" value="Java"> Java</span>
			<span><input type="checkbox" name="habilidades" value="JavaScript"> JavaScript</span>
			<span><input type="checkbox" name="habilidades" value="HTML"> HTML</span>
			<span><input type="checkbox" name="habilidades" value="CSS"> CSS</span>
			
			<input type="submit" name="field_enviar" value="Enviar"/>
		</form>
	</body>
</html>