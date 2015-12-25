// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            yq, yr, ys, yt

public static abstract class g.String extends Enum
    implements yq
{

    private static yr aVZ;
    private static ys aWa;
    private static yt aWb;
    private static final aWb aWc[];

    public static g.String valueOf(String s)
    {
        return (g.String)Enum.valueOf(o/yq$if, s);
    }

    public static g.String[] values()
    {
        return ([])aWc.clone();
    }

    static 
    {
        aVZ = new yr("development", 0);
        aWa = new ys("canary", 1);
        aWb = new yt("production", 2);
        aWc = (new aWc[] {
            aVZ, aWa, aWb
        });
    }

    private g.String(String s, int i)
    {
        super(s, i);
    }

    g.String(String s, int i, byte byte0)
    {
        this(s, i);
    }
}
