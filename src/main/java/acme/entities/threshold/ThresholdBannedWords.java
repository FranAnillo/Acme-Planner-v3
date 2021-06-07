package acme.entities.threshold;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ThresholdBannedWords extends DomainEntity{
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Positive
	Integer threshold;

	

}
