// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;


// Referenced classes of package com.digits.sdk.android:
//            ActivityClassManager, ConfirmationCodeActionBarActivity, ContactsActionBarActivity, FailureActionBarActivity, 
//            LoginCodeActionBarActivity, PhoneNumberActionBarActivity, PinCodeActionBarActivity

class AppCompatClassManagerImp
    implements ActivityClassManager
{

    AppCompatClassManagerImp()
    {
    }

    public Class getConfirmationActivity()
    {
        return com/digits/sdk/android/ConfirmationCodeActionBarActivity;
    }

    public Class getContactsActivity()
    {
        return com/digits/sdk/android/ContactsActionBarActivity;
    }

    public Class getFailureActivity()
    {
        return com/digits/sdk/android/FailureActionBarActivity;
    }

    public Class getLoginCodeActivity()
    {
        return com/digits/sdk/android/LoginCodeActionBarActivity;
    }

    public Class getPhoneNumberActivity()
    {
        return com/digits/sdk/android/PhoneNumberActionBarActivity;
    }

    public Class getPinCodeActivity()
    {
        return com/digits/sdk/android/PinCodeActionBarActivity;
    }
}
