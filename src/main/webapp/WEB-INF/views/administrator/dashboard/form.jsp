<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<h2>
	<acme:message code="administrator.dashboard.form.title.general-indicators"/>
</h2> 

<table class="table table-sm">
	<caption>
		<acme:message code="administrator.dashboard.form.title.general-indicators"/>
	</caption>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.number-of-public-task"/>
		</th>
		<td>
			<acme:print value="${numberOfPublicTask}"/>
		</td>
	</tr>
	 <tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.number-of-private-task"/>
		</th>
		<td>
			<acme:print value="${numberOfPrivateTask}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.number-of-finish-task"/>
		</th>
		<td>
			<acme:print value="${numberOfFinishTask}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.number-of-not-finish-task"/>
		</th>
		<td>
			<acme:print value="${numberOfNotFinishTask}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minimum-workload"/>
		</th>
		<td>
			<acme:print value="${minimumWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maximum-workload"/>
		</th>
		<td>
			<acme:print value="${maximumWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.average-workload"/>
		</th>
		<td>
			<acme:print value="${averageWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.deviation-workload"/>
		</th>
		<td>
			<acme:print value="${deviationWorkload}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.average-execution-periods"/>
		</th>
		<td>
			<acme:print value="${averageExecutionPeriods}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maximum-execution-periods"/>
		</th>
		<td>
			<acme:print value="${maximumExecutionPeriods}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minimum-execution-periods"/>
		</th>
		<td>
			<acme:print value="${minimumExecutionPeriods}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.deviation-execution-periods"/>
		</th>
		<td>
			<acme:print value="${deviationExcutionPeriods}"/>
		</td>
	</tr>
						
 </table>

<h2>
	<acme:message code="administrator.dashboard.form.title.application-statuses"/>
</h2>

<div>
	<canvas id="canvas"></canvas>
</div> 

<script type="text/javascript">
	$(document).ready(function() {
		var options = {
			scales : {
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			}
		};
	
		var canvas, context;
	
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "bar",
			data : data,
			options : options
		});
	});
</script> 