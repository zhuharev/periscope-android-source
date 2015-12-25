// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.database.Cursor;
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

    public String call()
    {
        Cursor cursor1;
        String s;
        cursor1 = null;
        s = null;
        Cursor cursor2 = mProvider.query("info", new String[] {
            "registration_id"
        }, null, null, null);
        Cursor cursor;
        cursor = cursor2;
        cursor1 = cursor;
        if (!cursor2.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_62;
        }
        cursor1 = cursor;
        s = cursor.getString(cursor.getColumnIndexOrThrow("registration_id"));
        if (cursor != null)
        {
            cursor.close();
        }
        return s;
_L2:
        if (cursor1 != null)
        {
            cursor1.close();
        }
        return null;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
        this$0 = AnalyticsHandler.this;
        super();
    }
}
