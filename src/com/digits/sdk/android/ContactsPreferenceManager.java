// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.SharedPreferences;
import o.ra;
import o.up;

// Referenced classes of package com.digits.sdk.android:
//            Digits

class ContactsPreferenceManager
{

    static final String KEY_CONTACTS_IMPORT_PERMISSION = "CONTACTS_IMPORT_PERMISSION";
    static final String KEY_CONTACTS_READ_TIMESTAMP = "CONTACTS_READ_TIMESTAMP";
    static final String KEY_CONTACTS_UPLOADED = "CONTACTS_CONTACTS_UPLOADED";
    private final up prefStore = new up(ra._mth02BE(com/digits/sdk/android/Digits));

    ContactsPreferenceManager()
    {
    }

    protected void clearContactImportPermissionGranted()
    {
        prefStore._mth02CA(prefStore.edit().remove("CONTACTS_IMPORT_PERMISSION"));
    }

    protected boolean hasContactImportPermissionGranted()
    {
        return prefStore._mth1E97().getBoolean("CONTACTS_IMPORT_PERMISSION", false);
    }

    protected void setContactImportPermissionGranted()
    {
        prefStore._mth02CA(prefStore.edit().putBoolean("CONTACTS_IMPORT_PERMISSION", true));
    }

    protected void setContactsReadTimestamp(long l)
    {
        prefStore._mth02CA(prefStore.edit().putLong("CONTACTS_READ_TIMESTAMP", l));
    }

    protected void setContactsUploaded(int i)
    {
        prefStore._mth02CA(prefStore.edit().putInt("CONTACTS_CONTACTS_UPLOADED", i));
    }
}
