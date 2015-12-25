// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class yb extends Enum
{

    public static final yb aUl;
    public static final yb aUm;
    public static final yb aUn;
    private static final yb aUo[];

    private yb(String s, int i)
    {
        super(s, i);
    }

    public static yb valueOf(String s)
    {
        return (yb)Enum.valueOf(o/yb, s);
    }

    public static yb[] values()
    {
        return (yb[])aUo.clone();
    }

    static 
    {
        aUl = new yb("JOINED", 0);
        aUm = new yb("PARTED", 1);
        aUn = new yb("REJOINED", 2);
        aUo = (new yb[] {
            aUl, aUm, aUn
        });
    }
}
