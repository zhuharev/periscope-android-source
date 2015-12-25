// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.sdk.android.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Entity
{

    private static final int END_INDEX = 1;
    private static final int START_INDEX = 0;
    public final List indices;

    public Entity(int i, int j)
    {
        ArrayList arraylist = new ArrayList(2);
        arraylist.add(0, Integer.valueOf(i));
        arraylist.add(1, Integer.valueOf(j));
        indices = Collections.unmodifiableList(arraylist);
    }

    public int getEnd()
    {
        return ((Integer)indices.get(1)).intValue();
    }

    public int getStart()
    {
        return ((Integer)indices.get(0)).intValue();
    }
}
