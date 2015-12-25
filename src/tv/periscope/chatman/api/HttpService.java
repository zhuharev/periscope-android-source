// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.periscope.chatman.api;

import retrofit.Callback;

// Referenced classes of package tv.periscope.chatman.api:
//            HistoryRequest

public interface HttpService
{

    public abstract void history(HistoryRequest historyrequest, Callback callback);
}
