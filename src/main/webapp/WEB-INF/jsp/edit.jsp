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
	            		<button class="btn btn-info">Add Recipe</button>
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
          <main style="padding-top: 100px;  height: 100vh;">
          	<div class="container mb-5">
          		<form method="post" action='http://localhost:8080/edit_item'>
	          		<div class="d-flex justify-content-center align-items-center">
	          			<h5>Edit Recipe Name</h5>
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center">
	          			<input value="${item.name}" class="form-control" name="name" style="width: 50%">
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center mt-3">
	          			<h5>Edit Food Category e.g Vegeterian</h5>
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center">
	          			<input value="${item.category}" class="form-control" name="category" style="width: 50%">
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center mt-3">
	          			<h5>Edit Number of servings</h5>
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center">
	          			<input value="${item.count}"class="form-control" name="count" style="width: 50%">
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center mt-3">
	          			<h5>Edit Image link</h5>
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center">
	          			<input value="${item.link}" class="form-control" name="link" style="width: 50%">
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center mt-3">
	          			<h5>Edit Description</h5>
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center">
	          			<textarea  class="form-control" name="desc" rows="4" style="width: 50%">${item.desc}</textarea>
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center mt-3">
	          			<h5>Ingredients</h5>
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center">
	          			<textarea  class="form-control" name="ingredients" rows="4" style="width: 50%">${item.ingredients}</textarea>
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center mt-3">
	          			<h5>Instructions</h5>
	          		</div>
	          		<div class="d-flex justify-content-center align-items-center">
	          			<textarea  class="form-control" name="instruction" rows="4" style="width: 50%">${item.instruction}</textarea>
	          		</div>
	          		<input type="hidden" value=${item.id} name="id">
	          		<div class="d-flex justify-content-center align-items-center mt-3 mb-10">
	          			<button class="btn btn-info" type="submit" >Submit</button>	
	          		</div>
          		
          		</form>
          		
          		
          		
          	</div>
			
          </main>
          <!--Main layout-->
          <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

