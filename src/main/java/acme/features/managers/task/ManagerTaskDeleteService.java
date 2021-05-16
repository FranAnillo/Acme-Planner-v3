package acme.features.managers.task;

//public class ManagerTaskDeleteService implements AbstractDeleteService<Manager,Task>{
//	// Internal state ---------------------------------------------------------
//
//		@Autowired
//		protected ManagerTaskRepository repository;
//
//	@Override
//	public boolean authorise(final Request<Task> request) {
//		assert request != null;
//		
//		final boolean result;
//		int taskId;
//		Task task;
//		Manager manager;
//		final Principal principal;
//		
//		taskId = request.getModel().getInteger("id");
//		task = this.repository.findOneTaskById(taskId);
//		manager = task.getManager();
//		principal = request.getPrincipal();
//		result= manager.getUserAccount().getId() == principal.getAccountId();
//		
//		return result;
//	}
//
//	@Override
//	public void bind(final Request<Task> request, final Task entity, final Errors errors) {
//		assert request != null;
//		assert entity != null;
//		assert errors != null;
//
//		request.bind(entity, errors);
//	}
//
//	@Override
//	public void unbind(final Request<Task> request, final Task entity, final Model model) {
//		assert request != null;
//		assert entity != null;
//		assert model != null;
//		
//		request.unbind(entity, model, "title", "description", "start", "end");
//		request.unbind(entity, model, "link", "publica", "finish", "workload");
//
//	}
//
//	@Override
//	public Task findOne(final Request<Task> request) {
//		assert request != null;
//		
//		Task result;
//		int id;
//		
//		id = request.getModel().getInteger("id");
//		result= this.repository.findOneTaskById(id);
//		return result;
//	}
//
//	@Override
//	public void validate(final Request<Task> request, final Task entity, final Errors errors) {
//		assert request != null;
//		assert entity != null;
//		assert errors != null;
//	}
//
//	@Override
//	public void delete(final Request<Task> request, final Task entity) {
//		assert request != null;
//		assert entity != null;
//
//		this.repository.delete(entity);
//	}
//
//}
