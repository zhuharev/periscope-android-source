// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;

import retrofit.client.Response;

// Referenced classes of package com.twitter.sdk.android.core.internal.scribe:
//            ScribeFilesSender

static interface 
{

    public abstract Response upload(String s, String s1, String s2);

    public abstract Response uploadSequence(String s, String s1);
}
