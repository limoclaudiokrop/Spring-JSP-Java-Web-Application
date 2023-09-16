<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>

<html>
<head>
  <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Food Recipes </title>
 
</head>
<body style=" height: 100vh;">
<!--Main Navigation-->
          <header>

          	<nav id="main-navbar" class="navbar navbar-expand-lg border-bottom navbar-light fixed-top m-0 p-0"
          	 style="min-height: 50px; background-color: #cccccc">
              <!-- Container wrapper -->
              <div class="container-fluid p-0 m-0  row">
              		<div class="col-6">
              			<h2 style="color: blue" > Food Recipes </h2>
	            	</div>
	            	

	            	<div class="col-2">
	            		 
						<a href="/"><button class="btn btn-info">All Recipes</button></a>

	            	</div>

	            	<div class="col-2">
	            		<a href="/create"><button class="btn btn-info">Add Recipe</button></a>
	            		
	            	</div>

	            	
	            	<div class="col-2 " >
	            		<form method="get" action='http://localhost:8080/sort'>
	            			<div class="d-flex justify-content-center align-items-center" >
			                <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" name="search" aria-describedby="search-addon"   />
			          
		                  	<button class="btn btn-info" type="submit" style="margin-left: 10px;">Search</button>
          					</div>
          				</form>
          			</div>
              </div>
          </nav>

          </header>
          <!--Main Navigation-->

          <!--Main layout-->
          <main style="margin-top: 100px; padding-top: 100px;  height: 100vh;">
          	<div class="container">
          		
          		<c:forEach items="${list}" var="item">
          			<div class="row mb-5">
          				<div class="col-6">
          					<img src=${item.link} alt="Food"
          				 		width="500"	>
          				 </div>
          				 <div class="col-6">
          				 	<h2> ${item.name} </h2>
          				 	${item.desc}
          				 	<div class="d-flex justify-content-between mt-3">
          				 		<form method="get" action='http://localhost:8080/delete'>
          				 			<input type="hidden" value=${item.id} name="id">
          				 			<button class="btn btn-info" type="submit">Delete</button>
          				 		</form>
          				 		<form method="get" action='http://localhost:8080/edit'>
          				 			<input type="hidden" value=${item.id} name="id">
          				 			<button class="btn btn-info" type="submit">Edit</button>
          				 		</form>
          				 		<form method="get" action='http://localhost:8080/view'>
          				 			<input type="hidden" value=${item.id} name="id">
          				 			<button class="btn btn-info" type="submit">View More</button>
          				 		</form>
          				 	</div>
          				 </div>
          			</div>
          		</c:forEach>
          		
          		
          		
          		
          		
          		
          	</div>
			
          </main>
          <!--Main layout-->
          <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

