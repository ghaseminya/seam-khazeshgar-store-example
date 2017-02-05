package com.jboss.dvd.seam;
import java.io.Serializable;
public class MailBean implements Serializable{
	 
    private String mail,sub,text;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
 
}