// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.provider.BaseColumns;

// Referenced classes of package com.localytics.android:
//            MigrationDatabaseHelper

static final class 
    implements BaseColumns
{

    static final String NAME = "name";
    static final String PROCESSED_IN_BLOB = "processed_in_blob";
    static final String SESSION_KEY_REF = "session_key_ref";
    static final String TABLE_NAME = "event_history";
    static final String TYPE = "type";
    static final int TYPE_EVENT = 0;
    static final int TYPE_SCREEN = 1;

    private ()
    {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }
}
