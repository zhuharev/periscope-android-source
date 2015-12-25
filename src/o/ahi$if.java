// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ahi

public static final class blA extends Enum
{

    private static final blx blB[];
    public static final blx blu;
    public static final blx blv;
    public static final blx blw;
    public static final blx blx;
    public final boolean blA;
    public final boolean bly;
    public final boolean blz;

    public static .String valueOf(String s)
    {
        return (.String)Enum.valueOf(o/ahi$if, s);
    }

    public static .String[] values()
    {
        return (.String[])blB.clone();
    }

    static 
    {
        blu = new <init>("Subscribe", 0, false, true, true);
        blv = new <init>("Replay", 1, true, false, false);
        blw = new <init>("AutoReplay", 2, true, true, false);
        blx = new <init>("Summary", 3, true, false, true);
        blB = (new blB[] {
            blu, blv, blw, blx
        });
    }

    private .String(String s, int i, boolean flag, boolean flag1, boolean flag2)
    {
        super(s, i);
        bly = flag;
        blz = flag1;
        blA = flag2;
    }
}
