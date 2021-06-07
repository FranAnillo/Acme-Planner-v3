package acme.features.administrator.threshold;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.threshold.ThresholdBannedWords;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorThresholdRepository extends AbstractRepository{

	@Query("select t from ThresholdBannedWords t where t.id = ?1")
	ThresholdBannedWords findThreshold(int i);
	
	@Query("select t.threshold from ThresholdBannedWords t")
	int findThresholdById();

}
