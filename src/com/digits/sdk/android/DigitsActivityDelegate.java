// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.digits.sdk.android:
//            ActivityLifecycle

public interface DigitsActivityDelegate
    extends ActivityLifecycle
{

    public abstract int getLayoutId();

    public abstract void init(Activity activity, Bundle bundle);

    public abstract boolean isValid(Bundle bundle);
}
