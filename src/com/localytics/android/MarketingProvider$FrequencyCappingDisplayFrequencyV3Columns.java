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

    static final String DISPLAY_FREQUENCY_COUNT = "count";
    static final String DISPLAY_FREQUENCY_DAYS = "days";
    static final String FREQUENCY_ID = "frequency_id";
    static final String TABLE_NAME = "frequency_capping_display_frequencies";

    private ()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }
}
