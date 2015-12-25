// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;


// Referenced classes of package tv.periscope.android.api:
//            PsRequest

public class EndReplayViewedRequest extends PsRequest
{

    public String broadcastId;
    public float completion;
    public float duration;
    public int numHearts;
    public String session;

    public EndReplayViewedRequest()
    {
    }
}
