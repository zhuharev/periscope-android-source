// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            ja, jb

public abstract class iz extends Enum
{

    public static final ja GE;
    private static jb GF;
    private static final iz GG[];

    private iz(String s, int i)
    {
        super(s, i);
    }

    iz(String s, int i, byte byte0)
    {
        this(s, i);
    }

    public static iz valueOf(String s)
    {
        return (iz)Enum.valueOf(o/iz, s);
    }

    public static iz[] values()
    {
        return (iz[])GG.clone();
    }

    static 
    {
        GE = new ja("DEFAULT", 0);
        GF = new jb("STRING", 1);
        GG = (new iz[] {
            GE, GF
        });
    }
}
