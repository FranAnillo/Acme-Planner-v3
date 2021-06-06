package acme.testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AdministratorThresholdTest extends AcmePlannerTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/personalization/thresholdPositive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void updateThresholdPositive(final String length, final String title, final String description, final String workload,
		final String start, final String end, final String link) {
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Account", "Become a manager");
		super.clickOnSubmitButton("Register");
		super.clickOnMenu("Administrator", "Word threshold");
		super.fillInputBoxIn("Word length", length);
		super.clickOnSubmitButton("Add");
		super.clickOnMenu("Manager", "Create Task");
		super.fillInputBoxIn("Title", title);
		super.fillInputBoxIn("Description", description);
		super.fillInputBoxIn("Workload", workload);
		super.fillInputBoxIn("Start", start);
		super.fillInputBoxIn("End", end);
		super.fillInputBoxIn("Link", link);
		super.clickOnSubmitButton("Create");
		
	}	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/personalization/thresholdNegative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void updateThresholdNegative(final String length, final String title, final String description, final String workload,
		final String start, final String end, final String link) {
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Word threshold");
		super.fillInputBoxIn("Word length", length);
		super.clickOnSubmitButton("Add");
		super.clickOnMenu("Manager", "Create Task");
		super.fillInputBoxIn("Title", title);
		super.fillInputBoxIn("Description", description);
		super.fillInputBoxIn("Workload", workload);
		super.fillInputBoxIn("Start", start);
		super.fillInputBoxIn("End", end);
		super.fillInputBoxIn("Link", link);
		super.clickOnSubmitButton("Create");
		super.checkErrorsExist();
			
	}	
}
