// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.localytics.android:
//            InAppManager, BaseProvider, MarketingMessage

class this._cls0
    implements Callable
{

    final InAppManager this$0;

    public volatile Object call()
    {
        return call();
    }

    public List call()
    {
        Cursor cursor;
        Object obj;
        ArrayList arraylist;
        arraylist = new ArrayList();
        cursor = null;
        obj = null;
        Cursor cursor1 = mProvider.query("marketing_rules", null, null, null, "campaign_id");
_L2:
        obj = cursor1;
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = cursor1;
        cursor = cursor1;
        MarketingMessage marketingmessage = new MarketingMessage();
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("_id", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("_id"))));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("campaign_id", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("campaign_id"))));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("expiration", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("expiration"))));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("display_seconds", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("display_seconds"))));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("display_session", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("display_session"))));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("version", cursor1.getString(cursor1.getColumnIndexOrThrow("version")));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("phone_location", cursor1.getString(cursor1.getColumnIndexOrThrow("phone_location")));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("phone_size_width", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("phone_size_width"))));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("phone_size_height", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("phone_size_height"))));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("tablet_location", cursor1.getString(cursor1.getColumnIndexOrThrow("tablet_location")));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("tablet_size_width", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("tablet_size_width"))));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("tablet_size_height", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("tablet_size_height"))));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("time_to_display", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("time_to_display"))));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("internet_required", Integer.valueOf(cursor1.getInt(cursor1.getColumnIndexOrThrow("internet_required"))));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("ab_test", cursor1.getString(cursor1.getColumnIndexOrThrow("ab_test")));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("rule_name_non_unique", cursor1.getString(cursor1.getColumnIndexOrThrow("rule_name_non_unique")));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("location", cursor1.getString(cursor1.getColumnIndexOrThrow("location")));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("devices", cursor1.getString(cursor1.getColumnIndexOrThrow("devices")));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("control_group", cursor1.getString(cursor1.getColumnIndexOrThrow("control_group")));
        obj = cursor1;
        cursor = cursor1;
        marketingmessage.put("schema_version", cursor1.getString(cursor1.getColumnIndexOrThrow("schema_version")));
        obj = cursor1;
        cursor = cursor1;
        arraylist.add(marketingmessage);
        if (true) goto _L2; else goto _L1
_L1:
        obj = arraylist;
        if (cursor1 != null)
        {
            cursor1.close();
            return arraylist;
        }
          goto _L3
_L5:
        obj = null;
        if (cursor != null)
        {
            cursor.close();
            return null;
        }
          goto _L3
        Exception exception;
        exception;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw exception;
_L3:
        return ((List) (obj));
        Exception exception1;
        exception1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    ()
    {
        this$0 = InAppManager.this;
        super();
    }
}
