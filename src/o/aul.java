// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.IOException;

// Referenced classes of package o:
//            auj

public abstract class aul
{

    public aul()
    {
    }

    public static void _mth02BE(String s, String s1)
    {
        if (auj.bFh != null)
        {
            auj.bFh._mth05D9(s, s1);
        }
    }

    public static void _mth02BF(String s, String s1)
    {
        if (auj.bFh != null)
        {
            auj.bFh._mth0674(s, s1);
        }
    }

    public static void _mth02CA(String s, String s1)
    {
        if (auj.bFh != null)
        {
            auj.bFh._mth1D35(s, s1);
        }
    }

    public static void _mth02CA(String s, String s1, IOException ioexception)
    {
        if (auj.bFh != null)
        {
            auj.bFh._mth141D(s, s1, ioexception);
        }
    }

    public static void _mth02CA(String s, String s1, IllegalStateException illegalstateexception)
    {
        if (auj.bFh != null)
        {
            auj.bFh._mth02BC(s, s1, illegalstateexception);
        }
    }

    public static void _mth02CA(String s, String s1, Throwable throwable)
    {
        if (auj.bFh != null)
        {
            auj.bFh._mth02BB(s, s1, throwable);
        }
    }

    public static void _mth02CE(String s, String s1)
    {
        if (auj.bFh != null)
        {
            auj.bFh._mth1D4E(s, s1);
        }
    }

    public abstract void _mth02BB(String s, String s1, Throwable throwable);

    public abstract void _mth02BC(String s, String s1, Throwable throwable);

    public abstract void _mth05D9(String s, String s1);

    public abstract void _mth0674(String s, String s1);

    public abstract void _mth141D(String s, String s1, Throwable throwable);

    public abstract void _mth1D35(String s, String s1);

    public abstract void _mth1D4E(String s, String s1);
}
