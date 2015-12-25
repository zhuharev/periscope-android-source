// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Intent;
import android.os.Bundle;
import o.01CF;

// Referenced classes of package com.digits.sdk.android:
//            Digits, DigitsActivityDelegate

public abstract class DigitsActionBarActivity extends _cls01CF
{

    static final int REQUEST_CODE = 140;
    static final int RESULT_FINISH_DIGITS = 200;
    DigitsActivityDelegate _flddelegate;

    public DigitsActionBarActivity()
    {
    }

    abstract DigitsActivityDelegate getActivityDelegate();

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (j == 200 && i == 140)
        {
            finish();
        }
    }

    public void onCreate(Bundle bundle)
    {
        setTheme(Digits.getInstance().getTheme());
        super.onCreate(bundle);
        _flddelegate = getActivityDelegate();
        bundle = getIntent().getExtras();
        if (_flddelegate.isValid(bundle))
        {
            setContentView(_flddelegate.getLayoutId());
            _flddelegate.init(this, bundle);
            return;
        } else
        {
            finish();
            throw new IllegalAccessError("This activity can only be started from Digits");
        }
    }

    public void onDestroy()
    {
        _flddelegate.onDestroy();
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        _flddelegate.onResume();
    }
}
