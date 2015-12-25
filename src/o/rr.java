// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;


public final class rr
{

    public final boolean Rj;
    public final String advertisingId;

    rr(String s, boolean flag)
    {
        advertisingId = s;
        Rj = flag;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (rr)obj;
        if (Rj != ((rr) (obj)).Rj)
        {
            return false;
        }
        return advertisingId == null ? ((rr) (obj)).advertisingId == null : advertisingId.equals(((rr) (obj)).advertisingId);
    }

    public final int hashCode()
    {
        int i;
        if (advertisingId != null)
        {
            i = advertisingId.hashCode();
        } else
        {
            i = 0;
        }
        int j;
        if (Rj)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        return i * 31 + j;
    }
}
