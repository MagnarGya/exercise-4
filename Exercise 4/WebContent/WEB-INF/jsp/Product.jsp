<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="T" prefix="T" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
img{
	width: 250px;
	height: 175px;
	inline: true;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="no.hib.dat152.labels.Labels" var="labels"/>
</head>
<body>
<form>
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English (US)</option>
                <option value="no" ${language == 'no' ? 'selected' : ''}>Norsk</option>
                <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
            </select>
</form>

<h1><fmt:message key="products" bundle="${labels}"></fmt:message></h1>

<h3>${sessionScope.pName0}</h3>
<p style=inline:true;> <img src="${sessionScope.imageFile0}" alt=<fmt:message key="pictureTextWhite" bundle="${labels}"/>>
<p> <fmt:message key="name" bundle="${labels}"></fmt:message> : ${sessionScope.pName0} </p>
<p> <fmt:message key="description" bundle="${labels}"></fmt:message> : ${sessionScope.pDescription0}  </p>
<form action="products" method="POST"><input type="hidden" name = "product" value="0"><input type="submit" value="<fmt:message key="addToCart" bundle="${labels}"></fmt:message>" ></form>

<h3>${sessionScope.pName1}</h3>
<p style=inline:true;> <img src="${sessionScope.imageFile1}" alt=<fmt:message key="pictureTextBlack" bundle="${labels}"/>>
<p> <fmt:message key="name" bundle="${labels}"></fmt:message> : ${sessionScope.pName1} </p>
<p> <fmt:message key="description" bundle="${labels}"></fmt:message> : ${sessionScope.pDescription1}  </p>
<form action="products" method="POST"><input type="hidden" name = "product" value="1"><input type="submit" value="<fmt:message key="addToCart" bundle="${labels}"></fmt:message>" ></form>
<a href="cart"><fmt:message key="goToCart" bundle="${labels}"/></a> </br>
<T:copyright since="2008">HiB</T:copyright>
</body>
</html>