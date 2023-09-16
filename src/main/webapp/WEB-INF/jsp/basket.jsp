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
    <title>Cart System </title>
 
</head>
<body style=" height: 100vh;">
<!--Main Navigation-->
          <header>

          	<nav id="main-navbar" class="navbar navbar-expand-lg navbar-light bg-white fixed-top m-0 p-0">
              <!-- Container wrapper -->
              <div class="container-fluid p-0 m-0 border row">
              		<div class="col-6">
              			<form method="get" action='http://localhost:8080/search'>
					  		<input type="hidden"
					            name="username"
					            value="${username}">
					        
	              			<div class="input-group rounded d-flex justify-content-center align-items-center" style="max-width: 400px; margin-top: 30px; margin-left: 5px; margin-bottom: 10px;">
				                <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" name="item" aria-describedby="search-addon"   />
				                
			                  	<button type="submit" style="margin-left: 10px;">Search</button>
	              			</div>
	              		</form>
	            	</div>

	            	<div class="col-2">
	            		 <a class="navbar-brand p-0 m-0" href="#" type="button" data-toggle="dropdown">
                          	Account
                        </a>
                        
                        <ul class="dropdown-menu dropdown-menu-right" role="menu">
                            <li>
                            <a class="dropdown-item" href="#">Username: ${username}</a>
                            </li>
                            <li>
                            <a class="dropdown-item" href="#">Balance: ${balance}</a>
                            </li>
                            <li>
                              <a class="dropdown-item" href="http://localhost:8080/login">Log out</a>
                            </li>
                            <c:choose>
													    <c:when test="${admin =='1'}">
													        <li>
								                              <a class="dropdown-item" href="#"  data-toggle="modal" data-target="#exampleModal">Add Item</a>
								                            </li>
													        <br />
													    </c:when>    
													    
													</c:choose>
                            
                          </ul>


	            	</div>

	            	<div class="col-2">
	            		<form method="get" action='http://localhost:8080/openBasket'>
					  		<input type="hidden"
					            name="username"
					            value="${username}">
					        
					        
					  		<button class="btn btn-info">Trolley</button>
					  	</form >
	            		<!-- <button href="http://localhost:8080/openBasket/${username}">Trolley</button> -->
	            	</div>

	            	<div class="col-2">
	            		<form method="get" action='http://localhost:8080/openOrders'>
					  		<input type="hidden"
					            name="username"
					            value="${username}">
					        
					        
					  		<button class="btn btn-info">Past Orders</button>
					  	</form >
	            		<!-- <button href="http://localhost:8080/openBasket/${username}">Trolley</button> -->
	            	</div>
              </div>
          </nav>

          </header>
          <!--Main Navigation-->

          <!--Main layout-->
          <main style="margin-top: 100px; padding-top: 100px;  height: 100vh;">
          	<!-- Modal -->
			
			<div class="">
				<div class="row" style="width: 100%;  margin-left: 300px;">
					<div class="col-12">
						<h4>${head} </h4><br>
					</div>
					
				<br>
				</div>
				<div class="row d-flex justify-content-center align-items-center" >
				
					<c:forEach items="${list}" var="item">
						<div style="margin-left: 100px;">
							<figure>
							  <img style="display: block;max-width:230px;max-height:200px;width: auto;height: auto;" src=${item.link}>
							  <figcaption style="padding-bottom: 30px;">
							  	<span>${item.name}</span><br>
							  	<span style="color:blue">$ ${item.price}</span><br>
							  	<form method="post" action='http://localhost:8080/buyItem'>
							  		<input type="hidden"
							            name="username"
							            value="${username}">
							        <input type="hidden"
							            name="itemName"
							            value="${item.name}">
							        <c:choose>
										    <c:when test="${buy =='0'}">
										        <button class="btn btn-info">Buy Item</button>
										    </c:when>    
										    
										</c:choose>
							  		
							  	</form >
							  	
							  </figcaption >
							 </figure>
						</div>
					    
					</c:forEach>
				</div>
			</div>
			
          </main>
          <!--Main layout-->
          <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

