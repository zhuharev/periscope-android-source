// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.digits.sdk.android:
//            ContactsController, ContactsUploadService

class ContactsControllerImpl
    implements ContactsController
{

    ContactsControllerImpl()
    {
    }

    public void startUploadService(Context context)
    {
        context.startService(new Intent(context, com/digits/sdk/android/ContactsUploadService));
    }
}
