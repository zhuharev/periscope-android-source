// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.location.LocationRequest;

// Referenced classes of package o:
//            dr, _cls09AA, dt, dj, 
//            bs

public class dg
{

    public dg()
    {
    }

    public bs _mth02CA(_cls09AA _pcls09aa, LocationRequest locationrequest, dj dj)
    {
        return _pcls09aa._mth02CA(new dr(this, _pcls09aa, locationrequest, dj));
    }

    public bs _mth02CA(_cls09AA _pcls09aa, dj dj)
    {
        return _pcls09aa._mth02CA(new dt(this, _pcls09aa, dj));
    }
}
