// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import java.lang.ref.WeakReference;

// Referenced classes of package com.digits.sdk.android:
//            AuthCallback, DigitsException, DigitsSession

class WeakAuthCallback
    implements AuthCallback
{

    private final WeakReference callbackWeakReference;

    public WeakAuthCallback(AuthCallback authcallback)
    {
        callbackWeakReference = new WeakReference(authcallback);
    }

    public void failure(DigitsException digitsexception)
    {
        AuthCallback authcallback = (AuthCallback)callbackWeakReference.get();
        if (authcallback != null)
        {
            authcallback.failure(digitsexception);
        }
    }

    public AuthCallback getCallback()
    {
        return (AuthCallback)callbackWeakReference.get();
    }

    public void success(DigitsSession digitssession, String s)
    {
        AuthCallback authcallback = (AuthCallback)callbackWeakReference.get();
        if (authcallback != null)
        {
            authcallback.success(digitssession, s);
        }
    }
}
