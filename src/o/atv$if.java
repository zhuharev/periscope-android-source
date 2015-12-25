// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            atv

public static final class .String extends Enum
{

    public static final bEm bEi;
    public static final bEm bEj;
    public static final bEm bEk;
    public static final bEm bEl;
    public static final bEm bEm;
    private static final bEm bEn[];

    public static .String valueOf(String s)
    {
        return (.String)Enum.valueOf(o/atv$if, s);
    }

    public static .String[] values()
    {
        return (.String[])bEn.clone();
    }

    static 
    {
        bEi = new <init>("Hero", 0);
        bEj = new <init>("Broadcast", 1);
        bEk = new <init>("NothingLive", 2);
        bEl = new <init>("RecentFirst", 3);
        bEm = new <init>("Recent", 4);
        bEn = (new bEn[] {
            bEi, bEj, bEk, bEl, bEm
        });
    }

    private .String(String s, int i)
    {
        super(s, i);
    }
}
