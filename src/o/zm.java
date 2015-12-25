// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Comparator;

// Referenced classes of package o:
//            zn, zo

public abstract class zm extends Enum
    implements Comparator
{

    public static final zn aWE;
    private static zo aWF;
    private static final zm aWG[];

    private zm(String s, int i)
    {
        super(s, i);
    }

    zm(String s, int i, byte byte0)
    {
        this(s, i);
    }

    public static zm valueOf(String s)
    {
        return (zm)Enum.valueOf(o/zm, s);
    }

    public static zm[] values()
    {
        return (zm[])aWG.clone();
    }

    static 
    {
        aWE = new zn("MostLoved", 0);
        aWF = new zo("Username", 1);
        aWG = (new zm[] {
            aWE, aWF
        });
    }
}
