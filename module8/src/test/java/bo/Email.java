package bo;

public class Email {
	
	private String mailToAdress;
	private String subject;
	private String textBody;
	
	public Email(){
		this.setMailToAdress(mailToAdress);
		this.setSubject(subject);
		this.setTextBody(textBody);
	}

	public String getMailToAdress() {
		return mailToAdress;
	}

	public void setMailToAdress(String mailToAdress) {
		this.mailToAdress = mailToAdress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}
	


}
