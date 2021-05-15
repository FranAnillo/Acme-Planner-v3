package acme.features.managers.task;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.filter.Filter;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ManagerTaskCreateService implements AbstractCreateService<Manager, Task> {
	
	// Internal state 

		@Autowired
		protected ManagerTaskRepository repository;


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

			request.unbind(entity, model, "title", "description", "link");
		}

		@Override
		public Task instantiate(final Request<Task> request) {
			assert request != null;

			Task result;
			final Date start;
			final Date end;

//			start =Date.valueOf( LocalDateTime.of(2021, Month.MAY, 2, 10, 0));
//			end = LocalDateTime.of(2021, Month.MAY, 8, 14, 0);

			result = new Task();
			result.setTitle("Task 1");
			result.setDescription("Description of the taks 2");
//			result.setStart(start);
//			result.setEnd(end);
			result.setLink("http://example.org");
			result.setPublica(true);
			result.setFinish(false);
			
			return result;
		}

		@Override
		public void validate(final Request<Task> request, final Task entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;

		}

		@Override
		public void create(final Request<Task> request, final Task entity) {
			assert request != null;
			assert entity != null;
			if ((Filter.filterString(entity.getDescription())&&Filter.filterString(entity.getTitle()))==false) {
			
			}
			else {
			final Date start;
			final Date end;

//			start = Date.UTC(2021, 5, 2, 10, 0);
//			end = Date.UTC(2021, 5.MAY, 8, 14, 0);
			
//			entity.setStart(start);
//			entity.setEnd(end);
			entity.setPublica(true);
			entity.setFinish(false);
			this.repository.save(entity);
			}
		}
			
	
	
	
	

}
