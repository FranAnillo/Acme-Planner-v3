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
		request.unbind(entity, model, "numberOfPublicTask", "numberOfPrivateTask", "numberOfFinishTask");
		
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;
		
		Dashboard result;
		final Double numberOfPublicTask;
		final Double numberOfPrivateTask;
		final Double numberOfFinishTask;
		
		numberOfPublicTask = this.repository.numberOfPublicTask();
		numberOfPrivateTask = this.repository.numberOfPrivateTask();
		numberOfFinishTask = this.repository.numberOfFinishTask();
		
		result = new Dashboard();
		result.setNumberOfPublicTask(numberOfPublicTask);
		result.setNumberOfPrivateTask(numberOfPrivateTask);
		result.setNumberOfFinishTask(numberOfFinishTask);
		
		return result;
		
	}

//	@Override
//	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
//		assert request != null;
//		assert entity != null;
//		assert model != null; 
//		
//		request.unbind(entity, model, "numberPublicTask" , "numberPrivateTask" , 
//			"numberFinishTask" , "numberNotFinishTask" );
//		
//	}
//
//	@Override
//	public Dashboard findOne(final Request<Dashboard> request) {
//		assert request != null;
//
//		Dashboard result;
//		
//		Double numberPublicTask;
//		final Integer numberPrivateTask;
//		final Integer numberFinishTask;
//		final Integer numberNotFinishTask;
////		final Double averegeExcutionPeriods;
////		final Double deviationExcutionPeriods;
////		final Integer minmumExecutionPeriod;
////		final Integer maximumExecutionPeriod;
////		
////		final Double averegeWorkloads;
////		final Double deviationWorkloads;
////		final Integer minmumWorkloads;
////		final Integer maximumWorkloads;
////		
//		numberPublicTask = this.repository.numberOfPublicTask();
////		numberPrivateTask = this.repository.numberNotPublicTask();
////		numberFinishTask = this.repository.numberOfFinishTask();
////		numberNotFinishTask = this.repository.numberNotFinishTask();
////		averegeExcutionPeriods = this.repository.;
////		deviationExcutionPeriods = this.repository.;
////		minmumExecutionPeriod = this.repository.;
////		maximumExecutionPeriod = this.repository.;
//		
////		averegeWorkloads = this.repository.averegeWorkload();
////		deviationWorkloads = this.repository;
////		minmumWorkloads = this.repository.minWorkload();
////		maximumWorkloads = this.repository.maxWorkload();
//		
//		result = new Dashboard();
//		result.setNumberPublicTask(numberPublicTask);
////		result.setNumberFinishTask(numberFinishTask);
////		result.setNumberNotFinishTask(numberNotFinishTask);
////		result.setNumberPrivateTask(numberPrivateTask);
////		result.setAveregeWorkloads(averegeWorkloads);
////		result.setMinmumWorkloads(minmumWorkloads);
////		result.setMaximumWorkloads(maximumWorkloads);
//		
//		return result;
//	}
	
	

}
