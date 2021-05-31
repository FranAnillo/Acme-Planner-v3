package acme.entities.workplans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Workplan extends DomainEntity {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;
	
	// Attributes -------------------------------------------------------------
	
	@NotNull
	protected String title;
	
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
