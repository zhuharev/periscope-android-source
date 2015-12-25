// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;


// Referenced classes of package com.digits.sdk.android:
//            ContactsClient, ContactsCallback, Vcards, UploadResponse

static interface 
{

    public abstract void deleteAll(ContactsCallback contactscallback);

    public abstract UploadResponse upload(Vcards vcards);

    public abstract void usersAndUploadedBy(String s, Integer integer, ContactsCallback contactscallback);
}
