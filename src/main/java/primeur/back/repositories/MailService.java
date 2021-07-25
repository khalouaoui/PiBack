package primeur.back.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(String userMail) throws MailException {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(userMail);
		mail.setSubject("Invitation à un évènement ");
		mail.setText(
				"Vous avez été assigné à un évènement par votre entreprise, Consultez notre plateforme pour avoir les détails. Merci ");
		javaMailSender.send(mail);

	}

}
