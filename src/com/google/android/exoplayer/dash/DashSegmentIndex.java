// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.dash;

import com.google.android.exoplayer.dash.mpd.RangedUri;

public interface DashSegmentIndex
{

    public static final int INDEX_UNBOUNDED = -1;

    public abstract long getDurationUs(int i, long l);

    public abstract int getFirstSegmentNum();

    public abstract int getLastSegmentNum(long l);

    public abstract int getSegmentNum(long l, long l1);

    public abstract RangedUri getSegmentUrl(int i);

    public abstract long getTimeUs(int i);

    public abstract boolean isExplicit();
}
