// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class nk
{

    public final double LA;
    public final double LB;
    public final double Lw;
    public final double Lx;
    public final double Ly;
    public final double Lz;

    public nk(double d, double d1, double d2, double d3)
    {
        Lw = d;
        Lx = d2;
        Ly = d1;
        Lz = d3;
        LA = (d + d1) / 2D;
        LB = (d2 + d3) / 2D;
    }

    public final boolean _mth02CA(double d, double d1)
    {
        return Lw <= d && d <= Ly && Lx <= d1 && d1 <= Lz;
    }
}
