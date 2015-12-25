// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.Serializable;

// Referenced classes of package o:
//            iq, kd, is, iw

public final class it extends iq
{

    public final kd GC = new kd();

    public it()
    {
    }

    public static iq _mth02CA(Serializable serializable)
    {
        if (serializable == null)
        {
            return is.GB;
        } else
        {
            return new iw(serializable);
        }
    }

    public final boolean equals(Object obj)
    {
        return obj == this || (obj instanceof it) && ((it)obj).GC.equals(GC);
    }

    public final int hashCode()
    {
        return GC.hashCode();
    }

    public final void _mth02BD(String s, String s1)
    {
        if (s1 == null)
        {
            s1 = is.GB;
        } else
        {
            s1 = new iw(s1);
        }
        Object obj = s1;
        if (s1 == null)
        {
            obj = is.GB;
        }
        GC.put(s, obj);
    }
}
