package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable{
	
	protected static final long	serialVersionUID	= 1L;
	

	Double averageExecutionPeriods;
	Double deviationExcutionPeriods;
	Double minimumExecutionPeriods;
	Double maximumExecutionPeriods;



	Double numberOfPublicWorkplan;
	Double numberOfPrivateWorkplan;
	Double numberOfFinishWorkplan;
	Double numberOfNotFinishWorkplan;
	
	Integer minimumWorkload;
	Integer maximumWorkload;
	Double averageWorkload;
	Double deviationWorkload;
	
}
