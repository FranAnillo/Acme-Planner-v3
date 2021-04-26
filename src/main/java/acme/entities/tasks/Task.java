package acme.entities.tasks;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task extends DomainEntity {
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@NotBlank
	@Max(80)
	protected String title;
	
	@NotBlank
	@Max(500)
	protected String description;
	
//	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	protected LocalDateTime start;
	
//	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	protected LocalDateTime end;
	
	@URL
	protected String link;
	
	@NotNull
	protected Boolean finish;
	
	@NotNull
	protected Boolean publica;
	
	
	protected Integer workload() {
		Integer diferencia=0;
		if (this.start.isAfter(LocalDateTime.now())) {
			diferencia=this.end.compareTo(this.start);
		} else if (this.start.isBefore(LocalDateTime.now())) {
			diferencia=this.end.compareTo(LocalDateTime.now());
		} else if (this.end.isBefore(LocalDateTime.now())){
			diferencia=0;
		}
		return diferencia;
		
		
	}
}
