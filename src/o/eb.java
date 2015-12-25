// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ContentProviderClient;
import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package o:
//            eg, dz, dj, dx

public final class eb
{
    public static final class if extends ek.if
    {

        public final void _mth02CA(LocationAvailability locationavailability)
        {
            Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
        }

        public final void _mth02CA(LocationResult locationresult)
        {
            Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
        }
    }

    /* member class not found */
    class _cls02CA {}

    /* member class not found */
    class _cls02CB {}


    final eg DI;
    private ContentProviderClient DJ;
    boolean DK;
    HashMap DL;
    HashMap DM;
    private final Context mContext;

    public eb(Context context, eg eg1)
    {
        DJ = null;
        DK = false;
        DL = new HashMap();
        DM = new HashMap();
        mContext = context;
        DI = eg1;
    }

    _cls02CB _mth02CA(dj dj, Looper looper)
    {
        HashMap hashmap = DL;
        hashmap;
        JVM INSTR monitorenter ;
        _cls02CB _lcls02cb1 = (_cls02CB)DL.get(dj);
        _cls02CB _lcls02cb;
        _lcls02cb = _lcls02cb1;
        if (_lcls02cb1 != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        _lcls02cb = new _cls02CB(dj, looper);
        DL.put(dj, _lcls02cb);
        hashmap;
        JVM INSTR monitorexit ;
        return _lcls02cb;
        dj;
        throw dj;
    }

    public final void _mth02CA(dj dj, dx dx)
    {
        DI._mth039E();
        if (dj == null)
        {
            throw new NullPointerException(String.valueOf("Invalid null listener"));
        }
        HashMap hashmap = DL;
        hashmap;
        JVM INSTR monitorenter ;
        dj = (_cls02CB)DL.remove(dj);
        if (dj == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        dj.DO = null;
        ((dz)DI._mth03C2())._mth02CA(LocationRequestUpdateData._mth02CA(dj, dx));
        hashmap;
        JVM INSTR monitorexit ;
        return;
        dj;
        throw dj;
    }
}
