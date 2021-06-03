
package acme.features.managers.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.features.administrator.personalization.AdministratorPersonalizationRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ManagerTaskCreateService implements AbstractCreateService<Manager, Task> {

	// Internal state 

	@Autowired
	protected ManagerTaskRepository repository;
	
	@Autowired
	protected AdministratorPersonalizationRepository personalizationRepository;


	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "link","publica");
	}

	@Override
	public Task instantiate(final Request<Task> request) {
		assert request != null;

		Task result;
		Manager manager;
		manager=this.repository.findOneManagerbyUserAccountById(request.getPrincipal().getActiveRoleId());

		result = new Task();
		result.setManager(manager);
		
		return result;
	}

	@Override
	public void validate(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

//		if (!errors.hasErrors("end")) {
//			errors.state(request, entity.getEnd().after(entity.getStart()), "end", "manager.task.error.end");
//		}
//
//		if (!errors.hasErrors("workload")) {
//			errors.state(request, entity.getWorkload() < Filter.calculate(entity.getStart(), entity.getEnd()), "workload", "manager.task.error.workload");
//		}
//		if (!errors.hasErrors("description")) {
//			errors.state(request, this.filterString(entity.getDescription()), "description", "manager.task.form.error.description");
//		}
//		if (!errors.hasErrors("title")) {
//	errors.state(request, this.filterString(entity.getTitle()), "title", "manager.task.form.error.title");
//		}
	}

	@Override
	public void create(final Request<Task> request, final Task entity) {
		assert request != null;
		assert entity != null;
		
			entity.setFinish(false);
			this.repository.save(entity);
		
	}
	
	public boolean filterString(final String s) {
		final String j=s.replace(" ", ";");
		final int number = j.split(";").length;
		int numberBannedWords= 0;
		final List<String> censoredWords= this.personalizationRepository.findCensoredWords();
		for(int i = 0; censoredWords.size()>i; i++) {
		if(s.toLowerCase().contains(censoredWords.get(i))) {
			numberBannedWords= numberBannedWords+1;
		}	
		}
		if(((float)numberBannedWords/number)*100> 10) return false;
		
		return true;
	}
	
}
