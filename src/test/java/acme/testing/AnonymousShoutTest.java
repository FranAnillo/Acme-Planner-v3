package acme.testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.framework.helpers.StringHelper;

public class AnonymousShoutTest extends AcmePlannerTest {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/shoutList.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void listShout(final int recordIndex, final String moment, final String author, final String text, final String enlace) {		
		
		super.clickOnMenu("Anonymous", "Shout List");		
		
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
//		super.checkColumnHasValue(recordIndex, 3, enlace);
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/createShout.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void create(final String author, final String text, final String enlace) {		
		assert !StringHelper.isBlank(author);
		assert !StringHelper.isBlank(text);
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "Shout!");
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("enlace", enlace);
		super.clickOnSubmitButton("Shout!");
		super.checkSimplePath("/master/welcome");
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/createShoutN.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)	
	public void createNegative(final String author, final String text, final String enlace) {
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "Shout!");
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		//super.fillInputBoxIn("enlace", enlace);
		super.clickOnSubmitButton("Shout!");
		super.checkSimplePath("/anonymous/shout/create");
		
	}
	
}