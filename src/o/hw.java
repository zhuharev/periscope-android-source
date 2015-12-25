// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package o:
//            ix, ip, iq, iy, 
//            iw, iu

final class hw
    implements ix, ip
{

    private final DateFormat FV;
    private final DateFormat FW;
    private final SimpleDateFormat FX;

    hw()
    {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public hw(int i, int j)
    {
        this(DateFormat.getDateTimeInstance(i, j, Locale.US), DateFormat.getDateTimeInstance(i, j));
    }

    hw(String s)
    {
        this(((DateFormat) (new SimpleDateFormat(s, Locale.US))), ((DateFormat) (new SimpleDateFormat(s))));
    }

    private hw(DateFormat dateformat, DateFormat dateformat1)
    {
        FV = dateformat;
        FW = dateformat1;
        FX = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        FX.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    private Date _mth02CA(iq iq1)
    {
        DateFormat dateformat = FW;
        dateformat;
        JVM INSTR monitorenter ;
        Date date = FW.parse(iq1._mth04AE());
        dateformat;
        JVM INSTR monitorexit ;
        return date;
_L1:
        date = FV.parse(iq1._mth04AE());
        dateformat;
        JVM INSTR monitorexit ;
        return date;
_L2:
        date = FX.parse(iq1._mth04AE());
        dateformat;
        JVM INSTR monitorexit ;
        return date;
        ParseException parseexception;
        parseexception;
        throw new iy(iq1._mth04AE(), parseexception);
        iq1;
        dateformat;
        JVM INSTR monitorexit ;
        throw iq1;
        parseexception;
          goto _L1
        parseexception;
          goto _L2
    }

    private iw _mth02CA(Date date)
    {
        DateFormat dateformat = FW;
        dateformat;
        JVM INSTR monitorenter ;
        date = new iw(FV.format(date));
        dateformat;
        JVM INSTR monitorexit ;
        return date;
        date;
        throw date;
    }

    public final Object deserialize$140ae884(iq iq1, Type type, _cls141F.if if1)
    {
        if (!(iq1 instanceof iw))
        {
            throw new iu("The date should be a string value");
        }
        iq1 = _mth02CA(iq1);
        if (type == java/util/Date)
        {
            return iq1;
        }
        if (type == java/sql/Timestamp)
        {
            return new Timestamp(iq1.getTime());
        }
        if (type == java/sql/Date)
        {
            return new java.sql.Date(iq1.getTime());
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append(getClass()).append(" cannot deserialize to ").append(type).toString());
        }
    }

    public final iq serialize$117eb95b(Object obj, Type type, _cls141F.if if1)
    {
        return _mth02CA((Date)obj);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(o/hw.getSimpleName());
        stringbuilder.append('(').append(FW.getClass().getSimpleName()).append(')');
        return stringbuilder.toString();
    }
}
