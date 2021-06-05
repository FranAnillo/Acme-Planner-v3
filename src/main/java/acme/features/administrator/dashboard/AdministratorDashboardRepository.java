package acme.features.administrator.dashboard;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.workplans.Workplan;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {
	
	@Query("select 1.0 * count(j) from Workplan j where j.finish = 1")
	Double numberOfFinishWorkplan();
	
	@Query("select 1.0 * count(j) from Workplan j where j.finish = 0")
	Double numberOfNotFinishWorkplan();
	
	@Query("select 1.0 * count(j) from Workplan j where j.publica = 1")
	Double numberOfPublicWorkplan(); 
	
	@Query("select 1.0 * count(j) from Workplan j where j.publica = 0")
	Double numberOfPrivateWorkplan();
	
	@Query("select min (j.workload) from Workplan j")
	Integer minWorkload();

	@Query("select max (j.workload) from Workplan j")
	Integer maxWorkload();
	
	@Query("select avg (j.workload) from Workplan j")
	Double averegeWorkload();
	
	@Query("select stddev(j.workload) from Workplan j")
	Double deviationWorkload();
	
	@Query("select j from Workplan j")
	Collection<Workplan> findWorkplans();

}
