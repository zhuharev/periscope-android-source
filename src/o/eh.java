// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

// Referenced classes of package o:
//            ec, dn, _cls09AA, _cls09F0

public final class eh extends dl.if
{

    private LocationSettingsRequest DR;
    private String DS;
    private dn DT;

    public eh(dn dn, _cls09AA _pcls09aa, LocationSettingsRequest locationsettingsrequest, String s)
    {
        DT = dn;
        DR = locationsettingsrequest;
        DS = s;
        super(_pcls09aa);
    }

    protected final void _mth02CB(_cls09A8._cls02CA _pcls02ca)
    {
        ((ec)_pcls02ca)._mth02CA(DR, this, DS);
    }

    public final _cls09F0 _mth02CF(Status status)
    {
        return new LocationSettingsResult(status);
    }
}
