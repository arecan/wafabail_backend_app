package services.impl;


import javax.mail.*;
import javax.mail.internet.*;

import dtos.ContactDto;
import dtos.EmailDto;
import org.osgi.service.component.annotations.Component;
import services.EmailingService;


import javax.mail.internet.InternetAddress;
import java.util.Properties;

@Component(
        service = {EmailingServiceImpl.class, EmailingService.class }
)
public class EmailingServiceImpl implements EmailingService {

    public void envoyerEmail(EmailDto emailDto) {
        final String username = "projet.nacera@gmail.com";
        final String password = "drge rnaf zflg skyb"; // mot de passe d'application Gmail

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        javax.mail.Session session = javax.mail.Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailDto.getEmail()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("projet.nacera@gmail.com")
            );
            message.setSubject(emailDto.getObjet());

            // Corps HTML
            String htmlBody = String.format(
                    "<html><body>" +
                            "<h2 style='color:#2c3e50;'>Nouveau message de contact</h2>" +
                            "<p><strong>Nom :</strong> %s</p>" +
                            "<p><strong>Prenom :</strong> %s</p>" +
                            "<p><strong>Telephone :</strong> %s</p>" +
                            "<p><strong>Email :</strong> %s</p>" +
                            "<p><strong>Message :</strong></p>" +
                            "<div style='border:1px solid #ccc;padding:10px;background:#f9f9f9;'>%s</div>" +
                            "</body></html>",
                    emailDto.getNom(),
                    emailDto.getPrenom(),
                    emailDto.getTelephone(),
                    emailDto.getEmail(),
                    emailDto.getMessage().replace("\n", "<br>")
            );

            message.setContent(htmlBody, "text/html; charset=utf-8");

            Transport.send(message);

            System.out.println("Email HTML envoyé avec succès");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void envoyerContact(ContactDto contactDto) {
        final String username = "projet.nacera@gmail.com";
        final String password = "drge rnaf zflg skyb"; // mot de passe d'application Gmail

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(username)
            );
            message.setSubject("Nouveau contact depuis le site Wafabail");

            String htmlBody = String.format(
                    "<html><body>" +
                            "<h2>Demande de contact</h2>" +
                            "<p><strong>Nom :</strong> %s</p>" +
                            "<p><strong>Telephone :</strong> %s</p>" +
                            "</body></html>",
                    contactDto.getNom(),
                    contactDto.getTelephone()
            );

            message.setContent(htmlBody, "text/html; charset=utf-8");

            Transport.send(message);

            System.out.println("Email de contact (nom/téléphone) envoyé avec succès");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
