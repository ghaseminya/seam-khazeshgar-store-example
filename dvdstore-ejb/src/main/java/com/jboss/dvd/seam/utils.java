package com.jboss.dvd.seam;
import com.ghasemkiani.util.icu.PersianCalendar;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.ULocale;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;
import org.jboss.seam.annotations.Name;
import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
@Name("utils")
public class utils implements Serializable{
	public String persiandate(Date d){
        if(d == null)
            return "بسته خریداری نشده.";
        calendar.setTime( d);
        SimpleDateFormat sds =(SimpleDateFormat)calendar.getDateTimeFormat(DateFormat.MEDIUM,DateFormat.NONE,uLocale);
        //date=sds.format(calendar.getTime());
        return sds.format(calendar.getTime());
    }
	ULocale  uLocale = new ULocale("fa_IR");
    TimeZone timeZone = TimeZone.getTimeZone(TimeZone.getDefault().getID());
    PersianCalendar calendar = new PersianCalendar( uLocale);
}
