// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;


// Referenced classes of package com.digits.sdk.android:
//            DigitsActionBarActivity, LoginCodeActivityDelegate, DigitsActivityDelegate

public class LoginCodeActionBarActivity extends DigitsActionBarActivity
{

    public LoginCodeActionBarActivity()
    {
    }

    DigitsActivityDelegate getActivityDelegate()
    {
        return new LoginCodeActivityDelegate();
    }
}
