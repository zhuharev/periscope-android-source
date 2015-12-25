// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.text;

import java.util.List;

public interface Subtitle
{

    public abstract List getCues(long l);

    public abstract long getEventTime(int i);

    public abstract int getEventTimeCount();

    public abstract long getLastEventTime();

    public abstract int getNextEventTimeIndex(long l);
}
