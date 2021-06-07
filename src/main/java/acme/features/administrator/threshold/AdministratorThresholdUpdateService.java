package acme.features.administrator.threshold;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.threshold.ThresholdBannedWords;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorThresholdUpdateService implements AbstractUpdateService<Administrator, ThresholdBannedWords>{

	@Autowired
	protected AdministratorThresholdRepository repository;

	@Override
	public boolean authorise(final Request<ThresholdBannedWords> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<ThresholdBannedWords> request, final ThresholdBannedWords entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
		
	}

	@Override
	public void unbind(final Request<ThresholdBannedWords> request, final ThresholdBannedWords entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "threshold");
		
	}

	@Override
	public ThresholdBannedWords findOne(final Request<ThresholdBannedWords> request) {
		assert request != null;
		ThresholdBannedWords threshold;
		threshold= this.repository.findThreshold(6);
		return threshold;
	}

	@Override
	public void validate(final Request<ThresholdBannedWords> request, final ThresholdBannedWords entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void update(final Request<ThresholdBannedWords> request, final ThresholdBannedWords entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
		
	}

}
