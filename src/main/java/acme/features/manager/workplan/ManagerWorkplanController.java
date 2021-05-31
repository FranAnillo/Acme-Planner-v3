package acme.features.manager.workplan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Manager;
import acme.entities.workplans.Workplan;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/manager/workplan/")
public class ManagerWorkplanController extends AbstractController<Manager, Workplan> {

}
