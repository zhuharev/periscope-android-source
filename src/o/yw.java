// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Comparator;

// Referenced classes of package o:
//            yx, yy, yz, za, 
//            zb

abstract class yw extends Enum
    implements Comparator
{

    public static final yx aWl;
    private static yy aWm;
    private static yz aWn;
    private static za aWo;
    private static zb aWp;
    static yw aWq[];
    private static final yw aWr[];

    private yw(String s, int i)
    {
        super(s, i);
    }

    yw(String s, int i, byte byte0)
    {
        this(s, i);
    }

    public static yw valueOf(String s)
    {
        return (yw)Enum.valueOf(o/yw, s);
    }

    public static yw[] values()
    {
        return (yw[])aWr.clone();
    }

    static 
    {
        aWl = new yx("Time", 0);
        aWm = new yy("Featured", 1);
        aWn = new yz("Live", 2);
        aWo = new za("Trusted", 3);
        aWp = new zb("Score", 4);
        aWr = (new yw[] {
            aWl, aWm, aWn, aWo, aWp
        });
        aWq = (new yw[] {
            aWl, aWp, aWm, aWn
        });
    }
}
