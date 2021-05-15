package acme.features.managers.task;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ManagerTaskRepository extends AbstractRepository {
	
	

	
//@Query("select task from Task task where task.manager.id=?1")
//Collection<Task> findMany(int idManager);
//
//@Query("select w from Manager w where w.userAccount.id = ?1")
//Manager findOneManagerByUserAccountId(int id);

@Query("select p from Provider p where p.userAccount.id = ?1")
Manager findOneProviderByUserAccountId(int id);

@Query("select ua from UserAccount ua where ua.id = ?1")
Manager findOneManagerbyUserAccountById(int id);

@Query("select tasks from Task where tasks.manager.id =?1")
List<Task> findManyTasksByManager(int workerId);

@Query("select p from Task p where p.id= ?1")
Task findOneTaskById(int taskId);
}
