package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ScreenShooter;
import pages.AccountPage;
import pages.CreateEmailPage;
import pages.DraftPage;

public class MailCreationTest extends TestBase {

	private static final String EXPECTED_ACCOUNT_ICON = "vra_atmmodule5@mail.ru"; 
	private static final int EMAIL_INDEX_NUMBER = 0;
	
	@Test(description = "Login to mail.ru", groups={"test_1"})
	public void mailRuLoginTest() {
		AccountPage accountPage = emailService.loginToMailRu(firstUser);
		ScreenShooter.takeScreenshot();
		Assert.assertTrue(accountPage.isEmailPresentOnPage(EXPECTED_ACCOUNT_ICON), "User is not login!");
	}
	
	@Test(description = "Mail creation", dependsOnMethods = { "mailRuLoginTest" }, groups={"test_1"})
	public void mailRuMailCreationTest(){
		AccountPage accountPage = new AccountPage(driver);	
		
		CreateEmailPage mailCreationPage = accountPage.clickMailCreationBtn();

		mailCreationPage.fillMailAddress(email.getMailToAdress());
		mailCreationPage.fillMailSubject(email.getSubject());
		mailCreationPage.fillMailBody(email.getTextBody());
		mailCreationPage.clickSaveDraftBtn();
		
		DraftPage draftPage = accountPage.clickMailDraftMenuLink();
		String actualSubject = draftPage.getDraftMailSubject(EMAIL_INDEX_NUMBER);
		Assert.assertEquals(actualSubject,email.getSubject());
		
		draftPage.openDraftMail(0);
		String actualMailToAddress =  mailCreationPage.getMailToAddress();
		ScreenShooter.takeScreenshot();
		Assert.assertEquals(actualMailToAddress,email.getMailToAdress() + ",");	
		Assert.assertTrue(mailCreationPage.isMailBodyEnable(email.getTextBody()),"Required text body has not been found");
	}

}
