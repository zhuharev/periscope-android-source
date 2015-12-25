// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.digits.sdk.android:
//            ContactsActivityDelegateImpl

public class ContactsActivity extends Activity
{

    ContactsActivityDelegateImpl _flddelegate;

    public ContactsActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        setTheme(getIntent().getIntExtra("THEME_RESOURCE_ID", R.style.Digits_default));
        super.onCreate(bundle);
        _flddelegate = new ContactsActivityDelegateImpl(this);
        _flddelegate.init();
    }
}
