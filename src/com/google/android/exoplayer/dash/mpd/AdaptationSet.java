// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash.mpd;

import java.util.Collections;
import java.util.List;

public class AdaptationSet
{

    public static final int TYPE_AUDIO = 1;
    public static final int TYPE_TEXT = 2;
    public static final int TYPE_UNKNOWN = -1;
    public static final int TYPE_VIDEO = 0;
    public final List contentProtections;
    public final int id;
    public final List representations;
    public final int type;

    public AdaptationSet(int i, int j, List list)
    {
        this(i, j, list, null);
    }

    public AdaptationSet(int i, int j, List list, List list1)
    {
        id = i;
        type = j;
        representations = Collections.unmodifiableList(list);
        if (list1 == null)
        {
            contentProtections = Collections.emptyList();
            return;
        } else
        {
            contentProtections = Collections.unmodifiableList(list1);
            return;
        }
    }

    public boolean hasContentProtection()
    {
        return !contentProtections.isEmpty();
    }
}
