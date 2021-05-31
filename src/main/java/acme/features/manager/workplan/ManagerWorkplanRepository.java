package acme.features.manager.workplan;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.workplans.Workplan;
import acme.framework.entities.Manager;
import acme.framework.repositories.AbstractRepository;

public interface ManagerWorkplanRepository extends AbstractRepository {
	
	@Query("select w from Workplan w where w.manager.user.id = ?1")
	Collection<Workplan> findWorkplansByUserAccountById(int id);
	
	@Query("select m from Manager m where m.id = ?1")
	Manager findOneManagerbyUserAccountById(int id);
	
	@Query("select w from Workplan w where w.id= ?1")
	Workplan findOneTaskById(int workplanId);
	
	@Query("select w from Workplan w")
	Collection<Workplan> findMany();
}
