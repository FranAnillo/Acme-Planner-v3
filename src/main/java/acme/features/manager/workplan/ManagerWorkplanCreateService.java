package acme.features.manager.workplan;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.workplans.Workplan;
import acme.features.administrator.personalization.AdministratorPersonalizationRepository;
import acme.features.administrator.threshold.AdministratorThresholdRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ManagerWorkplanCreateService implements AbstractCreateService<Manager, Workplan> {
	
	// Internal state 

		@Autowired
		protected ManagerWorkplanRepository repository;

		@Autowired
		protected AdministratorPersonalizationRepository personalizationRepository;

		@Autowired
		protected AdministratorThresholdRepository thresholdRepository;

		@Override
		public boolean authorise(final Request<Workplan> request) {
			assert request != null;

			return true;
		}

		@Override
		public void bind(final Request<Workplan> request, final Workplan entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;

			request.bind(entity, errors);
		}

		@Override
		public void unbind(final Request<Workplan> request, final Workplan entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "title","start","end","workload");
		}

		@Override
		public Workplan instantiate(final Request<Workplan> request) {
			assert request != null;

			Workplan result;
			Manager manager;
			manager=this.repository.findOneManagerbyUserAccountById(request.getPrincipal().getActiveRoleId());
			result= new Workplan();
			result.setManager(manager);
			return result;
		}

		@Override
		public void validate(final Request<Workplan> request, final Workplan entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;
			
			if (!errors.hasErrors("title")) {
				errors.state(request, this.filterString(entity.getTitle()), "title", "manager.workplan.form.error.title");
			}
			
			if(!errors.hasErrors("start") && !errors.hasErrors("end")) {
				final LocalDateTime today = LocalDateTime.now();
				errors.state(request, entity.getStart().isAfter(today), "start", "manager.workplan.form.error.start");
			}
			
			if(!errors.hasErrors("start") && !errors.hasErrors("end")) {
				errors.state(request, entity.getEnd().isAfter(entity.getStart()), "end", "manager.workplan.form.error.end");
			}

			if (!errors.hasErrors("workload")) {
//				errors.state(request, entity.getWorkload() < Filter.calculate(entity.getStart().getYear(), entity.getEnd().getHour()), "workload", "manager.workplan.error.workload");
			}
			
		}

		private boolean filterString(final String s) {
			final String j=s.replace(" ", ";");
	        final int number = j.split(";").length;
	        final String[] palabras=j.split(";");
	        float numberBannedWords= 0;
	        final List<String> censoredWords= this.personalizationRepository.findCensoredWords();
	        for(int i = 0; censoredWords.size()>i; i++) {
	        	for(int k=0; palabras.length>k;k++) {
	        		if(palabras[k].toLowerCase().equals(censoredWords.get(i))) {
	        			numberBannedWords= numberBannedWords+1;
	        }
		}
	}
	        if((numberBannedWords*100/number)> this.thresholdRepository.findThresholdById(6)) return false;

	        return true;
		}

		@Override
		public void create(final Request<Workplan> request, final Workplan entity) {
			assert request != null;
			assert entity != null;
			this.repository.save(entity);
			
		}
}
