// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.io.PrintStream;

// Referenced classes of package o:
//            aul

final class auk extends aul
{

    auk()
    {
    }

    protected final void _mth02BB(String s, String s1, Throwable throwable)
    {
        System.out.printf((new StringBuilder()).append(s).append("/E: %s\n%s\n").toString(), new Object[] {
            s1, throwable
        });
    }

    protected final void _mth02BC(String s, String s1, Throwable throwable)
    {
        _mth02BB(s, s1, throwable);
    }

    protected final void _mth05D9(String s, String s1)
    {
        System.out.printf((new StringBuilder()).append(s).append("/D: %s\n").toString(), new Object[] {
            s1
        });
    }

    protected final void _mth0674(String s, String s1)
    {
        System.out.printf((new StringBuilder()).append(s).append("/V: %s\n").toString(), new Object[] {
            s1
        });
    }

    protected final void _mth141D(String s, String s1, Throwable throwable)
    {
        System.out.printf((new StringBuilder()).append(s).append("/V: %s\n%s\n").toString(), new Object[] {
            s1, throwable
        });
    }

    protected final void _mth1D35(String s, String s1)
    {
        System.out.printf((new StringBuilder()).append(s).append("/E: %s\n").toString(), new Object[] {
            s1
        });
    }

    protected final void _mth1D4E(String s, String s1)
    {
        System.out.printf((new StringBuilder()).append(s).append("/W: %s\n").toString(), new Object[] {
            s1
        });
    }
}
