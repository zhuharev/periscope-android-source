// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            nx, abm, abp, ql, 
//            FF6A, io, iq, or

static final class <init> extends nx
{

    public final void _mth02CA(String s, io io)
    {
        (new StringBuilder("hereNow connectCallback ")).append(io);
    }

    public final void _mth02CA(String s, iq iq)
    {
        (new StringBuilder("hereNow successCallback ")).append(iq);
        abm.av()._mth1429(new abp(iq));
    }

    public final void _mth02CA(String s, or or)
    {
        FF6A._mth02CB("RTMP", (new StringBuilder("PubNub hereNow errorCallback ")).append(or).toString());
    }

    public final void _mth02CB(String s, io io)
    {
        (new StringBuilder("hereNow reconnectCallback ")).append(io);
    }

    public final void _mth02CE(String s, io io)
    {
        (new StringBuilder("hereNow disconnectCallback ")).append(io);
    }

    public final void _mth02CE(iq iq)
    {
    }

    private .String()
    {
    }

    .String(byte byte0)
    {
        this();
    }
}
