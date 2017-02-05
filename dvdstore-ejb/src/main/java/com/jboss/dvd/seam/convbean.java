package com.jboss.dvd.seam;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import com.jboss.dvd.seam.Register.mailer;
 
/**
 * @author dobermai
 */
@Name("conversationBean")
@Scope(ScopeType.CONVERSATION)
public class convbean {
    
    @In
    LongProcess longProcess;
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

	@Begin(join = true) //We must start a new conversation here!
    public void startProcess() {
        /*Set all the relevant parameters for the long running task. The value parameter is shared between the task and this bean. If we want to pass parameters to the long running task, we can set them on the progressBean */ 
        
        String text1="پیام شما با موفقیت ارسال شد، متن پیام:<br/>"+text;
    	String text2="name:"+name+"<br/>mail="+mail+"<br/>phone:"+phone+"<br/>"+text;
        
        MailBean mBean1 = new MailBean();
        MailBean mBean2 = new MailBean();
        mBean1.setMail("admin@khazeshgar.ir");
        mBean1.setText(text2);
        mBean1.setSub("ارسال درخواست");
        mBean2.setMail(mail);
        mBean2.setText(text1);
        mBean2.setSub("درخواست شما با موفقیت ارسال شد.");
        longProcess.startProcess(mBean1);
        longProcess.startProcess(mBean2);//Here we start our long running task in the background
    }
 
    
}