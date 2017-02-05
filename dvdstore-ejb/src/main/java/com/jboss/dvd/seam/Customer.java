/*
 * JBoss, Home of Professional Open Source
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */ 
package com.jboss.dvd.seam;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;
import org.jboss.seam.annotations.Name;

@Entity
@Name("customer")
@DiscriminatorValue("customer")
public class Customer
    extends User
    implements Serializable
{
    private static final long serialVersionUID = 5699525147178760355L;

    String  address1;
    

    String  email;
    String  phone;

    


    public Customer() {
    }


    @Column(name="ADDRESS1",length=50)
    @NotNull
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    
    @Column(name="EMAIL",length=50)
    @Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="PHONE",length=50)
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }


    

    

    @Override
    public String toString() {
        return "Customer#" + getId() + "(" + userName + ")";
    }

}
