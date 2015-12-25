// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class aua extends Enum
{

    public static final aua bEp;
    public static final aua bEq;
    public static final aua bEr;
    public static final aua bEs;
    private static final aua bEt[];

    private aua(String s, int i)
    {
        super(s, i);
    }

    public static aua valueOf(String s)
    {
        return (aua)Enum.valueOf(o/aua, s);
    }

    public static aua[] values()
    {
        return (aua[])bEt.clone();
    }

    static 
    {
        bEp = new aua("Unknown", 0);
        bEq = new aua("LowLatency", 1);
        bEr = new aua("TooFull", 2);
        bEs = new aua("OnlyFriends", 3);
        bEt = (new aua[] {
            bEp, bEq, bEr, bEs
        });
    }
}
