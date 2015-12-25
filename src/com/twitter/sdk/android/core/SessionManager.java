// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core;

import java.util.Map;

// Referenced classes of package com.twitter.sdk.android.core:
//            Session

public interface SessionManager
{

    public abstract void clearActiveSession();

    public abstract void clearSession(long l);

    public abstract Session getActiveSession();

    public abstract Session getSession(long l);

    public abstract Map getSessionMap();

    public abstract void setActiveSession(Session session);

    public abstract void setSession(long l, Session session);
}
