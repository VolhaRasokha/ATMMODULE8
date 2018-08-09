package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ScreenShooter;
import pages.AccountPage;
import pages.DraftPage;
import pages.IncomingPage;

public class MailSendTest extends TestBase {

	@Test(description = "Mail sending", dependsOnGroups = { "test_1" }, groups = { "test_2" })
	public void mailRuMailSendingTest() {

		AccountPage accountPage = emailService.loginToMailRu(firstUser);

		DraftPage draftPage = accountPage.clickMailDraftMenuLink();

		String actualSubject = draftPage.getDraftMailSubject(0);
		draftPage.getDraftMailBySubject(actualSubject);

		emailService.sendEmail(email);

		accountPage.isElementPresent(AccountPage.mailSentTitle);

		accountPage.refresh();
		accountPage.clickMailDraftMenuLink();

		ScreenShooter.takeScreenshot();
		Assert.assertFalse(draftPage.isEmailPresentOnPage(actualSubject),
				"Email exists in Draft folder");

		accountPage.clickMailSentMenuLink();

		Assert.assertTrue(accountPage.isEmailPresentOnPage(actualSubject),
				"Email does not exist in SENT folder");

		emailService.loginToMailRu(secondUser);
		accountPage.refresh();
		IncomingPage incomingPage = accountPage.clickMailIncomingMenuLink();

		Assert.assertTrue(incomingPage.isEmailPresentOnPage(actualSubject),
				"Email does not exist in Incoming folder");
	}

}
