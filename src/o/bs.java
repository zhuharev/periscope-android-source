// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package o:
//            bu, bt, _cls09AA, _cls09F0

public abstract class bs extends bu
    implements bt, cd.aux
{

    private AtomicReference Aj;
    final _cls09A8._cls02CB wR;

    public bs(_cls09A8._cls02CB _pcls02cb, _cls09AA _pcls09aa)
    {
        if (_pcls09aa == null)
        {
            throw new NullPointerException(String.valueOf("GoogleApiClient must not be null"));
        }
        super(((_cls09AA)_pcls09aa).getLooper());
        Aj = new AtomicReference();
        if (_pcls02cb == null)
        {
            throw new NullPointerException("null reference");
        } else
        {
            wR = (_cls09A8._cls02CB)_pcls02cb;
            return;
        }
    }

    public final _cls09A8._cls02CB _mth028F()
    {
        return wR;
    }

    public final void _mth02CA(LocationSettingsResult locationsettingsresult)
    {
        super._mth02CB((_cls09F0)locationsettingsresult);
    }

    public final void _mth02CA(cd._cls02CF _pcls02cf)
    {
        Aj.set(_pcls02cf);
    }

    public final void _mth02CA(_cls09A8._cls02CA _pcls02ca)
    {
        try
        {
            _mth02CB(_pcls02ca);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (_cls09A8._cls02CA _pcls02ca)
        {
            _mth02CB(new Status(8, _pcls02ca.getLocalizedMessage(), null));
            throw _pcls02ca;
        }
        // Misplaced declaration of an exception variable
        catch (_cls09A8._cls02CA _pcls02ca)
        {
            _mth02CB(new Status(8, _pcls02ca.getLocalizedMessage(), null));
        }
    }

    public final void _mth02CB(Status status)
    {
        boolean flag;
        if (status.wC <= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalArgumentException(String.valueOf("Failed result must not be success"));
        } else
        {
            _mth02CB(_mth02CF(status));
            return;
        }
    }

    public abstract void _mth02CB(_cls09A8._cls02CA _pcls02ca);

    public final void _mth1EC8()
    {
        _mth02CA(((_cls0E04) (null)));
    }

    protected final void _mth1FD2()
    {
        cd._cls02CF _lcls02cf = (cd._cls02CF)Aj.getAndSet(null);
        if (_lcls02cf != null)
        {
            _lcls02cf._mth02CE(this);
        }
    }
}
