// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;

// Referenced classes of package o:
//            _cls0E04, aak, _cls09F0

final class aal
    implements _cls0E04
{

    private aak bap;

    aal(aak aak1)
    {
        bap = aak1;
        super();
    }

    public final void _mth02CA(_cls09F0 _pcls09f0)
    {
        _pcls09f0 = (LocationSettingsResult)_pcls09f0;
        switch (((LocationSettingsResult) (_pcls09f0)).CW.wC)
        {
        default:
            return;

        case 6: // '\006'
            aak._mth02CA(bap)._mth02CE(_pcls09f0);
            break;
        }
    }
}
