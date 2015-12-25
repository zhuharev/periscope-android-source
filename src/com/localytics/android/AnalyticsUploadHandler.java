// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.localytics.android:
//            BaseUploadThread, Constants, BaseHandler, LocalyticsDao

final class AnalyticsUploadHandler extends BaseUploadThread
{

    private static final String ANALYTICS_URL_HTTP = "http://%s/api/v2/applications/%s/uploads";
    private static final String ANALYTICS_URL_HTTPS = "https://%s/api/v2/uploads";

    AnalyticsUploadHandler(BaseHandler basehandler, TreeMap treemap, String s, LocalyticsDao localyticsdao)
    {
        super(basehandler, treemap, s, localyticsdao);
    }

    final int uploadData()
    {
        int i;
        boolean flag;
        flag = false;
        i = ((flag) ? 1 : 0);
        String s;
        StringBuilder stringbuilder;
        if (mData.isEmpty())
        {
            break MISSING_BLOCK_LABEL_163;
        }
        Iterator iterator = mData.entrySet().iterator();
        stringbuilder = new StringBuilder();
        s = getApiKey();
        for (; iterator.hasNext(); stringbuilder.append('\n'))
        {
            stringbuilder.append(((java.util.Map.Entry)iterator.next()).getValue());
        }

        BaseUploadThread.UploadType uploadtype;
        uploadtype = BaseUploadThread.UploadType.ANALYTICS;
        if (Constants.USE_HTTPS)
        {
            s = String.format("https://%s/api/v2/uploads", new Object[] {
                Constants.ANALYTICS_HOST
            });
            break MISSING_BLOCK_LABEL_130;
        }
        s = String.format("http://%s/api/v2/applications/%s/uploads", new Object[] {
            Constants.ANALYTICS_HOST, s
        });
        i = ((flag) ? 1 : 0);
        if (upload(uploadtype, s, stringbuilder.toString(), 0))
        {
            i = ((Integer)mData.lastKey()).intValue();
        }
        return i;
_L2:
        return 0;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
