// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import java.util.concurrent.atomic.AtomicReference;
import o.ra;
import o.rl;

// Referenced classes of package com.twitter.sdk.android.core.identity:
//            AuthHandler

class AuthState
{

    final AtomicReference authHandlerRef = new AtomicReference(null);

    AuthState()
    {
    }

    public boolean beginAuthorize(Activity activity, AuthHandler authhandler)
    {
        boolean flag1 = false;
        if (isAuthorizeInProgress())
        {
            ra._mth0454()._mth02CE("Twitter", "Authorize already in progress");
            return false;
        }
        if (authhandler.authorize(activity))
        {
            boolean flag2 = authHandlerRef.compareAndSet(null, authhandler);
            boolean flag = flag2;
            flag1 = flag;
            if (!flag2)
            {
                ra._mth0454()._mth02CE("Twitter", "Failed to update authHandler, authorize already in progress.");
                flag1 = flag;
            }
        }
        return flag1;
    }

    public void endAuthorize()
    {
        authHandlerRef.set(null);
    }

    public AuthHandler getAuthHandler()
    {
        return (AuthHandler)authHandlerRef.get();
    }

    public boolean isAuthorizeInProgress()
    {
        return authHandlerRef.get() != null;
    }
}
