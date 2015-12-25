// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.location.LocationSettingsRequest;

// Referenced classes of package o:
//            eh, _cls09AA, bs, _cls09B0

public class dn
{

    public dn()
    {
    }

    public bs _mth02CA(_cls09AA _pcls09aa, LocationSettingsRequest locationsettingsrequest, String s)
    {
        return _pcls09aa._mth02CA(new eh(this, _pcls09aa, locationsettingsrequest, null));
    }

    public _cls09B0 _mth02CA(_cls09AA _pcls09aa, LocationSettingsRequest locationsettingsrequest)
    {
        return _mth02CA(_pcls09aa, locationsettingsrequest, null);
    }
}
