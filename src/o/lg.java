// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package o:
//            jd, lh, mt, mq, 
//            ms, iy

public final class lg extends jd
{

    public static final lh Im = new lh();
    private final SimpleDateFormat Il = new SimpleDateFormat("hh:mm:ss a");

    public lg()
    {
    }

    private void _mth02CA(mt mt1, Time time)
    {
        this;
        JVM INSTR monitorenter ;
        if (time == null)
        {
            time = null;
            break MISSING_BLOCK_LABEL_20;
        }
        time = Il.format(time);
        mt1._mth1421(time);
        this;
        JVM INSTR monitorexit ;
        return;
        mt1;
        throw mt1;
    }

    private Time _mth02CF(mq mq1)
    {
        this;
        JVM INSTR monitorenter ;
        if (mq1._mth13A2() != ms.JO)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        mq1.nextNull();
        this;
        JVM INSTR monitorexit ;
        return null;
        mq1 = new Time(Il.parse(mq1.nextString()).getTime());
        this;
        JVM INSTR monitorexit ;
        return mq1;
        mq1;
        throw new iy(mq1);
        mq1;
        this;
        JVM INSTR monitorexit ;
        throw mq1;
    }

    public final Object read(mq mq1)
    {
        return _mth02CF(mq1);
    }

    public final void write(mt mt1, Object obj)
    {
        _mth02CA(mt1, (Time)obj);
    }

}
