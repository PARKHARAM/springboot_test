<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp" %>
<link href="/css/test.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Libre+Baskerville:wght@400;700&family=Poppins:wght@300;400;500;600;700;800;900&family=Roboto:wght@100;300;400;500;700;900&family=Teko:wght@300;400;500;600;700&display=swap" rel="stylesheet">




<div class="container">
	<form action="/blog/user?cmd=loginProc" method="post" class="was-validated">
	  <div class="form-group">
	    <label for="username">Username:</label>
	    <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>
	  
	  <div class="form-group">
	    <label for="password">Password:</label>
	    <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
	    <div class="valid-feedback">Valid.</div>
	    <div class="invalid-feedback">Please fill out this field.</div>
	  </div>
	
	  <div class="form-group form-check">
	    <label class="form-check-label">
	      <input class="form-check-input" type="checkbox" name="remember" required> 아이디 기억하기.
	      <div class="valid-feedback">Valid.</div>
	      <div class="invalid-feedback">Check this checkbox to continue.</div>
	    </label>
	  </div>
	 
	  <button type="submit" class="btn btn-primary">로그인</button>
	</form>
</div>

<%@ include file="../include/footer.jsp" %>