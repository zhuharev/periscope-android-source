// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


// Referenced classes of package o:
//            nx, abm, FF6A, io, 
//            iq, or

static final class tring extends nx
{

    public final void _mth02CA(String s, io io)
    {
        (new StringBuilder("publish connectCallback ")).append(io);
    }

    public final void _mth02CA(String s, iq iq)
    {
        (new StringBuilder("publish successCallback ")).append(iq);
    }

    public final void _mth02CA(String s, or or)
    {
        super._mth02CA(s, or);
        FF6A._mth02CB("RTMP", (new StringBuilder("PubNub publish errorCallback ")).append(or).toString());
    }

    public final void _mth02CB(String s, io io)
    {
        (new StringBuilder("publish reconnectCallback ")).append(io);
    }

    public final void _mth02CE(String s, io io)
    {
        (new StringBuilder("publish disconnectCallback ")).append(io);
    }

    public final void _mth02CE(iq iq)
    {
        (new StringBuilder("publish successCallback ")).append(iq);
    }

    tring()
    {
    }
}
