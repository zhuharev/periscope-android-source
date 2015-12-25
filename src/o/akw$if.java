// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            akw

public static final class .String extends Enum
{

    public static final brd brb;
    public static final brd brc;
    public static final brd brd;
    private static final brd bre[];

    public static .String valueOf(String s)
    {
        return (.String)Enum.valueOf(o/akw$if, s);
    }

    public static .String[] values()
    {
        return (.String[])bre.clone();
    }

    static 
    {
        brb = new <init>("Live", 0);
        brc = new <init>("Replay", 1);
        brd = new <init>("Mixed", 2);
        bre = (new bre[] {
            brb, brc, brd
        });
    }

    private .String(String s, int i)
    {
        super(s, i);
    }
}
