// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;

interface ActivityLifecycle
{

    public abstract void onActivityResult(int i, int j, Activity activity);

    public abstract void onDestroy();

    public abstract void onResume();
}
