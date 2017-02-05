/*
 * JBoss, Home of Professional Open Source
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */ 
package com.jboss.dvd.seam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERLINES")
public class OrderLine
    implements Serializable
{
    private static final long serialVersionUID = 207236100660985541L;

    long    lineId;
    int     position;
    Product product;
    int     quantity;
    
    
    boolean panel;
    boolean registerer;
    String timeneeded;
    
    
    @Column(name="PANEL",nullable=true)
    public boolean isPanel() {
		return panel;
	}
	public void setPanel(boolean panel) {
		this.panel = panel;
	}
	@Column(name="REGISTERER",nullable=true)
	public boolean isRegisterer() {
		return registerer;
	}
	public void setRegisterer(boolean registerer) {
		this.registerer = registerer;
	}
	@Column(name="TIMENEEDED",nullable=true)
	public String getTimeneeded() {
		return timeneeded;
	}
	public void setTimeneeded(String timeneeded) {
		this.timeneeded = timeneeded;
	}
	String crsite;
    String crdesc;
    String crout;
    @Column(name="CRSITE",nullable=true)
    public String getCrsite() {
		return crsite;
	}
	public void setCrsite(String crsite) {
		this.crsite = crsite;
	}
	@Column(name="CRDESC",nullable=true)
	public String getCrdesc() {
		return crdesc;
	}
	public void setCrdesc(String crdesc) {
		this.crdesc = crdesc;
	}
	
	@Column(name="CROUT",nullable=true)
	public String getCrout() {
		return crout;
	}
	public void setCrout(String crout) {
		this.crout = crout;
	}
	Date    orderDate;
    Order   order;

    @Id @GeneratedValue
    @Column(name="ORDERLINEID")
    public long getLineId() {
        return lineId;
    }
    public void setLineId(long id) {
        this.lineId = id;
    }

    @Column(name="POS")
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    
    @ManyToOne
    @JoinColumn(name="ORDERID")
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name="PROD_ID",unique=false,nullable=false)
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product=product;
    }

    @Column(name="QUANTITY",nullable=false)
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void addQuantity(int howmany) {
        quantity += howmany;
    }
}
