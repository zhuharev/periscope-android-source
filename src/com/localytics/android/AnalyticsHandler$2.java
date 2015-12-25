// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.localytics.android:
//            AnalyticsHandler, BaseProvider

class this._cls0
    implements Callable
{

    final AnalyticsHandler this$0;

    public volatile Object call()
    {
        return call();
    }

    public Map call()
    {
        Cursor cursor;
        HashMap hashmap;
        cursor = null;
        hashmap = new HashMap();
        Cursor cursor1 = mProvider.query("identifiers", null, null, null, null);
_L2:
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor = cursor1;
        hashmap.put(cursor1.getString(cursor1.getColumnIndexOrThrow("key")), cursor1.getString(cursor1.getColumnIndexOrThrow("value")));
        if (true) goto _L2; else goto _L1
_L1:
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return hashmap;
_L4:
        if (cursor != null)
        {
            cursor.close();
        }
        return hashmap;
        Exception exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    ()
    {
        this$0 = AnalyticsHandler.this;
        super();
    }
}
