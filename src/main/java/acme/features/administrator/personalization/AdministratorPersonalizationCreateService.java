//package acme.features.administrator.personalization;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import acme.entities.personalization.Personalization;
//import acme.features.manager.workplan.ManagerWorkplanRepository;
//import acme.framework.components.Errors;
//import acme.framework.components.Model;
//import acme.framework.components.Request;
//import acme.framework.entities.Administrator;
//import acme.framework.services.AbstractCreateService;
//
//@Service
//public class AdministratorPersonalizationCreateService implements AbstractCreateService<Administrator, Personalization>{
//
//	@Autowired
//	protected ManagerWorkplanRepository repository;
//	
//	@Override
//	public boolean authorise(final Request<Personalization> request) {
//		assert request != null;
//
//		return true;
//	}
//
//	@Override
//	public void bind(final Request<Personalization> request, final Personalization entity, final Errors errors) {
//		assert request != null;
//		assert entity != null;
//		assert errors != null;
//		
//		request.bind(entity, errors);
//		
//	}
//
//	@Override
//	public void unbind(final Request<Personalization> request, final Personalization entity, final Model model) {
//		assert request != null;
//		assert entity != null;
//		assert model != null;
//
//		
//		request.unbind(entity, model, "word", "umbral");
//		
//	}
//
//	@Override
//	public Personalization instantiate(final Request<Personalization> request) {
//		assert request != null;
//		Personalization result;
//		
//		result = new Personalization();
//		final List<String> censoredWords= new ArrayList<>();
//		result.setCensoredWords(censoredWords);
//		return null;
//	}
//
//	@Override
//	public void validate(final Request<Personalization> request, final Personalization entity, final Errors errors) {
//		assert request != null;
//		assert entity != null;
//		assert errors != null;
//		
//	}
//
//	@Override
//	public void create(final Request<Personalization> request, final Personalization entity) {
//		assert request != null;
//		assert entity != null;
//		
//		this.repository.save(entity);
//		
//	}
//	
//
//}
