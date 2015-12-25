// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.provider.BaseColumns;

// Referenced classes of package com.localytics.android:
//            MigrationDatabaseHelper

static final class I
    implements BaseColumns
{

    static final String KEY = "key";
    static final String TABLE_NAME = "identifiers";
    static final String VALUE = "value";

    private I()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }
}
