package com.jboss.dvd.seam;

import java.util.Properties;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.async.Asynchronous;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * @author dobermai
 */
@Name("longProcess")
@AutoCreate
public class LongProcess {
    private MailBean mail;
 
    @Asynchronous //Remember, this must be asynchronous, because it must run in the background
    public void startProcess(MailBean progress) {
 
        this.mail = progress;
        runProcess();
    }
    
    private void runProcess() {
 
    //Here we shold do our long

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("khazeshgar@gmail.com", "aminmxglx00%");
            }
        });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("khazeshgar@gmail.com"));
                message.setHeader("Content-Type", "text/plain; charset=UTF-8");
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(mail.getMail()));
                message.setSubject(mail.getSub());
                
                
                //text=new String(text.getBytes("ISO8859_1"), "UTF-8");
                message.setContent(mail.getText(), "text/html;charset=UTF-8");

                Transport.send(message);
                
                System.out.println("Done");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
    
    }
}