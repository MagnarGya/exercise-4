<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="T" prefix="T" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<c:set var="sum" value='${requestScope["sum"]}' />
<c:set var="description" value='${requestScope["descriptionMap"]}' />
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="no.hib.dat152.labels.Labels" var="labels"/>
</head>
<body>
	<form>
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English (US)</option>
                <option value="no" ${language == 'no' ? 'selected' : ''}>Norsk</option>
                <option value="es" ${language == 'es' ? 'selected' : ''}>Espa�ol</option>
            </select>
    </form>
	<h1><fmt:message key="cart" bundle="${labels}"/></h1>
	<table>
		<tr>
			<th><fmt:message key="name" bundle="${labels}"/></th>
			<th><fmt:message key="shortDescription" bundle="${labels}"/></th>
			<th><fmt:message key="price" bundle="${labels}"/></th>
			<th><fmt:message key="quantity" bundle="${labels}"/></th>
			<th><fmt:message key="total" bundle="${labels}"/></th>
		</tr>
		<c:forEach var="pair" items="${cartMap}">
		
			<tr>
				<td>${pair.key.pName}</td>
				<td><T:shorttext maxchars="25">${description[pair.key]}</T:shorttext></td>
				<td><fmt:message key="currency" bundle="${labels}"/> <fmt:formatNumber value="${pair.key.priceInEuro}" type="currency" currencySymbol=""/></td>
				<td>${pair.value}</td>
				<td><fmt:message key="currency" bundle="${labels}"/> <fmt:formatNumber value="${pair.key.priceInEuro * pair.value}" type="currency" currencySymbol=""/></td>
		   </tr>
		
		</c:forEach>
			
			<td style="bold" colspan="4"><fmt:message key="totalAmount" bundle="${labels }"/>
			<td style="bold"><fmt:message key="currency" bundle="${labels}"/> <fmt:formatNumber value="${sum}" type="currency" currencySymbol=""/></td>
		
		</tr>
	
	</table>
	<a href="home"><fmt:message key="home" bundle="${labels}"/></a>
	<a href="products"><fmt:message key="products" bundle="${labels}"/></a></br>
<T:copyright since="2008">HiB</T:copyright>
</body>
</html>