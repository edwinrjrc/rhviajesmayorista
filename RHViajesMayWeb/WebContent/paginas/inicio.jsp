<!DOCTYPE html>
<html lang="en" ng-app="rhmayoristainicio">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>RH Viajes Mayorista</title>
<!-- Bootstrap Core CSS -->
<link href="<%= request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="<%= request.getContextPath() %>/resources/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="<%= request.getContextPath() %>/resources/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<!-- jQuery -->
<script src="<%= request.getContextPath() %>/resources/js/jquery.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<%= request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/resources/js/angular.min.js" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/resources/js/angular-route.min.js" type="text/javascript">
	</script>
<!-- Custom Theme JavaScript -->
<script src="<%= request.getContextPath() %>/resources/js/sb-admin-2.js"></script>
<script src="<%= request.getContextPath() %>/resources/js/metisMenu.min.js"></script>
<script src="<%= request.getContextPath() %>/resources/js/controlerapp.js" type="text/javascript"></script>
<script src="<%= request.getContextPath() %>/resources/js/menu.js" type="text/javascript"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/resources/js/util.js">
</script>
</head>
<body>
	<div id="wrapper" ng-controller="CtrlMenu">
		<menu-app></menu-app>
	</div>
	<!-- /#wrapper -->
	<script type="text/ng-template" id="idInicio">
			<div ng-include="'<%= request.getContextPath() %>/paginas/introduccion.html'"></div>
	</script>
	<script type="text/ng-template" id="idAdmSeguridad">
			<div ng-include="'<%= request.getContextPath() %>/paginas/seguridad/formulario.html'"></div>
	</script>
	<script type="text/ng-template" id="idNuevoUsuario">
			<div ng-include="'<%= request.getContextPath() %>/paginas/seguridad/nuevousuario.html'"></div>
	</script>
	
	<div id="page-wrapper" ng-view></div>
</body>
</html>