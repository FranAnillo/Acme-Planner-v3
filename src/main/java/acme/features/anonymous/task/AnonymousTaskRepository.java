package acme.features.anonymous.task;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

public interface AnonymousTaskRepository extends AbstractRepository {

	@Query("SELECT task FROM Task task WHERE task.id = ?1")
	Task findOneById(int id);
	
	//PARA SELECCIONAR LAS TAREAS PÚBLICAS Y NO ESTÁN TERMINADAS
	@Query("SELECT task FROM Task task WHERE (task.isPublic = true AND task.end > :date) ")
	Collection<Task> findMany(Date date);

}
