// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;

import java.util.Collections;
import java.util.List;

public class UserEntities
{
    public static class UrlEntities
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

        public UrlEntities(List list)
        {
            urls = getSafeList(list);
        }
    }


    public final UrlEntities description;
    public final UrlEntities url;

    public UserEntities(UrlEntities urlentities, UrlEntities urlentities1)
    {
        url = urlentities;
        description = urlentities1;
    }
}
