// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.provider.BaseColumns;

// Referenced classes of package com.localytics.android:
//            AnalyticsProvider

static final class 
    implements BaseColumns
{

    static final String CUSTOM_DIMENSION_KEY = "custom_dimension_key";
    static final String CUSTOM_DIMENSION_VALUE = "custom_dimension_value";
    static final String TABLE_NAME = "custom_dimensions";

    private ()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }
}
