// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;


// Referenced classes of package com.digits.sdk.android:
//            DigitsActionBarActivity, PhoneNumberActivityDelegate, DigitsActivityDelegate

public class PhoneNumberActionBarActivity extends DigitsActionBarActivity
{

    public PhoneNumberActionBarActivity()
    {
    }

    DigitsActivityDelegate getActivityDelegate()
    {
        return new PhoneNumberActivityDelegate();
    }
}
