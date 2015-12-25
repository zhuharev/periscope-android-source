// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            atj, aui

public abstract class atw
{

    static final atw bEo = new atj(null, null, null);

    atw()
    {
    }

    public static atj _mth02BD(String s, String s1, String s2)
    {
        return new atj(s, s1, s2);
    }

    public abstract String gb();

    public abstract String gd();

    public abstract String ge();

    public String toString()
    {
        String s = gd();
        String s1 = ge();
        String s2 = gb();
        if (aui._mth02BF(s) && aui._mth02BF(s1) && aui._mth02BF(s2))
        {
            return (new StringBuilder()).append(s).append(", ").append(s1).append(" ").append(s2).toString();
        }
        if (aui._mth02BF(s) && aui._mth02BF(s1))
        {
            return (new StringBuilder()).append(s).append(", ").append(s1).toString();
        }
        if (aui._mth02BF(s) && aui._mth02BF(s2))
        {
            return (new StringBuilder()).append(s).append(", ").append(s2).toString();
        }
        if (aui._mth02BF(s2))
        {
            return s2;
        } else
        {
            return "";
        }
    }

}
