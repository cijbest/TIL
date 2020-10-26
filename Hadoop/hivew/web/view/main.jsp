<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>




<style>
body, #container {
 text-align: center;
}
</style>

</head>
<body>
<h1>자동차 빅데이터 분석</h1>


<h2><a href="chart.mc">View the latest chart</a></h2>
<c:choose>
	<c:when test="${centerpage == null }">
		  <jsp:include page="chart.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		  <jsp:include page="${centerpage}.jsp"></jsp:include>
	</c:otherwise>
</c:choose>



</body>
</html>




