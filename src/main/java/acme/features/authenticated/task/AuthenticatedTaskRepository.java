package acme.features.authenticated.task;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

public interface AuthenticatedTaskRepository extends AbstractRepository {
	
	@Query("SELECT task FROM Task task WHERE task.id = ?1")
	Task findOneById(int id);
	
	//PARA SELECCIONAR LAS TAREAS PÚBLICAS Y TERMINADAS
	@Query("SELECT task FROM Task task WHERE (task.isPublic = true AND task.end < :date) ")
	Collection<Task> findMany(Date date);


}
