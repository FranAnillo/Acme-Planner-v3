package acme.features.managers.task;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class ManagerTaskListService implements AbstractListService<Manager, Task> {
	
	@Autowired
	private ManagerTaskRepository repository;

	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "title", "start", "end", "workload");
		
	}

	@Override
	public Collection<Task> findMany(final Request<Task> request) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Collection<Task> findMany(final Request<Task> request) {
//		assert request != null;
//		
//		Collection<Task> lista;
//		Principal principal;
//		
//		principal = request.getPrincipal();
//		lista = this.repository.findMany(principal.getActiveRoleId());
//		return lista;
//	}
}

