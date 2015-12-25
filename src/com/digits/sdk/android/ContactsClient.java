// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.content.Context;
import android.content.Intent;
import com.twitter.sdk.android.core.AuthenticatedClient;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterCore;
import retrofit.RestAdapter;

// Referenced classes of package com.digits.sdk.android:
//            ContactsPreferenceManager, ActivityClassManagerFactory, DigitsApi, Digits, 
//            ActivityClassManager, ContactsUploadService, ContactsCallback, Vcards, 
//            UploadResponse

public class ContactsClient
{
    static interface ContactsService
    {

        public abstract void deleteAll(ContactsCallback contactscallback);

        public abstract UploadResponse upload(Vcards vcards);

        public abstract void usersAndUploadedBy(String s, Integer integer, ContactsCallback contactscallback);
    }


    public static final int MAX_PAGE_SIZE = 100;
    private ActivityClassManagerFactory activityClassManagerFactory;
    private ContactsService contactsService;
    private final ContactsPreferenceManager prefManager;
    private final TwitterCore twitterCore;

    ContactsClient()
    {
        this(TwitterCore.getInstance(), new ContactsPreferenceManager(), new ActivityClassManagerFactory(), null);
    }

    ContactsClient(TwitterCore twittercore, ContactsPreferenceManager contactspreferencemanager, ActivityClassManagerFactory activityclassmanagerfactory, ContactsService contactsservice)
    {
        if (twittercore == null)
        {
            throw new IllegalArgumentException("twitter must not be null");
        }
        if (contactspreferencemanager == null)
        {
            throw new IllegalArgumentException("preference manager must not be null");
        }
        if (activityclassmanagerfactory == null)
        {
            throw new IllegalArgumentException("activityClassManagerFactory must not be null");
        } else
        {
            twitterCore = twittercore;
            prefManager = contactspreferencemanager;
            activityClassManagerFactory = activityclassmanagerfactory;
            contactsService = contactsservice;
            return;
        }
    }

    private ContactsService getContactsService()
    {
        if (contactsService != null)
        {
            return contactsService;
        } else
        {
            contactsService = (ContactsService)(new retrofit.RestAdapter.Builder()).setEndpoint((new DigitsApi()).getBaseHostUrl()).setClient(new AuthenticatedClient(twitterCore.getAuthConfig(), Digits.getSessionManager().getActiveSession(), twitterCore.getSSLSocketFactory())).build().create(com/digits/sdk/android/ContactsClient$ContactsService);
            return contactsService;
        }
    }

    private void startContactsActivity(Context context, int i)
    {
        Intent intent = new Intent(context, activityClassManagerFactory.createActivityClassManager(context, i).getContactsActivity());
        intent.putExtra("THEME_RESOURCE_ID", i);
        intent.setFlags(0x10000000);
        context.startActivity(intent);
    }

    private void startContactsService(Context context)
    {
        context.startService(new Intent(context, com/digits/sdk/android/ContactsUploadService));
    }

    public void deleteAllUploadedContacts(ContactsCallback contactscallback)
    {
        getContactsService().deleteAll(contactscallback);
    }

    public boolean hasUserGrantedPermission()
    {
        return prefManager.hasContactImportPermissionGranted();
    }

    public void lookupContactMatches(String s, Integer integer, ContactsCallback contactscallback)
    {
        if (integer == null || integer.intValue() <= 0 || integer.intValue() > 100)
        {
            getContactsService().usersAndUploadedBy(s, null, contactscallback);
            return;
        } else
        {
            getContactsService().usersAndUploadedBy(s, integer, contactscallback);
            return;
        }
    }

    public void startContactsUpload()
    {
        startContactsUpload(R.style.Digits_default);
    }

    public void startContactsUpload(int i)
    {
        startContactsUpload(twitterCore.getContext(), i);
    }

    protected void startContactsUpload(Context context, int i)
    {
        if (!hasUserGrantedPermission())
        {
            startContactsActivity(context, i);
            return;
        } else
        {
            startContactsService(context);
            return;
        }
    }

    UploadResponse uploadContacts(Vcards vcards)
    {
        return getContactsService().upload(vcards);
    }
}
