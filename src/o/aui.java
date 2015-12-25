// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Random;

public abstract class aui
{

    private static final char bFg[] = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final Random bvp = new Random();

    public aui()
    {
    }

    public static boolean isEmpty(CharSequence charsequence)
    {
        return charsequence == null || charsequence.length() == 0;
    }

    public static String _mth0157(int i)
    {
        char ac[] = new char[6];
        for (i = 0; i < 6; i++)
        {
            ac[i] = bFg[bvp.nextInt(71)];
        }

        return new String(ac);
    }

    public static boolean _mth02BF(CharSequence charsequence)
    {
        return charsequence != null && charsequence.length() > 0;
    }

}
