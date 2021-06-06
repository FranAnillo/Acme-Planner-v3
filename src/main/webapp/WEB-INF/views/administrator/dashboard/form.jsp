<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<h2>
	<acme:message
		code="administrator.dashboard.form.title.general-indicators" />
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

<acme:form-submit code="administrator.personalization.form.button.create"
		action="/administrator/personalization/create" />
<%-- =======
<acme:form readonly="true">
	<acme:form-double
		code="administrator.dashboard.form.label.number-of-public-task"
		path="numberOfPublicTask" />
	<acme:form-double
		code="administrator.dashboard.form.label.number-of-private-task"
		path="numberOfPrivateTask" />
	<acme:form-double
		code="administrator.dashboard.form.label.number-of-finish-task"
		path="numberOfFinishTask" />
	<acme:form-integer
		code="administrator.dashboard.form.label.number-of-not-finish-task"
		path="numberOfNotFinishTask" />
	<acme:form-integer
		code="administrator.dashboard.form.label.minimum-workload"
		path="minimumWorkload" />
	<acme:form-integer
		code="administrator.dashboard.form.label.maximum-workload"
		path="maximumWorkload" />
	<acme:form-double
		code="administrator.dashboard.form.label.average-workload"
		path="averageWorkload" />
	<acme:form-double
		code="administrator.dashboard.form.label.deviation-workload"
		path="deviationWorkload" />
	<acme:form-double
		code="administrator.dashboard.form.label.average-execution-periods"
		path="averageExecutionPeriods" />
</acme:form>
--%>

<h2>
	<acme:message code="administrator.dashboard.form.graph.publicTask" />
</h2>
<div>
	<canvas id="canvas"></canvas>
</div>
<script type="text/javascript">
	//Grafica de tareas publicas y privadas
	$(document).ready(function() {

		var data = {
			labels : [
					"Public Task", "Private Task", "Total Task"
			],
			datasets : [
				{
					data : [
							"${numberOfPublicTask}", "${numberOfPrivateTask}","${numberOfPublicTask+numberOfPrivateTask}"
					],
					backgroundColor : [
							"#0074D9", "#FF4136", "#2ECC40", "#FF851B"
					]
				}
			]
		};

		var options = {
			scales : {
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 50.0
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
