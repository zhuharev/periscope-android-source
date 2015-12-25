// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import java.net.Proxy;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import o.02C9;

// Referenced classes of package com.localytics.android:
//            LocalyticsDao, AnalyticsHandler, MarketingHandler, ProfileHandler, 
//            DatapointHelper, Localytics, PushReceiver, PushTrackingActivity, 
//            Constants, AnalyticsListener, MessagingListener, PushNotificationOptions

final class LocalyticsManager extends Enum
    implements LocalyticsDao
{
    final class HandlerWrapper
    {

        AnalyticsHandler analyticsHandler;
        MarketingHandler marketingHandler;
        ProfileHandler profileHandler;
        final LocalyticsManager this$0;

        private HandlerWrapper(AnalyticsHandler analyticshandler, MarketingHandler marketinghandler, ProfileHandler profilehandler)
        {
            this$0 = LocalyticsManager.this;
            super();
            analyticsHandler = analyticshandler;
            marketingHandler = marketinghandler;
            profileHandler = profilehandler;
        }

        HandlerWrapper(AnalyticsHandler analyticshandler, MarketingHandler marketinghandler, ProfileHandler profilehandler, _cls1 _pcls1)
        {
            this(analyticshandler, marketinghandler, profilehandler);
        }
    }

    public static final class LocalyticsNotInitializedException extends RuntimeException
    {

        private LocalyticsNotInitializedException()
        {
            super("You must first initialize Localytics");
        }

        LocalyticsNotInitializedException(_cls1 _pcls1)
        {
            this();
        }
    }


    private static final LocalyticsManager $VALUES[];
    public static final LocalyticsManager INSTANCE;
    private static int mActivityCounter = 0;
    private static boolean mIsAutoIntegrate = false;
    private String mApiKey;
    private Context mAppContext;
    private String mCustomerId;
    private HandlerWrapper mHandlerWrapper;
    private CountDownLatch mInitiatedLatch;
    private String mInstallationId;
    private Proxy proxy;

    private LocalyticsManager(String s, int i)
    {
        super(s, i);
        mInitiatedLatch = new CountDownLatch(1);
    }

    private boolean classInManifest(ActivityInfo aactivityinfo[], String s)
    {
        if (aactivityinfo != null)
        {
            int j = aactivityinfo.length;
            for (int i = 0; i < j; i++)
            {
                if (aactivityinfo[i].name.equalsIgnoreCase(s))
                {
                    return true;
                }
            }

        }
        return false;
    }

    private HandlerThread getHandlerThread(String s)
    {
        s = new HandlerThread(s, 10);
        s.start();
        return s;
    }

    static LocalyticsManager getInstance()
    {
        return INSTANCE;
    }

    private Bitmap scaleDownBitmap(Bitmap bitmap, float f)
    {
        int i = Math.max(bitmap.getWidth(), bitmap.getHeight());
        float f1 = (float)bitmap.getWidth() / (float)bitmap.getHeight();
        if ((float)i > f)
        {
            if (bitmap.getWidth() >= bitmap.getHeight())
            {
                bitmap = Bitmap.createScaledBitmap(bitmap, (int)f, (int)(f / f1 + 0.5F), true);
            } else
            {
                bitmap = Bitmap.createScaledBitmap(bitmap, (int)(f * f1 + 0.5F), (int)f, true);
            }
            if (bitmap == null)
            {
                Localytics.Log.w("Cannot scale down the new dismiss button image.");
            }
            return bitmap;
        } else
        {
            return bitmap;
        }
    }

    private void setSpecialCustomerIdentifierAndAttribute(String s, String s1)
    {
        setProfileAttribute((new StringBuilder("$")).append(s).toString(), s1, Localytics.ProfileScope.ORGANIZATION);
        setIdentifier(s, s1);
    }

    static Object throwOrLogError(Class class1, String s)
    {
        return throwOrLogError(class1, s, null);
    }

    static Object throwOrLogError(Class class1, String s, Exception exception)
    {
        return null;
    }

    public static LocalyticsManager valueOf(String s)
    {
        return (LocalyticsManager)Enum.valueOf(com/localytics/android/LocalyticsManager, s);
    }

    public static LocalyticsManager[] values()
    {
        return (LocalyticsManager[])$VALUES.clone();
    }

    public final void addAnalyticsListener(AnalyticsListener analyticslistener)
    {
        getAnalyticsHandler().addListener(analyticslistener);
    }

    public final void addMessagingListener(MessagingListener messaginglistener)
    {
        getMarketingHandler().addListener(messaginglistener);
    }

    public final void addProfileAttributesToSet(String s, long al[])
    {
        addProfileAttributesToSet(s, al, Localytics.ProfileScope.APPLICATION);
    }

    public final void addProfileAttributesToSet(String s, long al[], Localytics.ProfileScope profilescope)
    {
        getProfileHandler().addProfileAttributesToSet(s, al, profilescope.getScope());
    }

    public final void addProfileAttributesToSet(String s, String as[])
    {
        addProfileAttributesToSet(s, as, Localytics.ProfileScope.APPLICATION);
    }

    public final void addProfileAttributesToSet(String s, String as[], Localytics.ProfileScope profilescope)
    {
        getProfileHandler().addProfileAttributesToSet(s, as, profilescope.getScope());
    }

    public final void addProfileAttributesToSet(String s, Date adate[])
    {
        addProfileAttributesToSet(s, adate, Localytics.ProfileScope.APPLICATION);
    }

    public final void addProfileAttributesToSet(String s, Date adate[], Localytics.ProfileScope profilescope)
    {
        getProfileHandler().addProfileAttributesToSet(s, adate, profilescope.getScope());
    }

    public final void clearInAppMessageDisplayActivity()
    {
        getMarketingHandler().setFragmentManager(null);
    }

    public final void closeSession()
    {
        getAnalyticsHandler().closeSession();
    }

    final void decrementActivityCounter()
    {
        mActivityCounter--;
    }

    public final void decrementProfileAttribute(String s, long l)
    {
        decrementProfileAttribute(s, l, Localytics.ProfileScope.APPLICATION);
    }

    public final void decrementProfileAttribute(String s, long l, Localytics.ProfileScope profilescope)
    {
        getProfileHandler().incrementProfileAttribute(s, -1L * l, profilescope.getScope());
    }

    public final void deleteProfileAttribute(String s)
    {
        deleteProfileAttribute(s, Localytics.ProfileScope.APPLICATION);
    }

    public final void deleteProfileAttribute(String s, Localytics.ProfileScope profilescope)
    {
        getProfileHandler().deleteProfileAttribute(s, profilescope.getScope());
    }

    public final void dismissCurrentInAppMessage()
    {
        _cls1 _lcls1 = new _cls1();
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            _lcls1.run();
            return;
        } else
        {
            (new Handler(Looper.getMainLooper())).post(_lcls1);
            return;
        }
    }

    final AnalyticsHandler getAnalyticsHandler()
    {
        if (mHandlerWrapper == null)
        {
            throw new LocalyticsNotInitializedException(null);
        } else
        {
            return mHandlerWrapper.analyticsHandler;
        }
    }

    public final String getApiKey()
    {
        return mApiKey;
    }

    public final Context getAppContext()
    {
        return mAppContext;
    }

    public final String getAppKey()
    {
        return DatapointHelper.getLocalyticsAppKeyOrNull(mAppContext);
    }

    public final Calendar getCalendar()
    {
        return Calendar.getInstance();
    }

    public final long getCurrentTimeMillis()
    {
        return System.currentTimeMillis();
    }

    public final String getCustomDimension(int i)
    {
        return getAnalyticsHandler().getCustomDimension(i);
    }

    public final String getCustomerId()
    {
        return getIdentifier("customer_id");
    }

    public final String getCustomerIdInMemory()
    {
        return getCustomerIdInMemory(false);
    }

    public final String getCustomerIdInMemory(boolean flag)
    {
        String s;
        Exception exception;
        if (!flag)
        {
            try
            {
                mInitiatedLatch.await();
            }
            catch (Exception exception1) { }
        }
        com/localytics/android/Localytics;
        JVM INSTR monitorenter ;
        s = mCustomerId;
        com/localytics/android/Localytics;
        JVM INSTR monitorexit ;
        return s;
        exception;
        throw exception;
    }

    public final CountDownLatch getCustomerIdInitiatedLatch()
    {
        return mInitiatedLatch;
    }

    public final String getIdentifier(String s)
    {
        return getAnalyticsHandler().getIdentifier(s);
    }

    public final Map getIdentifiers()
    {
        return getAnalyticsHandler().getIdentifiers();
    }

    public final Localytics.InAppMessageDismissButtonLocation getInAppMessageDismissButtonLocation()
    {
        return getMarketingHandler().getInAppDismissButtonLocation();
    }

    public final String getInstallationId()
    {
        if (!TextUtils.isEmpty(mInstallationId))
        {
            return mInstallationId;
        } else
        {
            throw new RuntimeException("No installation id!");
        }
    }

    final MarketingHandler getMarketingHandler()
    {
        if (mHandlerWrapper == null)
        {
            throw new LocalyticsNotInitializedException(null);
        } else
        {
            return mHandlerWrapper.marketingHandler;
        }
    }

    final ProfileHandler getProfileHandler()
    {
        if (mHandlerWrapper == null)
        {
            throw new LocalyticsNotInitializedException(null);
        } else
        {
            return mHandlerWrapper.profileHandler;
        }
    }

    public final Proxy getProxy()
    {
        return proxy;
    }

    public final String getPushRegistrationId()
    {
        return getAnalyticsHandler().getPushRegistrationID();
    }

    public final String getTimeStringForSQLite()
    {
        return "now";
    }

    public final void handleNotificationReceived(Intent intent)
    {
        getMarketingHandler().handleNotificationReceived(intent);
    }

    public final void handlePushNotificationOpened(Intent intent)
    {
        getMarketingHandler().handlePushNotificationOpened(intent);
    }

    public final void handleRegistration(Intent intent)
    {
        getAnalyticsHandler().handleRegistration(intent);
    }

    public final void handleTestMode(Intent intent)
    {
        getMarketingHandler().handleTestModeIntent(intent);
    }

    final void incrementActivityCounter()
    {
        mActivityCounter++;
    }

    public final void incrementProfileAttribute(String s, long l)
    {
        incrementProfileAttribute(s, l, Localytics.ProfileScope.APPLICATION);
    }

    public final void incrementProfileAttribute(String s, long l, Localytics.ProfileScope profilescope)
    {
        getProfileHandler().incrementProfileAttribute(s, l, profilescope.getScope());
    }

    public final void integrate(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (mHandlerWrapper == null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        boolean flag;
        if ("com.localytics.android".equals(context.getPackageName()) && !context.getClass().getName().equals("android.test.IsolatedContext") && !context.getClass().getName().equals("android.test.RenamingDelegatingContext"))
        {
            throw new IllegalArgumentException(String.format("context.getPackageName() returned %s", new Object[] {
                context.getPackageName()
            }));
        }
        flag = context.getClass().getName().equals("android.test.RenamingDelegatingContext");
        if (flag) goto _L2; else goto _L1
_L1:
        if (context instanceof Activity)
        {
            throw new IllegalStateException("Activity context use is not supported. You must call integrate() or registerActivityLifecycleCallbacks() from your Application class (see integration guide). If migrating from 3.0, see https://support.localytics.com/Android_SDK_Migration_3.0_to_3.x");
        }
          goto _L2
_L5:
        context = context.getApplicationContext();
_L4:
        mAppContext = context;
        mApiKey = s;
        if (TextUtils.isEmpty(mApiKey))
        {
            mApiKey = DatapointHelper.getLocalyticsAppKeyOrNull(mAppContext);
        }
        if (TextUtils.isEmpty(mApiKey))
        {
            throw new IllegalArgumentException("App key must be declared in a meta data tag in AndroidManifest.xml or passed into integrate(final Context context, final String localyticsKey) or new LocalyticsActivityLifecycleCallbacks(final Context context, final String localyticsKey) (see integration guide).");
        }
        context = mAppContext.getPackageManager().getPackageInfo(mAppContext.getPackageName(), 3);
        if (classInManifest(((PackageInfo) (context)).receivers, com/localytics/android/PushReceiver.getName()) && !classInManifest(((PackageInfo) (context)).activities, com/localytics/android/PushTrackingActivity.getName()))
        {
            throw new IllegalStateException("PushTrackingActivity must be declared in AndroidManifest.xml (see integration guide). If migrating from 3.0, see https://support.localytics.com/Android_SDK_Migration_3.0_to_3.x");
        }
          goto _L3
        context;
        Localytics.Log.w(context);
_L3:
        context = new AnalyticsHandler(this, getHandlerThread(com/localytics/android/AnalyticsHandler.getSimpleName()).getLooper());
        s = new MarketingHandler(this, getHandlerThread(com/localytics/android/MarketingHandler.getSimpleName()).getLooper(), mAppContext);
        mHandlerWrapper = new HandlerWrapper(context, s, new ProfileHandler(this, getHandlerThread(com/localytics/android/ProfileHandler.getSimpleName()).getLooper()), null);
        context.addListener(s);
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
_L2:
        if (!flag) goto _L5; else goto _L4
    }

    public final boolean isAppInForeground()
    {
        return mActivityCounter > 0;
    }

    public final boolean isAutoIntegrate()
    {
        return mIsAutoIntegrate;
    }

    public final boolean isOptedOut()
    {
        return getAnalyticsHandler().isOptedOut();
    }

    public final boolean isPushDisabled()
    {
        return getAnalyticsHandler().isPushDisabled();
    }

    public final boolean isTestModeEnabled()
    {
        return Constants.isTestModeEnabled();
    }

    public final void openSession()
    {
        getAnalyticsHandler().openSession();
    }

    public final void registerPush(String s)
    {
        registerPush(s, 0L);
    }

    public final void registerPush(String s, long l)
    {
        getAnalyticsHandler().registerPush(s, l);
    }

    public final void removeAnalyticsListener(AnalyticsListener analyticslistener)
    {
        getAnalyticsHandler().removeListener(analyticslistener);
    }

    public final void removeMessagingListener(MessagingListener messaginglistener)
    {
        getMarketingHandler().removeListener(messaginglistener);
    }

    public final void removeProfileAttributesFromSet(String s, long al[])
    {
        removeProfileAttributesFromSet(s, al, Localytics.ProfileScope.APPLICATION);
    }

    public final void removeProfileAttributesFromSet(String s, long al[], Localytics.ProfileScope profilescope)
    {
        getProfileHandler().removeProfileAttributesFromSet(s, al, profilescope.getScope());
    }

    public final void removeProfileAttributesFromSet(String s, String as[])
    {
        removeProfileAttributesFromSet(s, as, Localytics.ProfileScope.APPLICATION);
    }

    public final void removeProfileAttributesFromSet(String s, String as[], Localytics.ProfileScope profilescope)
    {
        getProfileHandler().removeProfileAttributesFromSet(s, as, profilescope.getScope());
    }

    public final void removeProfileAttributesFromSet(String s, Date adate[])
    {
        removeProfileAttributesFromSet(s, adate, Localytics.ProfileScope.APPLICATION);
    }

    public final void removeProfileAttributesFromSet(String s, Date adate[], Localytics.ProfileScope profilescope)
    {
        getProfileHandler().removeProfileAttributesFromSet(s, adate, profilescope.getScope());
    }

    public final void setCustomDimension(int i, String s)
    {
        getAnalyticsHandler().setCustomDimension(i, s);
    }

    public final void setCustomerEmail(String s)
    {
        setSpecialCustomerIdentifierAndAttribute("email", s);
    }

    public final void setCustomerFirstName(String s)
    {
        setSpecialCustomerIdentifierAndAttribute("first_name", s);
    }

    public final void setCustomerFullName(String s)
    {
        setSpecialCustomerIdentifierAndAttribute("full_name", s);
    }

    public final void setCustomerId(String s)
    {
        setIdentifier("customer_id", s);
    }

    public final void setCustomerIdInMemory(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (TextUtils.isEmpty(s))
        {
            s = mInstallationId;
        }
        mCustomerId = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final void setCustomerLastName(String s)
    {
        setSpecialCustomerIdentifierAndAttribute("last_name", s);
    }

    public final void setIdentifier(String s, String s1)
    {
        if ("customer_id".equals(s))
        {
            setCustomerIdInMemory(s1);
        }
        getAnalyticsHandler().setIdentifier(s, s1);
    }

    public final void setInAppMessageDismissButtonImage(Resources resources, int i)
    {
        Object obj = new android.graphics.BitmapFactory.Options();
        obj.inPurgeable = true;
        obj.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        obj = BitmapFactory.decodeResource(resources, i, ((android.graphics.BitmapFactory.Options) (obj)));
        if (obj == null)
        {
            Localytics.Log.w("Cannot load the new dismiss button image. Is the resource id corrected?");
            getMarketingHandler().setDismissButtonImage(null);
            return;
        }
        resources = scaleDownBitmap(((Bitmap) (obj)), TypedValue.applyDimension(1, 40F, resources.getDisplayMetrics()));
        if (resources != obj)
        {
            ((Bitmap) (obj)).recycle();
        }
        getMarketingHandler().setDismissButtonImage(resources);
    }

    public final void setInAppMessageDismissButtonImage(Resources resources, Bitmap bitmap)
    {
        Object obj = null;
        if (bitmap != null)
        {
            resources = scaleDownBitmap(bitmap, TypedValue.applyDimension(1, 40F, resources.getDisplayMetrics()));
            obj = resources;
            if (resources == bitmap)
            {
                obj = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, false);
            }
        }
        getMarketingHandler().setDismissButtonImage(((Bitmap) (obj)));
    }

    public final void setInAppMessageDismissButtonLocation(Localytics.InAppMessageDismissButtonLocation inappmessagedismissbuttonlocation)
    {
        getMarketingHandler().setInAppDismissButtonLocation(inappmessagedismissbuttonlocation);
    }

    public final void setInAppMessageDisplayActivity(_cls02C9 _pcls02c9)
    {
        if (_pcls02c9 == null)
        {
            throw new IllegalArgumentException("attached activity cannot be null");
        }
        getMarketingHandler().setFragmentManager(_pcls02c9.getSupportFragmentManager());
        if (isTestModeEnabled())
        {
            getMarketingHandler().showMarketingTest();
        }
    }

    public final void setInstallationId(String s)
    {
        mInstallationId = s;
    }

    final void setIsAutoIntegrate(boolean flag)
    {
        mIsAutoIntegrate = flag;
    }

    public final void setLocation(Location location)
    {
        getAnalyticsHandler().setLocation(location);
    }

    public final void setOptedOut(boolean flag)
    {
        getAnalyticsHandler().setOptedOut(flag);
    }

    public final void setProfileAttribute(String s, long l)
    {
        setProfileAttribute(s, l, Localytics.ProfileScope.APPLICATION);
    }

    public final void setProfileAttribute(String s, long l, Localytics.ProfileScope profilescope)
    {
        getProfileHandler().setProfileAttribute(s, l, profilescope.getScope());
    }

    public final void setProfileAttribute(String s, String s1)
    {
        setProfileAttribute(s, s1, Localytics.ProfileScope.APPLICATION);
    }

    public final void setProfileAttribute(String s, String s1, Localytics.ProfileScope profilescope)
    {
        getProfileHandler().setProfileAttribute(s, s1, profilescope.getScope());
    }

    public final void setProfileAttribute(String s, Date date)
    {
        setProfileAttribute(s, date, Localytics.ProfileScope.APPLICATION);
    }

    public final void setProfileAttribute(String s, Date date, Localytics.ProfileScope profilescope)
    {
        getProfileHandler().setProfileAttribute(s, date, profilescope.getScope());
    }

    public final void setProfileAttribute(String s, long al[])
    {
        setProfileAttribute(s, al, Localytics.ProfileScope.APPLICATION);
    }

    public final void setProfileAttribute(String s, long al[], Localytics.ProfileScope profilescope)
    {
        getProfileHandler().setProfileAttribute(s, al, profilescope.getScope());
    }

    public final void setProfileAttribute(String s, String as[])
    {
        setProfileAttribute(s, as, Localytics.ProfileScope.APPLICATION);
    }

    public final void setProfileAttribute(String s, String as[], Localytics.ProfileScope profilescope)
    {
        getProfileHandler().setProfileAttribute(s, as, profilescope.getScope());
    }

    public final void setProfileAttribute(String s, Date adate[])
    {
        setProfileAttribute(s, adate, Localytics.ProfileScope.APPLICATION);
    }

    public final void setProfileAttribute(String s, Date adate[], Localytics.ProfileScope profilescope)
    {
        getProfileHandler().setProfileAttribute(s, adate, profilescope.getScope());
    }

    public final void setProxy(Proxy proxy1)
    {
        proxy = proxy1;
    }

    public final void setPushDisabled(boolean flag)
    {
        getAnalyticsHandler().setPushDisabled(flag);
    }

    public final void setPushNotificationOptions(PushNotificationOptions pushnotificationoptions)
    {
        getMarketingHandler().setPushNotificationOptions(pushnotificationoptions);
    }

    public final void setPushRegistrationId(String s)
    {
        getAnalyticsHandler().setPushRegistrationId(s);
    }

    public final void setReferrerId(String s)
    {
        getAnalyticsHandler().setReferrerId(s);
    }

    public final void setScreenFlow(List list)
    {
        getAnalyticsHandler().setScreenFlow(list);
    }

    public final void setTestModeEnabled(boolean flag)
    {
        if (Constants.isTestModeEnabled() != flag)
        {
            Constants.setTestModeEnabled(flag);
            if (flag)
            {
                getMarketingHandler().showMarketingTest();
            }
        }
    }

    public final void tagEvent(String s)
    {
        tagEvent(s, null, 0L);
    }

    public final void tagEvent(String s, Map map)
    {
        tagEvent(s, map, 0L);
    }

    public final void tagEvent(String s, Map map, long l)
    {
        getAnalyticsHandler().tagEvent(s, map, l);
    }

    public final void tagPushReceivedEvent(Intent intent)
    {
        getMarketingHandler().tagPushReceivedEvent(intent);
    }

    public final void tagScreen(String s)
    {
        getAnalyticsHandler().tagScreen(s);
    }

    public final void triggerInAppMessage(String s)
    {
        triggerInAppMessage(s, null);
    }

    public final void triggerInAppMessage(String s, Map map)
    {
        triggerInAppMessage(s, map, false);
    }

    public final void triggerInAppMessage(String s, Map map, boolean flag)
    {
        getMarketingHandler().displayInAppMessage(s, map, flag);
    }

    public final void upload()
    {
        if (!TextUtils.isEmpty(mApiKey))
        {
            String s = getCustomerIdInMemory();
            getProfileHandler().upload(s);
            getAnalyticsHandler().upload(s);
        }
    }

    static 
    {
        INSTANCE = new LocalyticsManager("INSTANCE", 0);
        $VALUES = (new LocalyticsManager[] {
            INSTANCE
        });
    }

    private class _cls1
        implements Runnable
    {

        final LocalyticsManager this$0;

        public void run()
        {
            getMarketingHandler().dismissCurrentInAppMessage();
        }

        _cls1()
        {
            this$0 = LocalyticsManager.this;
            super();
        }
    }

}
