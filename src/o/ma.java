// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Calendar;
import java.util.GregorianCalendar;

// Referenced classes of package o:
//            jd, mq, ms, mt

final class ma extends jd
{

    ma()
    {
    }

    public final Object read(mq mq1)
    {
        if (mq1._mth13A2() == ms.JO)
        {
            mq1.nextNull();
            return null;
        }
        mq1.beginObject();
        int k1 = 0;
        int j1 = 0;
        int i1 = 0;
        int l = 0;
        int j = 0;
        int k = 0;
        do
        {
            if (mq1._mth13A2() == ms.JJ)
            {
                break;
            }
            String s = mq1.nextName();
            int i = mq1.nextInt();
            if ("year".equals(s))
            {
                k1 = i;
            } else
            if ("month".equals(s))
            {
                j1 = i;
            } else
            if ("dayOfMonth".equals(s))
            {
                i1 = i;
            } else
            if ("hourOfDay".equals(s))
            {
                l = i;
            } else
            if ("minute".equals(s))
            {
                j = i;
            } else
            if ("second".equals(s))
            {
                k = i;
            }
        } while (true);
        mq1.endObject();
        return new GregorianCalendar(k1, j1, i1, l, j, k);
    }

    public final void write(mt mt1, Object obj)
    {
        obj = (Calendar)obj;
        if (obj == null)
        {
            mt1._mth14F7();
            return;
        } else
        {
            mt1._mth14A9();
            mt1._mth141F("year");
            mt1._mth02BE(((Calendar) (obj)).get(1));
            mt1._mth141F("month");
            mt1._mth02BE(((Calendar) (obj)).get(2));
            mt1._mth141F("dayOfMonth");
            mt1._mth02BE(((Calendar) (obj)).get(5));
            mt1._mth141F("hourOfDay");
            mt1._mth02BE(((Calendar) (obj)).get(11));
            mt1._mth141F("minute");
            mt1._mth02BE(((Calendar) (obj)).get(12));
            mt1._mth141F("second");
            mt1._mth02BE(((Calendar) (obj)).get(13));
            mt1._mth14F6();
            return;
        }
    }
}
