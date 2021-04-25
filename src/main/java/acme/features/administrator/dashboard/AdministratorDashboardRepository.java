package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {
	
	@Query("select count (j) from Task j where j.finish = true")
	Integer numberOfFinishTask();
	
	@Query("select count (j) from Task j where j.finish = false")
	Integer numberNotFinishTask();
	
	@Query("select count (j) from Task j where j.publica = true")
	Integer numberOfPublicTask();
	
	@Query("select count (j) from Task j where j.publica = false")
	Integer numberNotPublicTask();
	
//	@Query("select avg (select sum (t.workload) from Task t")
//	Double averegeWorkload();
	
//	@Query("select max (j.workload) from Task j")
//	Integer maxWorkload();
//	
//	@Query("select min (j.workload) from Task j")
//	Integer minWorkload();
//	
	
	
	
	
}
