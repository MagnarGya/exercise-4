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

<h1><%out.print(no.hib.dat152.FakeDAO.getProduct(0).getpName()); %></h1>
<p style=inline:true;> <img src=<%out.print(no.hib.dat152.FakeDAO.getProduct(0).getImageFile()); %> alt=<fmt:message key="pictureTextWhite" bundle="${labels}"/>>
<%out.print(no.hib.dat152.FakeDAO.getDescription(0, (String)session.getAttribute("language"))); %> 
<form action="product" method="POST"><input type="hidden" name = "product" value="0"><input type="submit" value="<fmt:message key="addToCart" bundle="${labels}"></fmt:message>" ></form>

<h1><%out.print(no.hib.dat152.FakeDAO.getProduct(1).getpName()); %></h1>
<p style=inline:true;> <img src=<%out.print(no.hib.dat152.FakeDAO.getProduct(1).getImageFile()); %> alt=<fmt:message key="pictureTextBlack" bundle="${labels}"/>>
<%out.print(no.hib.dat152.FakeDAO.getDescription(1, (String)session.getAttribute("language"))); %> 
<form action="product" method="POST"><input type="hidden" name = "product" value="1"><input type="submit" value="<fmt:message key="addToCart" bundle="${labels}"></fmt:message>" ></form>
<a href="cart"><fmt:message key="goToCart" bundle="${labels}"/></a> </br>
<T:copyright since="2008">HiB</T:copyright>
</body>
</html>