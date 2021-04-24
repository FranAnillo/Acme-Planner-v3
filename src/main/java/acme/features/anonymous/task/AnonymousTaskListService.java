package acme.features.anonymous.task;

import java.sql.Date;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

public class AnonymousTaskListService  implements AbstractListService<Anonymous, Task> {
	
	// Internal state
	
		@Autowired
		private AnonymousTaskRepository repository;

		
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
			assert request != null;
			
			Collection<Task> res;
			
			final Date date = new Date(System.currentTimeMillis());   
			
			res = this.repository.findMany(date);
			
			return res;
		}
		
		

}
