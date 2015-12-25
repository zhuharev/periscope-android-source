// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package com.digits.sdk.android:
//            Digits, FailureActivityDelegateImpl

public class FailureActivity extends Activity
{

    FailureActivityDelegateImpl _flddelegate;

    public FailureActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        setTheme(Digits.getInstance().getTheme());
        super.onCreate(bundle);
        _flddelegate = new FailureActivityDelegateImpl(this);
        _flddelegate.init();
    }
}
