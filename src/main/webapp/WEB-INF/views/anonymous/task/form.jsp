<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="taskId"/>

	<acme:form-textbox code="anonymous.task.label.reference" path="reference" readonly="true"/>
	<jstl:if test="${command == 'show'}">
		<acme:form-textbox code="anonymous.task.label.title" path="title"/>
		<acme:form-textbox code="anonymous.task.label.description" path="description"/>
	</jstl:if>	
	<acme:form-textarea code="anonymous.task.label.workload" path="workload" />
	<acme:form-textarea code="anonymous.task.start" path="start"/>
	<acme:form-textarea code="worker.application.label.end" path="end"/>	
	<acme:form-textarea code="worker.application.label.link" path="link"/>			
	<acme:form-textarea code="worker.application.label.period" path="period"/>		
		
	<acme:form-return code="worker.application.button.return"/>	
</acme:form>

