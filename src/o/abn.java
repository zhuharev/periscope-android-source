// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            nx, abm, acd, iq

final class abn extends nx
{

    private String MG;
    private acd bcr;
    private boolean bcs;

    abn(String s, acd acd, boolean flag)
    {
        MG = s;
        bcr = acd;
        bcs = flag;
        super();
    }

    public final void _mth02CA(String s, iq iq)
    {
        (new StringBuilder("setState successCallback ")).append(iq);
        abm._mth02CA(MG, bcr, bcs);
        abm._mth1D52(MG);
    }
}
