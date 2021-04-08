<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.shout.form.lable.author" path="author"/>
	<acme:form-textarea code="anonymous.shout.form.lable.text" path="text"/>
	<acme:form-textbox code="anonymous.shout.form.lable.moment" path="moment"/>
	
	<acme:form-submit code="anonymous.shout.code.form.buttom.create" action="anonymous/shout/create"/>
	<acme:form-return code="anonymous.shout.code.form.buttom.return"/>
</acme:form>