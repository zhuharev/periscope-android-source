// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
import o.1427;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.localytics.android:
//            BaseHandler, AnalyticsListener, InAppManager, FileDownloader, 
//            PushManager, MarketingProvider, JsonHelper, LocalyticsDao, 
//            InAppDialogFragment, MarketingDownloader, BaseProvider, Constants, 
//            BaseUploadThread, PushNotificationOptions, MessagingListener

class MarketingHandler extends BaseHandler
    implements AnalyticsListener
{
    final class MessagingListenersSet extends BaseHandler.ListenersSet
        implements MessagingListener
    {

        final MarketingHandler this$0;

        public final void localyticsDidDismissInAppMessage()
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsDidDismissInAppMessage", null, null);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void localyticsDidDisplayInAppMessage()
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsDidDisplayInAppMessage", null, null);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void localyticsWillDismissInAppMessage()
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsWillDismissInAppMessage", null, null);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public final void localyticsWillDisplayInAppMessage()
        {
            this;
            JVM INSTR monitorenter ;
            callListeners("localyticsWillDisplayInAppMessage", null, null);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        private MessagingListenersSet()
        {
            this$0 = MarketingHandler.this;
            super(MarketingHandler.this);
        }

        MessagingListenersSet(_cls1 _pcls1)
        {
            this();
        }
    }


    private static final int MESSAGE_HANDLE_PUSH_RECEIVED = 204;
    private static final int MESSAGE_IN_APP_MESSAGE_TRIGGER = 201;
    private static final int MESSAGE_SET_IN_APP_MESSAGE_AS_NOT_DISPLAYED = 205;
    private static final int MESSAGE_SHOW_IN_APP_MESSAGES_TEST = 203;
    private static final int MESSAGE_TAG_PUSH_RECEIVED_EVENT = 206;
    private int lastMarketingMessagesHash;
    protected InAppManager mInAppManager;
    protected PushManager mPushManager;

    MarketingHandler(LocalyticsDao localyticsdao, Looper looper, Context context)
    {
        super(localyticsdao, looper);
        lastMarketingMessagesHash = -1;
        siloName = "In-app";
        listeners = new MessagingListenersSet(null);
        doesRetry = false;
        mInAppManager = new InAppManager(localyticsdao, this, new FileDownloader());
        mPushManager = new PushManager(localyticsdao);
        _createLocalyticsDirectory(context);
        queueMessage(obtainMessage(1));
    }

    private boolean _createLocalyticsDirectory(Context context)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(context.getFilesDir().getAbsolutePath());
        stringbuilder.append(File.separator);
        stringbuilder.append(".localytics");
        context = new File(stringbuilder.toString());
        return context.mkdirs() || context.isDirectory();
    }

    protected void _deleteUploadedData(int i)
    {
    }

    protected TreeMap _getDataToUpload()
    {
        TreeMap treemap = new TreeMap();
        treemap.put(Integer.valueOf(0), "");
        return treemap;
    }

    protected int _getMaxRowToUpload()
    {
        return 1;
    }

    protected void _init()
    {
        mProvider = new MarketingProvider(siloName.toLowerCase(), mLocalyticsDao);
        _setProviderForManagers();
    }

    protected void _onUploadCompleted(String s)
    {
        int i;
        if (s != null)
        {
            i = s.hashCode();
        } else
        {
            i = lastMarketingMessagesHash;
        }
        if (i != lastMarketingMessagesHash)
        {
            try
            {
                s = JsonHelper.toMap(new JSONObject(s));
                Map map = (Map)s.get("config");
                mInAppManager._processMarketingObject(s, map);
                lastMarketingMessagesHash = i;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Localytics.Log.w("JSONException", s);
            }
        }
        if (!mInAppManager._handleTestCampaigns())
        {
            mLocalyticsDao.triggerInAppMessage("open");
        }
    }

    protected void _setProviderForManagers()
    {
        mInAppManager.setProvider(mProvider);
        mPushManager.setProvider(mProvider);
    }

    void dismissCurrentInAppMessage()
    {
        mInAppManager.dismissCurrentInAppMessage();
    }

    void displayInAppMessage(String s, Map map, boolean flag)
    {
        if ("open".equals(s))
        {
            s = obtainMessage(201, ((Object) (new Object[] {
                s, null
            })));
            int i;
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            queueMessageDelayed(s, (long)i * 10000L);
            return;
        } else
        {
            queueMessage(obtainMessage(201, ((Object) (new Object[] {
                s, map
            }))));
            return;
        }
    }

    Localytics.InAppMessageDismissButtonLocation getInAppDismissButtonLocation()
    {
        return InAppDialogFragment.getInAppDismissButtonLocation();
    }

    protected BaseUploadThread getUploadThread(TreeMap treemap, String s)
    {
        return new MarketingDownloader(this, treemap, s, mLocalyticsDao);
    }

    protected void handleMessageExtended(final Message event)
    {
        switch (event.what)
        {
        case 201: 
            Localytics.Log.d("In-app handler received MESSAGE_INAPP_TRIGGER");
            Object aobj[] = (Object[])event.obj;
            event = (String)aobj[0];
            final Map attributes = (Map)aobj[1];
            mProvider.runBatchTransaction(new _cls2());
            return;

        case 203: 
            Localytics.Log.d("In-app handler received MESSAGE_SHOW_INAPP_TEST");
            _upload(true, (String)event.obj);
            (new Handler(Looper.getMainLooper())).postDelayed(new _cls3(), 1000L);
            return;

        case 204: 
            Localytics.Log.d("In-app handler received MESSAGE_HANDLE_PUSH_RECEIVED");
            event = (Intent)event.obj;
            mProvider.runBatchTransaction(new _cls4());
            return;

        case 205: 
            Localytics.Log.d("Marketing handler received MESSAGE_SET_IN_APP_MESSAGE_AS_NOT_DISPLAYED");
            final int campaignId = ((Integer)event.obj).intValue();
            mProvider.runBatchTransaction(new _cls5());
            return;

        case 206: 
            Localytics.Log.d("Marketing handler received MESSAGE_TAG_PUSH_RECEIVED_EVENT");
            event = (Intent)event.obj;
            mProvider.runBatchTransaction(new _cls6());
            return;
        }
        super.handleMessageExtended(event);
    }

    void handleNotificationReceived(Intent intent)
    {
        queueMessage(obtainMessage(204, intent));
    }

    void handlePushNotificationOpened(Intent intent)
    {
        mPushManager.handlePushNotificationOpened(intent);
    }

    void handleTestModeIntent(Intent intent)
    {
        if (intent == null)
        {
            throw new IllegalArgumentException("intent cannot be null");
        }
        Object obj = intent.getData();
        if (obj == null || ((Uri) (obj)).getScheme() == null || !((Uri) (obj)).getScheme().equals((new StringBuilder("amp")).append(mLocalyticsDao.getApiKey()).toString()))
        {
            return;
        }
        intent = ((Uri) (obj)).getPath().substring(1);
        obj = ((Uri) (obj)).getHost();
        intent = intent.split("[/]");
        if (intent.length == 0)
        {
            return;
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))) && ((String) (obj)).equalsIgnoreCase("testMode"))
        {
            if (intent[0].equalsIgnoreCase("enabled"))
            {
                mLocalyticsDao.setTestModeEnabled(true);
                return;
            }
            if (intent[0].equalsIgnoreCase("launch") && intent[1].equalsIgnoreCase("push"))
            {
                mPushManager.handlePushTestMode(intent);
            }
        }
    }

    public void localyticsDidTagEvent(String s, Map map, long l)
    {
        mLocalyticsDao.triggerInAppMessage(s, map);
    }

    public void localyticsSessionDidOpen(boolean flag, boolean flag1, boolean flag2)
    {
        if (!flag2)
        {
            upload(mLocalyticsDao.getCustomerIdInMemory());
        }
        if (!Constants.isTestModeEnabled())
        {
            if (flag)
            {
                mLocalyticsDao.triggerInAppMessage("AMP First Run");
            }
            if (flag1)
            {
                mLocalyticsDao.triggerInAppMessage("AMP upgrade");
            }
            if (!flag2)
            {
                mInAppManager.setSessionStartInAppMessageShown(false);
                mLocalyticsDao.triggerInAppMessage("open", null, true);
            }
        }
    }

    public void localyticsSessionWillClose()
    {
    }

    public void localyticsSessionWillOpen(boolean flag, boolean flag1, boolean flag2)
    {
    }

    void setDismissButtonImage(Bitmap bitmap)
    {
        InAppDialogFragment.setDismissButtonImage(bitmap);
    }

    void setFragmentManager(_cls1427 _pcls1427)
    {
        mInAppManager.setFragmentManager(_pcls1427);
    }

    boolean setInAppAsDisplayed(final int campaignId)
    {
        return getBool(new _cls1());
    }

    void setInAppDismissButtonLocation(Localytics.InAppMessageDismissButtonLocation inappmessagedismissbuttonlocation)
    {
        InAppDialogFragment.setInAppDismissButtonLocation(inappmessagedismissbuttonlocation);
    }

    void setInAppMessageAsNotDisplayed(int i)
    {
        queueMessage(obtainMessage(205, Integer.valueOf(i)));
    }

    void setPushNotificationOptions(PushNotificationOptions pushnotificationoptions)
    {
        mPushManager.setPushNotificationOptions(pushnotificationoptions);
    }

    void showMarketingTest()
    {
        queueMessage(obtainMessage(203, mLocalyticsDao.getCustomerIdInMemory()));
    }

    void tagPushReceivedEvent(Intent intent)
    {
        queueMessage(obtainMessage(206, intent));
    }

    private class _cls2
        implements Runnable
    {

        final MarketingHandler this$0;
        final Map val$attributes;
        final String val$event;

        public void run()
        {
            mInAppManager._inAppMessageTrigger(event, attributes);
        }

        _cls2()
        {
            this$0 = MarketingHandler.this;
            event = s;
            attributes = map;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final MarketingHandler this$0;

        public void run()
        {
            mInAppManager._showInAppTest();
        }

        _cls3()
        {
            this$0 = MarketingHandler.this;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final MarketingHandler this$0;
        final Intent val$intent;

        public void run()
        {
            if (mPushManager._tagPushReceivedEvent(intent))
            {
                mPushManager._showPushNotification(intent);
            }
        }

        _cls4()
        {
            this$0 = MarketingHandler.this;
            intent = intent1;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final MarketingHandler this$0;
        final int val$campaignId;

        public void run()
        {
            mInAppManager._setInAppMessageAsNotDisplayed(campaignId);
        }

        _cls5()
        {
            this$0 = MarketingHandler.this;
            campaignId = i;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final MarketingHandler this$0;
        final Intent val$intent;

        public void run()
        {
            mPushManager._tagPushReceivedEvent(intent);
        }

        _cls6()
        {
            this$0 = MarketingHandler.this;
            intent = intent1;
            super();
        }
    }


    private class _cls1
        implements Callable
    {

        final MarketingHandler this$0;
        final int val$campaignId;

        public Boolean call()
        {
            return Boolean.valueOf(mInAppManager._setInAppMessageAsDisplayed(campaignId));
        }

        public volatile Object call()
        {
            return call();
        }

        _cls1()
        {
            this$0 = MarketingHandler.this;
            campaignId = i;
            super();
        }
    }

}
