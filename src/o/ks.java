// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package o:
//            jd, kt, mt, iy, 
//            mq, ms

public final class ks extends jd
{

    public static final kt HL = new kt();
    private final DateFormat FV;
    private final DateFormat FW = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat HM;

    public ks()
    {
        FV = DateFormat.getDateTimeInstance(2, 2, Locale.US);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        HM = simpledateformat;
    }

    private void _mth02CA(mt mt1, Date date)
    {
        this;
        JVM INSTR monitorenter ;
        if (date != null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        mt1._mth14F7();
        this;
        JVM INSTR monitorexit ;
        return;
        mt1._mth1421(FV.format(date));
        this;
        JVM INSTR monitorexit ;
        return;
        mt1;
        throw mt1;
    }

    private Date FB39(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Date date = FW.parse(s);
        this;
        JVM INSTR monitorexit ;
        return date;
_L1:
        date = FV.parse(s);
        this;
        JVM INSTR monitorexit ;
        return date;
_L2:
        date = HM.parse(s);
        this;
        JVM INSTR monitorexit ;
        return date;
        ParseException parseexception;
        parseexception;
        throw new iy(s, parseexception);
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        parseexception;
          goto _L1
        parseexception;
          goto _L2
    }

    public final Object read(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        } else
        {
            return FB39(mq1.nextString());
        }
    }

    public final void write(mt mt1, Object obj)
    {
        _mth02CA(mt1, (Date)obj);
    }

}
