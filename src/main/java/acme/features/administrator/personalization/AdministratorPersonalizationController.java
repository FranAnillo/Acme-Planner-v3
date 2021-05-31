package acme.features.administrator.personalization;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrator/personalization/")
public class AdministratorPersonalizationController {

	@PostConstruct
	protected void initialise() {
		
	}
}
