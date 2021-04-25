package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard>{

	@Autowired
	protected AdministratorDashboardRepository repository;
	
	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null; 
		
		request.unbind(entity, model, "numberPublicTask" , "numberPrivateTask" , 
			"numberFinishTask" , "numberNotFinishTask", "averageExecutionPeriods" , "deviationExecutionPeriods" ,
			"minimumExecutionPeriod" , "maximumExecutionPeriod" , "averageWorkloads" , "deviationWorkloads" ,
			"minimumWorkloads" , "maximumWorkloads");
		
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result;
		
		Integer numberPublicTask;
		Integer numberPrivateTask;
		Integer numberFinishTask;
		Integer numberNotFinishTask;
		final Double averegeExcutionPeriods;
		final Double deviationExcutionPeriods;
		final Integer minmumExecutionPeriod;
		final Integer maximumExecutionPeriod;
		
		final Double averegeWorkloads;
		final Double deviationWorkloads;
		final Integer minmumWorkloads;
		final Integer maximumWorkloads;
		
		numberPublicTask = this.repository.numberOfPublicTask();
		numberPrivateTask = this.repository.numberNotPublicTask();
		numberFinishTask = this.repository.numberOfFinishTask();
		numberNotFinishTask = this.repository.numberNotFinishTask();
//		averegeExcutionPeriods = this.repository.;
//		deviationExcutionPeriods = this.repository.;
//		minmumExecutionPeriod = this.repository.;
//		maximumExecutionPeriod = this.repository.;
		
//		averegeWorkloads = this.repository.averegeWorkload();
//		deviationWorkloads = this.repository;
//		minmumWorkloads = this.repository.minWorkload();
//		maximumWorkloads = this.repository.maxWorkload();
		
		result = new Dashboard();
		result.setNumberPublicTask(numberPublicTask);
		result.setNumberFinishTask(numberFinishTask);
		result.setNumberNotFinishTask(numberNotFinishTask);
		result.setNumberPrivateTask(numberPrivateTask);
//		result.setAveregeWorkloads(averegeWorkloads);
//		result.setMinmumWorkloads(minmumWorkloads);
//		result.setMaximumWorkloads(maximumWorkloads);
		
		return result;
	}
	
	

}
