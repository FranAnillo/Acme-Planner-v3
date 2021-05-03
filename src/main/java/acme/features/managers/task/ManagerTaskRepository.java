package acme.features.managers.task;

import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ManagerTaskRepository extends AbstractRepository {

	void save(Task task);
	
//	@Query("select task from Task task where task.manager.id=?1")
//	Collection<Task> findMany(int idManager);
	
}
