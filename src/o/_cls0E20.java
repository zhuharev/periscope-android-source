// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

// Referenced classes of package o:
//            _cls14B4, _cls0993

public final class _cls0E20 extends _cls14B4.if
{

    private int xE;

    public static Account _mth02CB(_cls14B4 _pcls14b4)
    {
        if (_pcls14b4 == null) goto _L2; else goto _L1
_L1:
        long l = Binder.clearCallingIdentity();
        _pcls14b4 = _pcls14b4._mth0393();
        Binder.restoreCallingIdentity(l);
        return _pcls14b4;
_L4:
        Log.w("AccountAccessor", "Remote account accessor probably died");
        Binder.restoreCallingIdentity(l);
        return null;
        _pcls14b4;
        Binder.restoreCallingIdentity(l);
        throw _pcls14b4;
_L2:
        return null;
        _pcls14b4;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof _cls0E20))
        {
            return false;
        } else
        {
            throw new NullPointerException();
        }
    }

    public final Account _mth0393()
    {
        int i = Binder.getCallingUid();
        if (i == xE)
        {
            return null;
        }
        if (_cls0993._mth02BE(null, i))
        {
            xE = i;
            return null;
        } else
        {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }
}
