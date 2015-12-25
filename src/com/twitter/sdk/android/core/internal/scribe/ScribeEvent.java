// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.internal.scribe;

import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import o.ig;
import o.is;
import o.tp;

// Referenced classes of package com.twitter.sdk.android.core.internal.scribe:
//            EventNamespace

public class ScribeEvent
{
    public static class Transform
        implements tp
    {

        private final ig gson;

        public byte[] toBytes(ScribeEvent scribeevent)
        {
            ig ig1 = gson;
            if (scribeevent == null)
            {
                scribeevent = ig1._mth02CA(is.GB);
            } else
            {
                scribeevent = ig1._mth02CA(scribeevent, scribeevent.getClass());
            }
            return scribeevent.getBytes("UTF-8");
        }

        public volatile byte[] toBytes(Object obj)
        {
            return toBytes((ScribeEvent)obj);
        }

        public Transform(ig ig1)
        {
            gson = ig1;
        }
    }


    private static final String CURRENT_FORMAT_VERSION = "2";
    final String category;
    final EventNamespace eventNamespace;
    final String formatVersion;
    final List items;
    final String timestamp;

    public ScribeEvent(String s, EventNamespace eventnamespace, long l)
    {
        this(s, eventnamespace, l, Collections.emptyList());
    }

    public ScribeEvent(String s, EventNamespace eventnamespace, long l, List list)
    {
        category = s;
        eventNamespace = eventnamespace;
        timestamp = String.valueOf(l);
        formatVersion = "2";
        items = Collections.unmodifiableList(list);
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (ScribeEvent)obj;
        if (category == null ? ((ScribeEvent) (obj)).category != null : !category.equals(((ScribeEvent) (obj)).category))
        {
            return false;
        }
        if (eventNamespace == null ? ((ScribeEvent) (obj)).eventNamespace != null : !eventNamespace.equals(((ScribeEvent) (obj)).eventNamespace))
        {
            return false;
        }
        if (formatVersion == null ? ((ScribeEvent) (obj)).formatVersion != null : !formatVersion.equals(((ScribeEvent) (obj)).formatVersion))
        {
            return false;
        }
        if (timestamp == null ? ((ScribeEvent) (obj)).timestamp != null : !timestamp.equals(((ScribeEvent) (obj)).timestamp))
        {
            return false;
        }
        return items == null ? ((ScribeEvent) (obj)).items == null : items.equals(((ScribeEvent) (obj)).items);
    }

    public int hashCode()
    {
        int i;
        if (eventNamespace != null)
        {
            i = eventNamespace.hashCode();
        } else
        {
            i = 0;
        }
        int j;
        if (timestamp != null)
        {
            j = timestamp.hashCode();
        } else
        {
            j = 0;
        }
        int k;
        if (formatVersion != null)
        {
            k = formatVersion.hashCode();
        } else
        {
            k = 0;
        }
        int l;
        if (category != null)
        {
            l = category.hashCode();
        } else
        {
            l = 0;
        }
        int i1;
        if (items != null)
        {
            i1 = items.hashCode();
        } else
        {
            i1 = 0;
        }
        return (((i * 31 + j) * 31 + k) * 31 + l) * 31 + i1;
    }

    public String toString()
    {
        return (new StringBuilder("event_namespace=")).append(eventNamespace).append(", ts=").append(timestamp).append(", format_version=").append(formatVersion).append(", _category_=").append(category).append(", items=").append((new StringBuilder("[")).append(TextUtils.join(", ", items)).append("]").toString()).toString();
    }
}
