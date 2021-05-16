package acme.features.managers.task;
import java.util.Collection;

import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class ManagerTaskListService implements AbstractListService<Manager, Task> {

	@Override
	public boolean authorise(final Request<Task> request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Task> findMany(final Request<Task> request) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Autowired
//	private ManagerTaskRepository repository;
//
//	@Override
//	public boolean authorise(final Request<Task> request) {
//		assert request != null;
//		
//		return true;
//	}
//
//	@Override
//	public void unbind(final Request<Task> request, final Task entity, final Model model) {
//		assert request != null;
//		assert entity != null;
//		assert model != null;
//		
//		request.unbind(entity, model, "title", "start", "end", "workload");
//		
//	}
//
//	@Override
//	public Collection<Task> findMany(final Request<Task> request) {
//		assert request != null;		
//		
//		Collection<Task> result;
//		int workerId;
//
//		workerId = request.getPrincipal().getActiveRoleId();
//		result = this.repository.findManyTasksByManager(workerId);
//		
//		return result;
//	}
//

}

