package acme.entities.workplans;

import java.time.LocalDateTime;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import acme.entities.tasks.Task;
import acme.framework.entities.DomainEntity;
import acme.framework.entities.Manager;

public class Workplan extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;
	
	// Attributes -------------------------------------------------------------
	
	@NotNull
	protected String Title;
	
	@NotNull
	protected Boolean finish;
	
	@NotNull
	protected Boolean publica;
	
	@Future                       
	@NotNull                      
	protected LocalDateTime start;
	
	@Future                     
	@NotNull                    
	protected LocalDateTime end;
	
	@NotNull                   
	protected Integer workload;
	
	// Relationships ----------------------------------------------------------
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Manager manager;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Task task;
}
