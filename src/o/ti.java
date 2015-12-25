// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            th

public final class ti
    implements th
{

    private final long Tc;
    private final int Td;

    public ti(long l)
    {
        this(1000L, 2);
    }

    public ti(long l, int i)
    {
        Tc = l;
        Td = i;
    }

    public final long _mth1D65(int i)
    {
        return (long)((double)Tc * Math.pow(Td, i));
    }
}
