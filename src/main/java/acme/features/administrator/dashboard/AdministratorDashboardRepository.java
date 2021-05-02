package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {
	
	@Query("select 1.0 * count(j) from Task j where j.finish = 1")
	Double numberOfFinishTask();
//	
//	@Query("select count (j) from Task j where j.finish = 0")
//	Integer numberNotFinishTask();
	
	@Query("select 1.0 * count(j) from Task j where j.publica = 1")
	Double numberOfPublicTask(); 
	
	@Query("select 1.0 * count(j) from Task j where j.publica = 0")
	Double numberOfPrivateTask();
	


	
//	@Query("select avg (select sum (t.workload) from Task t")
//	Double averegeWorkload();
	
//	@Query("select max (j.workload) from Task j")
//	Integer maxWorkload();
//	
//	@Query("select min (j.workload) from Task j")
//	Integer minWorkload();
//	
	
	
	
	
		
	
	
	
}
