/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jboss.dvd.seam;

import static java.lang.ProcessBuilder.Redirect.to;
import java.util.Properties;
import java.util.concurrent.Callable;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ejb.Stateless;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.In;
/**
 *
 * @author mohammadghasemy
 */
@Stateless
@Name("register")
public class Register {

    @In
    TaskManager taskManager;
    public TaskManager getTaskManager() {
        return taskManager;
    }

    public void setTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }
    String mail,text,sub;
    String name,phone;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void submit() {
        // ...
    	String text1="پیام شما با موفقیت ارسال شد، متن پیام:<br/>"+text;
    	String text2="mail="+mail+"<br/>phone:"+phone+"<br/>"+text;
        taskManager.submit(new mailer("ارسال درخواست","admin@khazeshgar.ir",text2));
        taskManager.submit(new mailer("درخواست شما با موفقیت ارسال شد.",mail,text1));
        // You might want to hold the return value in some Future<Result>, but
        // you should store it in view or session scope in order to get result
        // later. Note that the thread will block whenever you call get() on it.
        // You can just ignore it altogether (as the current example is doing).
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
    public  class mailer
        implements Callable {
    private String sub;
    String mail,test;
            
    public mailer(String s,String m,String t) {
      this.sub=s;
      this.mail=m;
      this.test=t;
    }
    public Integer call() {
        
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
                return new PasswordAuthentication("khazeshgar@gmail.com", "XXXXX");
            }
        });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("sender.tejaratiran@gmail.com"));
                message.setHeader("Content-Type", "text/plain; charset=UTF-8");
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(mail));
                message.setSubject(sub);
                
                
                //text=new String(text.getBytes("ISO8859_1"), "UTF-8");
                message.setContent(text, "text/html;charset=UTF-8");

                Transport.send(message);
                
                System.out.println("Done");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
    
      return 1;//Integer.valueOf(word.length());
    }
  }
}

