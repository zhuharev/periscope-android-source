// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            FF6A, aed

final class ael
    implements Runnable
{

    private aed bhH;

    ael(aed aed1)
    {
        bhH = aed1;
        super();
    }

    public final void run()
    {
        FF6A._mth02CB("RTMP", "5000 seconds of onStop have elapsed, ending broadcast.");
        aed._mth02CA(bhH, false);
    }
}
