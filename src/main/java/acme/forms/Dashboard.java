package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable{
	
	protected static final long	serialVersionUID	= 1L;
	
//	Double numberPublicTask;
//	Integer numberPrivateTask;
//	Double numberFinishTask;
//	Integer numberNotFinishTask;
//	Double averegeExcutionPeriods;
//	Double deviationExcutionPeriods;
//	Integer minmumExecutionPeriod;
//	Integer maximumExecutionPeriod;
//	
//	Double averegeWorkloads;
//	Double deviationWorkloads;
//	Integer minmumWorkloads;
//	Integer maximumWorkloads;

	Double numberOfPublicTask;
	Double numberOfPrivateTask;
	Double numberOfFinishTask;
	

}
