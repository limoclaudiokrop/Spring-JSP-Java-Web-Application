<html>

	<head>
		<title>Login Page  </title>
	</head>
	
	<body>
		<h2> ${errorMsg}</h2>
	 	<h3> Sign In </h3>
	 	<br>
	 	<form method="post" action='http://localhost:8080/login'>
			<input type="text" name="username" placeholder="Username" /><br>
			<br>
			<input type="password" name="password" placeholder="password" /><br>
			<br>
			<button>Submit</button>
		</form>
		
		<br>
		<h3> Sign up </h3>
		<form method="post" action='http://localhost:8080/signup' >
			<input type="text" name="username" placeholder="User Name" /><br>
			<br>
			<input type="password" name="password" placeholder="password" /><br>
			<br>
			<button>Submit</button>
		</form>
	</body>
	
</html>