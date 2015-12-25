// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import o.so;

// Referenced classes of package com.digits.sdk.android:
//            PhoneNumberUtils, PhoneNumber

class PhoneNumberTask extends so
{
    static interface Listener
    {

        public abstract void onLoadComplete(PhoneNumber phonenumber);
    }


    private final Listener listener;
    private final PhoneNumberUtils phoneNumberUtils;
    private final String providedPhoneNumber;

    protected PhoneNumberTask(PhoneNumberUtils phonenumberutils, Listener listener1)
    {
        if (phonenumberutils == null)
        {
            throw new NullPointerException("phoneNumberUtils can't be null");
        } else
        {
            listener = listener1;
            phoneNumberUtils = phonenumberutils;
            providedPhoneNumber = "";
            return;
        }
    }

    protected PhoneNumberTask(PhoneNumberUtils phonenumberutils, String s, Listener listener1)
    {
        if (phonenumberutils == null)
        {
            throw new NullPointerException("phoneNumberUtils can't be null");
        } else
        {
            listener = listener1;
            phoneNumberUtils = phonenumberutils;
            providedPhoneNumber = s;
            return;
        }
    }

    protected transient PhoneNumber doInBackground(Void avoid[])
    {
        return phoneNumberUtils.getPhoneNumber(providedPhoneNumber);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(PhoneNumber phonenumber)
    {
        if (listener != null)
        {
            listener.onLoadComplete(phonenumber);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((PhoneNumber)obj);
    }
}
