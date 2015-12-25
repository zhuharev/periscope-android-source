// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class FC60 extends Enum
{

    public static final FC60 lT;
    public static final FC60 lU;
    private static FC60 lV;
    public static final FC60 lW;
    private static final FC60 lX[];

    private FC60(String s, int i)
    {
        super(s, i);
    }

    public static FC60 valueOf(String s)
    {
        return (FC60)Enum.valueOf(o/FC60, s);
    }

    public static FC60[] values()
    {
        return (FC60[])lX.clone();
    }

    static 
    {
        lT = new FC60("ALWAYS_ARGB_8888", 0);
        lU = new FC60("PREFER_ARGB_8888", 1);
        lV = new FC60("PREFER_RGB_565", 2);
        lX = (new FC60[] {
            lT, lU, lV
        });
        lW = lV;
    }
}
