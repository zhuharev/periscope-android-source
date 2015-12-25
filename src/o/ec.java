// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package o:
//            do, eb, eg, dz, 
//            _cls1435, _cls0E44, eh, bt

public final class ec extends do
{
    static final class if extends ea.if
    {

        private bt DQ;

        public final void _mth02CB(LocationSettingsResult locationsettingsresult)
        {
            DQ._mth02CA(locationsettingsresult);
            DQ = null;
        }

        public if(bt bt1)
        {
            boolean flag;
            if (bt1 != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                throw new IllegalArgumentException(String.valueOf("listener can't be null."));
            } else
            {
                DQ = bt1;
                return;
            }
        }
    }


    final eb DP;

    public ec(Context context, Looper looper, _cls09AA._cls02CA _pcls02ca, _cls09AA._cls02CB _pcls02cb, String s, _cls0E44 _pcls0e44)
    {
        super(context, looper, _pcls02ca, _pcls02cb, s, _pcls0e44);
        DP = new eb(context, DB);
    }

    public final void disconnect()
    {
        eb eb1 = DP;
        eb1;
        JVM INSTR monitorenter ;
        boolean flag = isConnected();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        eb eb2 = DP;
        Object obj = eb2.DL;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = eb2.DL.values().iterator();
_L1:
        Object obj2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_99;
            }
            obj2 = (eb._cls02CB)iterator.next();
        } while (obj2 == null);
        ((dz)eb2.DI._mth03C2())._mth02CA(LocationRequestUpdateData._mth02CA(((eb._cls02CB) (obj2)), null));
          goto _L1
        eb2.DL.clear();
        iterator = eb2.DM.values().iterator();
_L2:
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_177;
            }
            obj2 = (eb.if)iterator.next();
        } while (obj2 == null);
        ((dz)eb2.DI._mth03C2())._mth02CA(LocationRequestUpdateData._mth02CA(((eb.if) (obj2)), null));
          goto _L2
        eb2.DM.clear();
        obj;
        JVM INSTR monitorexit ;
          goto _L3
        Exception exception;
        exception;
        throw exception;
        Object obj1;
        obj1;
        throw new IllegalStateException(((Throwable) (obj1)));
_L3:
        obj1 = DP;
        flag = ((eb) (obj1)).DK;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        ((eb) (obj1)).DI._mth039E();
        ((dz)((eb) (obj1)).DI._mth03C2())._mth02EE(false);
        obj1.DK = false;
        break MISSING_BLOCK_LABEL_280;
        obj1;
        throw new IllegalStateException(((Throwable) (obj1)));
        obj1;
        Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", ((Throwable) (obj1)));
        super.disconnect();
        eb1;
        JVM INSTR monitorexit ;
        return;
        obj1;
        throw obj1;
    }

    public final void _mth02CA(LocationSettingsRequest locationsettingsrequest, eh eh, String s)
    {
        if (!isConnected())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
        boolean flag;
        if (locationsettingsrequest != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalArgumentException(String.valueOf("locationSettingsRequest can't be null nor empty."));
        }
        if (eh != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalArgumentException(String.valueOf("listener can't be null."));
        } else
        {
            eh = new if(eh);
            ((dz)_mth05E5())._mth02CA(locationsettingsrequest, eh, s);
            return;
        }
    }

    public final boolean _mth0632()
    {
        return true;
    }
}
