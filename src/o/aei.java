// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            FF6A, aed

final class aei
    implements Runnable
{

    private aed bhH;

    aei(aed aed1)
    {
        bhH = aed1;
        super();
    }

    public final void run()
    {
        FF6A._mth02CB("RTMP", "RTMP Setup complete");
        if (aed._mth1D35(bhH))
        {
            aed._mth02CA(bhH, true, 0x7f06006e, aed._mth1D4E(bhH));
        }
    }
}
