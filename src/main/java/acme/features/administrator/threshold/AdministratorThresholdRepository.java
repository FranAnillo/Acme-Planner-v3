package acme.features.administrator.threshold;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.threshold.Threshold;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorThresholdRepository extends AbstractRepository{

	@Query("select t from Threshold t where t.id = ?1")
	Threshold findThreshold(int i);
	
	@Query("select t.threshold from Threshold t where t.id = ?1")
	int findThresholdById(int i);

}
