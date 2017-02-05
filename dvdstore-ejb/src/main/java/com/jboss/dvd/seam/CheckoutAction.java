/*
 * JBoss, Home of Professional Open Source
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */ 
package com.jboss.dvd.seam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.bpm.CreateProcess;
import org.jboss.seam.annotations.security.Restrict;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.faces.FacesMessages;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
@Stateful
@Name("checkout")
public class CheckoutAction
    implements Checkout,
               Serializable
{
    private static final long serialVersionUID = -4651884454184474207L;

    @PersistenceContext
    EntityManager em;

    @In(value="currentUser",required=false)
    Customer customer;

    @In(create=true)
    ShoppingCart cart;

    @Out(scope=ScopeType.CONVERSATION,required=false)
    Order currentOrder;
    @Out(scope=ScopeType.CONVERSATION,required=false)
    Order completedOrder;

    @Out(scope=ScopeType.BUSINESS_PROCESS, required=false)
    long orderId;
    @Out(scope=ScopeType.BUSINESS_PROCESS, required=false)
    BigDecimal amount = BigDecimal.ZERO;
    @Out(value="customer",scope=ScopeType.BUSINESS_PROCESS, required=false)
    String customerName;    

    
    @Begin(nested=true, pageflow="checkout")
    public void createOrder() {
        currentOrder = new Order();

        for (OrderLine line: cart.getCart()) {
            currentOrder.addProduct(em.find(Product.class, line.getProduct().getProductId()),
                                    line.getQuantity(),line.crsite,line.crout,line.timeneeded,line.panel,line.registerer);
        }

        currentOrder.calculateTotals();
        cart.resetCart();       
    }

    @End
    @CreateProcess(definition="OrderManagement", processKey="#{completedOrder.orderId}")
    @Restrict("#{identity.loggedIn}")
    public Order submitOrder() {
        try {
            completedOrder = purchase(customer, currentOrder);
            
            orderId      = completedOrder.getOrderId();
            amount       = completedOrder.getNetAmount();
            customerName = completedOrder.getCustomer().getUserName();
            String text="سلام "+completedOrder.getCustomer().getFirstName()+" عزیز"+"<br/>"+
            		"سفارش جدید شما برای پردازش ارسال شد."+"<br/>"+
            		"مشخصات سفارش درخواستی شما:"+"<br/>"+
            		"تاریخ دریافت سفارش:"+new utils().persiandate(completedOrder.orderDate)+"<br/>"+
            		"تعداد سفارش"+completedOrder.orderLines.size()+"<br/>"+
            		"نوع خروجی مورد نظر:"+completedOrder.orderLines.get(0).crout+"<br/>"+
            		"سایت یا منبع مورد نظر:"+completedOrder.orderLines.get(0).crsite+"<br/>"+
            		"دوره زمانی مدنظر شما"+completedOrder.orderLines.get(0).timeneeded+"<br/>"+
            		"پنل مدیریتی:"+((completedOrder.orderLines.get(0).panel)?"نیازمند پنل مدیریت هستم":"نیازی نیست.")+"<br/>"+
            		"خزشگر ثبات"+((completedOrder.orderLines.get(0).registerer)?"نیازمند ثبات هستم.":"نیازی نیست")+"<br/>"+
            		"";
            sendingmail("ثبت سفارش در خزشگر"+orderId,text,completedOrder.getCustomer().getEmail());
            sendingmail("ثبت سفارش در خزشگر","شماره سفارش:"+orderId+" eamil:"+completedOrder.getCustomer().getEmail(),"admin@khazeshgar.ir");
        } catch (InsufficientQuantityException e) {
            for (Product product: e.getProducts()) {
                Contexts.getEventContext().set("prod", product);
                FacesMessages.instance().addFromResourceBundle("checkoutInsufficientQuantity");
            }
            return null;
        }

        return completedOrder;
    }

    private Order purchase(Customer customer, Order order) 
        throws InsufficientQuantityException
    {
        order.setCustomer(customer);
        order.setOrderDate(new Date());

        List<Product> errorProducts = new ArrayList<Product>();
        for (OrderLine line: order.getOrderLines()) {
            Inventory inv = line.getProduct().getInventory();
            if (!inv.order(line.getQuantity())) {
                errorProducts.add(line.getProduct());
            }
        }

        if (errorProducts.size()>0) {
            throw new InsufficientQuantityException(errorProducts);
        }

        order.calculateTotals();
        em.persist(order);

        return order;
    }

    @Remove
    public void destroy() {}
    
    @In
    LongProcess longProcess;
    public void sendingmail(String sub,String text,String to){
    	
        MailBean mBean1 = new MailBean();
        mBean1.setMail(to);
        mBean1.setText(text);
        mBean1.setSub(sub);
        
        
        longProcess.startProcess(mBean1);
        
    }
}
