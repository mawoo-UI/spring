package cokr.oneweeks.demotest.utils;

// import jakarta.mail.Address;
// import jakarta.mail.Authenticator;
// import jakarta.mail.Message;
// import jakarta.mail.MessagingException;
// import jakarta.mail.PasswordAuthentication;
// import jakarta.mail.Session;
// import jakarta.mail.Transport;
// import jakarta.mail.internet.AddressException;
// import jakarta.mail.internet.InternetAddress;
// import jakarta.mail.internet.MimeMessage;

public class MailSender {
	private static final String ENCODE = "utf-8";
	
	public static void main(String[] args) {
		// Session session = new MailSender().init();
		// String rndText = String.format("%08d", (int)(Math.random() * 100000000));
		// System.out.println(rndText);
		// send(session, "메일발송테스트", "내용맨" + rndText, "hanjutun@gmail.com");
	}
	
	// public Session init() {
		// Properties props = new Properties();
		// Properties authProps = new Properties();
		
		// try {
		// 	props.load(getClass().getClassLoader().getResourceAsStream("mail.properties"));
		// 	authProps.load(getClass().getClassLoader().getResourceAsStream("mail_auth.properties"));
		// } catch (IOException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// }
		// Session session = Session.getInstance(props, new Authenticator() {

		// 	@Override
		// 	protected PasswordAuthentication getPasswordAuthentication() {
		// 		// TODO Auto-generated method stub
		// 		return new PasswordAuthentication(authProps.getProperty("username"), authProps.getProperty("password"));
		// 	}
			
		// });
		// return session;
	// }
	
	// public static void send(Session session, String title, String content, String... to) {
		// Message msg = new MimeMessage(session);
		// try {
		// 	InternetAddress address = new InternetAddress("admin@javaman.shop", "관리자", ENCODE);
		// 	msg.setFrom(address);
		// 	msg.addRecipients(Message.RecipientType.TO, convertToInternetAddressArray(to));
		// 	msg.setSubject(title);
		// 	msg.setContent(content, "text/html; charset=" + ENCODE);
			
		// 	Transport.send(msg);
		// } catch (UnsupportedEncodingException | MessagingException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// }
		
		
	}
	// public static Address[] convertToInternetAddressArray(String[] emailAddresses) {
    //     InternetAddress[] internetAddresses = new InternetAddress[emailAddresses.length];
        
    //     for (int i = 0; i < emailAddresses.length; i++) {
    //         try {
    //             internetAddresses[i] = new InternetAddress(emailAddresses[i]);
    //         } catch (AddressException e) {
    //             System.out.println("Invalid email address: " + emailAddresses[i]);
    //             e.printStackTrace();
    //         }
    //     }
        
    //     return internetAddresses;
    // }
// }