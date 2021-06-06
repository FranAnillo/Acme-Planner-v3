<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="workplan.list.label.title" path="title"/>
	<acme:form-textbox code="workplan.list.label.start" path="start"/>
	<acme:form-textbox code="workplan.list.label.end" path="end"/>
    <acme:form-checkbox code="workplan.list.label.publica" path="publica"/>
	<acme:form-submit code="workplan.form.button.create" action="/workplan/create"/>
  	<acme:form-return code="workplan.form.button.return"/>
  	<acme:form-submit code="workplan.form.button.delete" action="/workplan/delete"/>

</acme:form>