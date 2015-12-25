// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;


// Referenced classes of package com.localytics.android:
//            BaseUploadThread, LocalyticsDao, Constants, AnalyticsHandler

final class ReferralUploader extends BaseUploadThread
{

    private static final String ANALYTICS_URL_HTTP = "http://%s/api/v2/applications/%s/uploads";
    private static final String ANALYTICS_URL_HTTPS = "https://%s/api/v2/uploads";
    private String mFirstSessionEvent;

    ReferralUploader(AnalyticsHandler analyticshandler, String s, LocalyticsDao localyticsdao)
    {
        super(analyticshandler, null, localyticsdao.getCustomerIdInMemory(), localyticsdao);
        mFirstSessionEvent = s;
    }

    public final void run()
    {
        uploadData();
    }

    final int uploadData()
    {
        if (!mFirstSessionEvent.isEmpty())
        {
            Localytics.Log.i((new StringBuilder("[REFERRAL] reupload first session: ")).append(mFirstSessionEvent).toString());
            String s = getApiKey();
            if (Constants.USE_HTTPS)
            {
                s = String.format("https://%s/api/v2/uploads", new Object[] {
                    Constants.ANALYTICS_HOST
                });
            } else
            {
                s = String.format("http://%s/api/v2/applications/%s/uploads", new Object[] {
                    Constants.ANALYTICS_HOST, s
                });
            }
            upload(BaseUploadThread.UploadType.ANALYTICS, s, mFirstSessionEvent, 0, true);
        }
        return 0;
    }
}
