// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            aug

public static final class bFd extends Enum
{

    public static final bFb bEY;
    public static final bFb bEZ;
    public static final bFb bFa;
    public static final bFb bFb;
    private static final bFb bFe[];
    public final int bFc;
    public final long bFd;
    public final long duration;

    public static tring valueOf(String s)
    {
        return (tring)Enum.valueOf(o/aug$02CA, s);
    }

    public static tring[] values()
    {
        return (tring[])bFe.clone();
    }

    static 
    {
        bEY = new <init>("None", 0, 0L, 0L);
        bEZ = new <init>("Heart", 1, 200L, 30000L);
        bFa = new <init>("Channel", 2, 300L, 15000L);
        bFb = new <init>("Join", 3, 10L, 0L);
        bFe = (new bFe[] {
            bEY, bEZ, bFa, bFb
        });
    }

    private tring(String s, int i, long l, long l1)
    {
        super(s, i);
        duration = l;
        if (l > 0L)
        {
            bFc = (int)(l1 / l);
        } else
        {
            bFc = 0;
        }
        if (l1 > 0L)
        {
            bFd = l1;
            return;
        } else
        {
            bFd = 0L;
            return;
        }
    }
}
