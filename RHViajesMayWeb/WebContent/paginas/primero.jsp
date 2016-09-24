<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String usuarioLogin = ((HttpServletRequest)pageContext.getRequest()).getUserPrincipal().getName(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletRedirigir" method="post">
<input type="hidden" name="usuarioLogin" value="<%= usuarioLogin %>">
</form>
</body>
</html>
<script type="text/javascript">
document.forms[0].submit();
</script>