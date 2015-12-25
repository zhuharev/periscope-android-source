// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Intent;
import android.os.Bundle;
import o.01CF;

// Referenced classes of package com.digits.sdk.android:
//            ContactsActivityDelegateImpl

public class ContactsActionBarActivity extends _cls01CF
{

    ContactsActivityDelegateImpl _flddelegate;

    public ContactsActionBarActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        setTheme(getIntent().getIntExtra("THEME_RESOURCE_ID", R.style.Theme_AppCompat_Light));
        super.onCreate(bundle);
        _flddelegate = new ContactsActivityDelegateImpl(this);
        _flddelegate.init();
    }
}
