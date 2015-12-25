// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            nx, abm, FF6A, abp, 
//            ql, io, iq, or

static final class bcv extends nx
{

    private String bcv;

    public final void _mth02CA(String s, io io)
    {
        (new StringBuilder("presence connectCallback ")).append(io);
        abm._mth1D58(bcv);
    }

    public final void _mth02CA(String s, iq iq)
    {
    }

    public final void _mth02CA(String s, or or)
    {
        FF6A._mth02CB("RTMP", (new StringBuilder("PubNub presence errorCallback ")).append(or).toString());
    }

    public final void _mth02CB(String s, io io)
    {
        (new StringBuilder("presence reconnectCallback ")).append(io);
    }

    public final void _mth02CE(String s, io io)
    {
        (new StringBuilder("presence disconnectCallback ")).append(io);
    }

    public final void _mth02CE(iq iq)
    {
        (new StringBuilder("presence successCallback ")).append(iq);
        abm.aw();
        abm.av()._mth1429(new abp(iq));
    }

    public tring(String s)
    {
        bcv = s;
    }
}
