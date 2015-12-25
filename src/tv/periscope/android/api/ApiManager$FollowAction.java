// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;


// Referenced classes of package tv.periscope.android.api:
//            ApiManager, PsRequest

class request
{

    public PsRequest request;
    final ApiManager this$0;
    public ype type;

    public String toString()
    {
        return (new StringBuilder("FollowAction(")).append(type).append(", ").append(request).append(")").toString();
    }

    public ype(ype ype, PsRequest psrequest)
    {
        this$0 = ApiManager.this;
        super();
        type = ype;
        request = psrequest;
    }
}
