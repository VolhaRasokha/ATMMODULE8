package bo;

public class EmailUtils {
	private static final String MAIL_TO_ADDRESS = "vra_atmmodule6@mail.ru";
	private static long currentKey = System.currentTimeMillis();
	private static final String SUBJECT = "TestSubject" + currentKey;
	private static final String TEXT_BODY = "TestTextBody" + currentKey;
	
	public static Email getDefaultEmail() {
		Email email= new Email ();
		email.setMailToAdress(MAIL_TO_ADDRESS);
		email.setSubject(SUBJECT);
		email.setTextBody(TEXT_BODY);
		return email;
	}

}
