<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.william.bean.Dollar"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>

	<script src="js/jquery-3.6.0.min.js"></script>
    <script>
    
    window.onload = function(){
		$("#submit").click(function () {
			let code = $("#code").val();
			let xhr = new XMLHttpRequest();
			xhr.open("POST", "<c:url value='/searchCode' />", true);
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send("code=" + code);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					let info = JSON.parse(xhr.responseText);
					for(const key in tableInfo){
						let id = "#" + key;
						document.querySelector(id).innerHTML = tableInfo[key] + "\n";
					}
				}
			}
		});
    
    </script>

</head>

<body>

	<div class="input-field">
		<i class="fas fa-user"></i>
		<input type="text" name="code" id="code" autofocus/>
		<button id='submit'>submit</button></td>
	</div>
	<div>
		<h3>
			<p id="result">
			</p>
		</h3>
	</div>


</body>

</html>