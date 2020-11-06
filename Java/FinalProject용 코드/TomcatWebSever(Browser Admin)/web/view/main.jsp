<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#iot').click(function(){
		$.ajax({
			url:'iot.mc',
			success: function(data){
				// alert('Send Complete...');
			}
		});
	});
	$('#phone').click(function(){
		$.ajax({
			url:'ftest.do',
			success: function(data){
				alert('Send Complete...');
			}
		});
	});
	
	$.urlParam = function(name){
	    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	    if (results==null){
	       return null;
	    }
	    else{
	       return results[1] || 0;
	    }
	}


	var lat = $.urlParam('lat');
	var lng = $.urlParam('lng');
	
	while(true){
		$("input[name='lat']").text(lat);
	}
	
});
</script>
</head>

<body>
<h1>Main Page</h1>
<h2><a id="iot" href="#">Send IoT(TCP/IP)</a></h2>
<h2><a id="phone" href="#">Send Phone(FCM)</a></h2>


<input type="text" name="lat"/>




</body>
</html>