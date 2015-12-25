// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.android.api;


// Referenced classes of package tv.periscope.android.api:
//            PsResponse, PsSettings, PsUser

public class TwitterLoginResponse extends PsResponse
{

    public String cookie;
    public transient o.acj.if sessionType;
    public PsSettings settings;
    public String suggestedUsername;
    public PsUser user;

    public TwitterLoginResponse()
    {
    }
}
