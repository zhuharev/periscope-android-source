// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digits.sdk.android;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import o.ti;
import o.tj;
import o.tk;
import o.tl;
import o.tm;

// Referenced classes of package com.digits.sdk.android:
//            Digits, ContactsHelper, ContactsPreferenceManager, Vcards, 
//            ContactsUploadResult, ContactsClient

public class ContactsUploadService extends IntentService
{

    private static final int CORE_THREAD_POOL_SIZE = 2;
    private static final int INITIAL_BACKOFF_MS = 1000;
    private static final int MAX_RETRIES = 1;
    private static final String THREAD_NAME = "UPLOAD_WORKER";
    private static final int TIMEOUT_IN_SECONDS = 300;
    public static final String UPLOAD_COMPLETE = "com.digits.sdk.android.UPLOAD_COMPLETE";
    public static final String UPLOAD_COMPLETE_EXTRA = "com.digits.sdk.android.UPLOAD_COMPLETE_EXTRA";
    public static final String UPLOAD_FAILED = "com.digits.sdk.android.UPLOAD_FAILED";
    private ContactsClient contactsClient;
    private tm executor;
    private ContactsHelper helper;
    private ContactsPreferenceManager prefManager;

    public ContactsUploadService()
    {
        super("UPLOAD_WORKER");
        init(Digits.getInstance().getContactsClient(), new ContactsHelper(this), new ContactsPreferenceManager(), new tm(2, new tk(1), new ti(1000L)));
    }

    ContactsUploadService(ContactsClient contactsclient, ContactsHelper contactshelper, ContactsPreferenceManager contactspreferencemanager, tm tm1)
    {
        super("UPLOAD_WORKER");
        init(contactsclient, contactshelper, contactspreferencemanager, tm1);
    }

    private List getAllCards()
    {
        Cursor cursor;
        cursor = null;
        Collections.emptyList();
        Cursor cursor1 = helper.getContactsCursor();
        cursor = cursor1;
        List list = helper.createContactList(cursor1);
        Exception exception;
        if (cursor1 != null)
        {
            cursor1.close();
            return list;
        } else
        {
            return list;
        }
        exception;
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
    }

    private void init(ContactsClient contactsclient, ContactsHelper contactshelper, ContactsPreferenceManager contactspreferencemanager, tm tm1)
    {
        contactsClient = contactsclient;
        helper = contactshelper;
        prefManager = contactspreferencemanager;
        executor = tm1;
        setIntentRedelivery(true);
    }

    int getNumberOfPages(int i)
    {
        return ((i + 100) - 1) / 100;
    }

    protected void onHandleIntent(Intent intent)
    {
        prefManager.setContactImportPermissionGranted();
        final AtomicInteger successCount;
        int j;
        int k;
        intent = getAllCards();
        j = intent.size();
        k = getNumberOfPages(j);
        successCount = new AtomicInteger(0);
        int i = 0;
_L2:
        int l;
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        l = i * 100;
        tm tm1;
        final Vcards vCards;
        vCards = new Vcards(intent.subList(l, Math.min(j, l + 100)));
        tm1 = executor;
        vCards = Executors.callable(new _cls1());
        if (vCards != null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        throw new NullPointerException();
        tm1.execute(new tj(vCards, new tl(tm1.sR, tm1.Tg), tm1));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        executor.shutdown();
        if (!executor.awaitTermination(300L, TimeUnit.SECONDS))
        {
            executor.shutdownNow();
            sendFailureBroadcast();
            return;
        }
        if (successCount.get() == 0)
        {
            sendFailureBroadcast();
            return;
        }
        try
        {
            prefManager.setContactsReadTimestamp(System.currentTimeMillis());
            prefManager.setContactsUploaded(successCount.get());
            sendSuccessBroadcast(new ContactsUploadResult(successCount.get(), j));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            sendFailureBroadcast();
        }
        return;
    }

    void sendFailureBroadcast()
    {
        sendBroadcast(new Intent("com.digits.sdk.android.UPLOAD_FAILED"));
    }

    void sendSuccessBroadcast(ContactsUploadResult contactsuploadresult)
    {
        Intent intent = new Intent("com.digits.sdk.android.UPLOAD_COMPLETE");
        intent.putExtra("com.digits.sdk.android.UPLOAD_COMPLETE_EXTRA", contactsuploadresult);
        sendBroadcast(intent);
    }


    private class _cls1
        implements Runnable
    {

        final ContactsUploadService this$0;
        final AtomicInteger val$successCount;
        final Vcards val$vCards;

        public void run()
        {
            contactsClient.uploadContacts(vCards);
            successCount.addAndGet(vCards.vcards.size());
        }

        _cls1()
        {
            this$0 = ContactsUploadService.this;
            vCards = vcards;
            successCount = atomicinteger;
            super();
        }
    }

}
