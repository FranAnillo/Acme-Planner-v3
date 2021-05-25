package acme.testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ManagerCreateTask extends AcmePlannerTest {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/task.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void create(final String title, final String description,final String workload,final String start, final String end, final String link) {		
		super.signIn("manager1", "manager1");
		super.clickOnMenu("Manager", "Create Task");		
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("workload",workload);
		super.fillInputBoxIn("start",start);
		super.fillInputBoxIn("end",end);
		super.fillInputBoxIn("workload",workload);
		super.fillInputBoxIn("link",link);
		super.clickOnSubmitButton("Create");
		super.checkSimplePath("/manager/task");
		super.signOut();
	}

}
