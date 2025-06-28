<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<title>ToDoApp</title>
</head>

<body class="bg-light">

<%
String msg = (String)session.getAttribute("msg");
if(msg != null)
{
%>
    <h3 class="text-danger text-center">   <%=msg%> </h3>
<% 	
}
session.removeAttribute("msg");
%>

  <div class="container bg-white border rounded-3 p-3 w-50" style="margin-top:6rem ">
  	<h1 class="text-center text-danger display-5">Sign Up</h1>
     <form action="adduser" method="post">
        <div class="row g-3">
           <div class="col-md-6">
              <label for="uname" class="form-label"> Enter user name</label>
              <input type="text" name="uname" id="uname" class="form-control">
           </div>
           
           <div class="col-md-6">
              <label for="upass" class="form-label"> Enter Password</label>
              <input type="password" name="upass" id="upass" class="form-control">
           </div>
           
           <div class="col-md-12">
              <label for="uemail" class="form-label"> Enter Email</label>
              <input type="email" name="uemail" id="uemail" class="form-control">
           </div>
           
           <div class="col-md-6 offset-md-5">
               <div>
                 <button class="btn btn-success btn-sm"> SignUp</button>
               </div>
           </div>
        </div>s  
     </form>
     
     <div class="col-md-6">
        <div>
            <p class="form-text">Already SignedUp??</p>
            <a href="login.jsp" role="button" class="btn btn-danger btn=sm">Login</a>
        </div>
     </div>
  </div>

</body>
</html>