// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public abstract class _cls15C1
{

    public _cls15C1()
    {
    }

    public abstract int getEventType();

    public abstract long getTimeMillis();

    public String toString()
    {
        return (new StringBuilder()).append(getTimeMillis()).append("\t").append(getEventType()).append("\t").append(_mth10D8()).append(_mth13B0()).toString();
    }

    public abstract long _mth10D8();

    public abstract String _mth13B0();
}
