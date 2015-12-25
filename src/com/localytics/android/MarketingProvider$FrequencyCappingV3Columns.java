// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.provider.BaseColumns;

// Referenced classes of package com.localytics.android:
//            MarketingProvider

static final class 
    implements BaseColumns
{

    static final String CAMPAIGN_ID = "campaign_id";
    static final String IGNORE_GLOBAL = "ignore_global";
    static final String MAX_DISPLAY_COUNT = "max_display_count";
    static final String TABLE_NAME = "frequency_capping_rules";

    private ()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }
}
