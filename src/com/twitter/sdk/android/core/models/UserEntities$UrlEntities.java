// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.twitter.sdk.android.core.models:
//            UserEntities

public static class getSafeList
{

    public final List urls;

    private List getSafeList(List list)
    {
        if (list == null)
        {
            return Collections.EMPTY_LIST;
        } else
        {
            return Collections.unmodifiableList(list);
        }
    }

    public (List list)
    {
        urls = getSafeList(list);
    }
}
