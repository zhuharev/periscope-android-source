// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.ws;

import o.vr;
import o.vv;

// Referenced classes of package com.squareup.okhttp.internal.ws:
//            WebSocketReader

public static interface 
{

    public abstract void onClose(int i, String s);

    public abstract void onMessage(vv vv, com.squareup.okhttp.ws.Callback callback);

    public abstract void onPing(vr vr);

    public abstract void onPong(vr vr);
}
