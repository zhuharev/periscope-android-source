// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.localytics.android:
//            BaseUploadThread, Constants, BaseHandler, LocalyticsDao

final class ProfileUploadHandler extends BaseUploadThread
{

    private static final String PROFILE_URL = "v1/apps/%s/profiles";

    ProfileUploadHandler(BaseHandler basehandler, TreeMap treemap, String s, LocalyticsDao localyticsdao)
    {
        super(basehandler, treemap, s, localyticsdao);
    }

    final int uploadData()
    {
        int i;
        boolean flag;
        flag = false;
        i = ((flag) ? 1 : 0);
        StringBuilder stringbuilder;
        Iterator iterator;
        String s2;
        if (mData.isEmpty())
        {
            break MISSING_BLOCK_LABEL_316;
        }
        iterator = mData.entrySet().iterator();
        stringbuilder = new StringBuilder();
        s2 = getApiKey();
        String s = null;
_L2:
        Object aobj[];
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        aobj = (Object[])((java.util.Map.Entry)iterator.next()).getValue();
        String s1 = s;
        if (stringbuilder.length() == 0)
        {
            s1 = (String)aobj[0];
            stringbuilder.append('{').append('"').append("customer_id\"").append(':').append('"').append(s1).append('"').append(',').append('"').append("database\"").append(':').append('"').append((String)aobj[1]).append('"').append(',').append('"').append("changes\"").append(':').append('[');
        }
        stringbuilder.append((String)aobj[2]);
        s = s1;
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        stringbuilder.append(',');
        s = s1;
        if (true) goto _L2; else goto _L1
_L1:
        stringbuilder.append("]}");
        s = (new android.net.Uri.Builder()).scheme("https").authority(Constants.PROFILES_HOST).encodedPath(String.format("v1/apps/%s/profiles", new Object[] {
            s2
        })).appendPath(s).toString();
        i = ((flag) ? 1 : 0);
        if (upload(BaseUploadThread.UploadType.PROFILES, s, stringbuilder.toString(), 0))
        {
            i = ((Integer)mData.lastKey()).intValue();
        }
        return i;
_L4:
        return 0;
        Exception exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
