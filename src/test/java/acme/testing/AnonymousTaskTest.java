package acme.testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AnonymousTaskTest extends AcmePlannerTest{
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/task/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void AnonymousTaskListPositive(final int recordIndex, final String title, 
		final String description, final String start,final String end, final String link,final String publica,final String finish,
		final String workload) {		
				
		super.clickOnMenu("Anonymous", "Tasks");		
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, description);
		super.checkColumnHasValue(recordIndex, 2, start);
		super.checkColumnHasValue(recordIndex, 3, end);
		super.checkColumnHasValue(recordIndex, 4, workload);

		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("title", title);	
		super.checkInputBoxHasValue("description",description);	
		super.checkInputBoxHasValue("start",start);
		super.checkInputBoxHasValue("end",end);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("publica", publica);
		super.checkInputBoxHasValue("finish",finish);
		super.checkInputBoxHasValue("workload",workload);

		super.signOut();
		
	}
	

}
