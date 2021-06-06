<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.shout.list.label.moment" path="moment" width="15%"/>
	<acme:list-column code="anonymous.shout.list.label.author" path="author" width="15%"/>
	<acme:list-column code="anonymous.shout.list.label.text" path="text" width="40%"/>
	<acme:list-column code="anonymous.shout.list.label.info" path="info" width="30%"/>
</acme:list>