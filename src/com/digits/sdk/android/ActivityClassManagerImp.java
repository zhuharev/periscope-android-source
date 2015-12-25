// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;


// Referenced classes of package com.digits.sdk.android:
//            ActivityClassManager, ConfirmationCodeActivity, ContactsActivity, FailureActivity, 
//            LoginCodeActivity, PhoneNumberActivity, PinCodeActivity

class ActivityClassManagerImp
    implements ActivityClassManager
{

    ActivityClassManagerImp()
    {
    }

    public Class getConfirmationActivity()
    {
        return com/digits/sdk/android/ConfirmationCodeActivity;
    }

    public Class getContactsActivity()
    {
        return com/digits/sdk/android/ContactsActivity;
    }

    public Class getFailureActivity()
    {
        return com/digits/sdk/android/FailureActivity;
    }

    public Class getLoginCodeActivity()
    {
        return com/digits/sdk/android/LoginCodeActivity;
    }

    public Class getPhoneNumberActivity()
    {
        return com/digits/sdk/android/PhoneNumberActivity;
    }

    public Class getPinCodeActivity()
    {
        return com/digits/sdk/android/PinCodeActivity;
    }
}
