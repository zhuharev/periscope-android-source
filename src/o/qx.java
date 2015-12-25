// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class qx extends Enum
{

    public static final qx Qs;
    public static final qx Qt;
    public static final qx Qu;
    public static final qx Qv;
    private static final qx Qw[];

    private qx(String s, int i)
    {
        super(s, i);
    }

    public static qx valueOf(String s)
    {
        return (qx)Enum.valueOf(o/qx, s);
    }

    public static qx[] values()
    {
        return (qx[])Qw.clone();
    }

    static 
    {
        Qs = new qx("PostThread", 0);
        Qt = new qx("MainThread", 1);
        Qu = new qx("BackgroundThread", 2);
        Qv = new qx("Async", 3);
        Qw = (new qx[] {
            Qs, Qt, Qu, Qv
        });
    }
}
