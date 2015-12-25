// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.content.Context;
import java.io.File;
import java.util.TreeMap;

// Referenced classes of package com.localytics.android:
//            BaseUploadThread, JsonHelper, Constants, BaseHandler, 
//            LocalyticsDao, MarketingMessage

final class MarketingDownloader extends BaseUploadThread
{

    private static final String MARKETING_URL_HTTP = "http://%s/api/v2/applications/%s/amp";
    private static final String MARKETING_URL_HTTPS = "https://%s/api/v2/applications/%s/amp";

    MarketingDownloader(BaseHandler basehandler, TreeMap treemap, String s, LocalyticsDao localyticsdao)
    {
        super(basehandler, treemap, s, localyticsdao);
    }

    static String getLocalFileURL(long l, boolean flag, Context context, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getMarketingDataDirectory(context, s));
        stringbuilder.append(File.separator);
        if (flag)
        {
            stringbuilder.append(String.format("amp_rule_%d.zip", new Object[] {
                Long.valueOf(l)
            }));
        } else
        {
            stringbuilder.append(String.format("marketing_rule_%d", new Object[] {
                Long.valueOf(l)
            }));
            context = new File(stringbuilder.toString());
            if ((!context.exists() || !context.isDirectory()) && !context.mkdirs())
            {
                Localytics.Log.w(String.format("Could not create the directory %s for saving the HTML file.", new Object[] {
                    context.getAbsolutePath()
                }));
                return null;
            }
            stringbuilder.append(File.separator);
            stringbuilder.append("index.html");
        }
        return stringbuilder.toString();
    }

    static String getMarketingDataDirectory(Context context, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(context.getFilesDir().getAbsolutePath());
        stringbuilder.append(File.separator);
        stringbuilder.append(".localytics");
        stringbuilder.append(File.separator);
        stringbuilder.append(s);
        return stringbuilder.toString();
    }

    static String getRemoteFileURL(MarketingMessage marketingmessage)
    {
        String s1 = JsonHelper.getSafeStringFromMap(marketingmessage, "phone_location");
        String s2 = JsonHelper.getSafeStringFromMap(marketingmessage, "devices");
        String s = s1;
        if (s2 != null)
        {
            if (s2.equals("tablet"))
            {
                return JsonHelper.getSafeStringFromMap(marketingmessage, "tablet_location");
            }
            s = s1;
            if (s2.equals("both"))
            {
                s = JsonHelper.getSafeStringFromMap(marketingmessage, "phone_location");
            }
        }
        return s;
    }

    final int uploadData()
    {
        String s1 = getApiKey();
        BaseUploadThread.UploadType uploadtype = BaseUploadThread.UploadType.MARKETING;
        String s;
        if (Constants.USE_HTTPS)
        {
            s = "https://%s/api/v2/applications/%s/amp";
        } else
        {
            s = "http://%s/api/v2/applications/%s/amp";
        }
        upload(uploadtype, String.format(s, new Object[] {
            Constants.MARKETING_HOST, s1
        }), "", 0);
        return 1;
    }
}
