// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codahale.metrics;


// Referenced classes of package com.codahale.metrics:
//            Metric, Counting

public interface Metered
    extends Metric, Counting
{

    public abstract long getCount();

    public abstract double getFifteenMinuteRate();

    public abstract double getFiveMinuteRate();

    public abstract double getMeanRate();

    public abstract double getOneMinuteRate();
}
