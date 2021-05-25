package acme.testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class AnonymousShoutTest extends AcmePlannerTest {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/shoutList.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void listShout(final int recordIndex, final String moment, final String author, final String text) {		
		
		super.clickOnMenu("Anonymous", "Shout List");		
		
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/createShout.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void create(final String author, final String text, final String info) {		
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "Shout!");
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info",info);
		super.clickOnSubmitButton("Shout!");
		super.checkSimplePath("/master/welcome");
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/createShoutN.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void createNegative(final String author, final String text, final String info) {
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "Shout!");
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		super.clickOnSubmitButton("Shout!");
		super.checkSimplePath("/anonymous/shout/create");
		
	}
	
}