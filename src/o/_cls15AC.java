// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            _cls15BE, cn, _cls15BF, _cls0E42

public final class _cls15AC
{

    private static _cls15AC yQ;
    private static Integer yW;
    private static final Object yo = new Object();
    private final List yR;
    private final List yS;
    private final List yT;
    private final List yU;
    private _cls15BF yV;
    private _cls15BF yX;

    private _cls15AC()
    {
        if (_mth14A3() == _cls15BE.zf)
        {
            yR = Collections.EMPTY_LIST;
            yS = Collections.EMPTY_LIST;
            yT = Collections.EMPTY_LIST;
            yU = Collections.EMPTY_LIST;
            return;
        }
        Object obj = (String)_cls15BD.if.yZ.get();
        if (obj == null)
        {
            obj = Collections.EMPTY_LIST;
        } else
        {
            obj = Arrays.asList(((String) (obj)).split(","));
        }
        yR = ((List) (obj));
        obj = (String)_cls15BD.if.za.get();
        if (obj == null)
        {
            obj = Collections.EMPTY_LIST;
        } else
        {
            obj = Arrays.asList(((String) (obj)).split(","));
        }
        yS = ((List) (obj));
        obj = (String)_cls15BD.if.zb.get();
        if (obj == null)
        {
            obj = Collections.EMPTY_LIST;
        } else
        {
            obj = Arrays.asList(((String) (obj)).split(","));
        }
        yT = ((List) (obj));
        obj = (String)_cls15BD.if.zc.get();
        if (obj == null)
        {
            obj = Collections.EMPTY_LIST;
        } else
        {
            obj = Arrays.asList(((String) (obj)).split(","));
        }
        yU = ((List) (obj));
        yV = new _cls15BF(1024, ((Long)_cls15BD.if.zd.get()).longValue());
        yX = new _cls15BF(1024, ((Long)_cls15BD.if.zd.get()).longValue());
    }

    public static String _mth02CA(ServiceConnection serviceconnection)
    {
        return String.valueOf((long)Process.myPid() << 32 | (long)System.identityHashCode(serviceconnection));
    }

    private static void _mth02CA(Context context, String s, int i, String s1, String s2, String s3, String s4)
    {
        long l1 = System.currentTimeMillis();
        Object obj = null;
        String s5 = obj;
        if ((_mth14A3() & _cls15BE.zg) != 0)
        {
            s5 = obj;
            if (i != 13)
            {
                s5 = _cls141D.if._mth02CB(3, 5);
            }
        }
        long l = 0L;
        if ((_mth14A3() & _cls15BE.zi) != 0)
        {
            l = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14)
        {
            s = new ConnectionEvent(l1, i, null, null, null, null, s5, s, SystemClock.elapsedRealtime(), l);
        } else
        {
            s = new ConnectionEvent(l1, i, s1, s2, s3, s4, s5, s, SystemClock.elapsedRealtime(), l);
        }
        context.startService((new Intent()).setComponent(_cls15BE.ze).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", s));
    }

    private static boolean _mth02CA(Context context, Intent intent)
    {
        intent = intent.getComponent();
        if (intent == null || _cls0E42.xF && "com.google.android.gms".equals(intent.getPackageName()))
        {
            return false;
        } else
        {
            return _cls141D.if._mth02CA(context, intent.getPackageName());
        }
    }

    private boolean _mth02CA(String s, String s1, String s2, String s3)
    {
        int i = _mth14A3();
        return !yR.contains(s) && !yS.contains(s1) && !yT.contains(s2) && !yU.contains(s3) && (!s2.equals(s) || (_cls15BE.zh & i) == 0);
    }

    private static ServiceInfo _mth02CB(Context context, Intent intent)
    {
        context = context.getPackageManager().queryIntentServices(intent, 128);
        if (context == null || context.size() == 0)
        {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[] {
                intent.toUri(0), _cls141D.if._mth02CB(3, 20)
            }));
            return null;
        }
        if (context.size() > 1)
        {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[] {
                intent.toUri(0), _cls141D.if._mth02CB(3, 20)
            }));
            intent = context.iterator();
            if (intent.hasNext())
            {
                Log.w("ConnectionTracker", ((ResolveInfo)intent.next()).serviceInfo.name);
                return null;
            }
        }
        return ((ResolveInfo)context.get(0)).serviceInfo;
    }

    public static _cls15AC _mth13DE()
    {
        Object obj = yo;
        obj;
        JVM INSTR monitorenter ;
        if (yQ == null)
        {
            yQ = new _cls15AC();
        }
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        return yQ;
    }

    private static int _mth14A3()
    {
        if (yW != null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        SecurityException securityexception;
        int i;
        if (_cls0E42.xF && cn.isInitialized() && cn._mth010B() == Process.myUid())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            try
            {
                i = ((Integer)_cls15BD.if.yY.get()).intValue();
                break MISSING_BLOCK_LABEL_56;
            }
            // Misplaced declaration of an exception variable
            catch (SecurityException securityexception)
            {
                yW = Integer.valueOf(_cls15BE.zf);
            }
            break MISSING_BLOCK_LABEL_75;
        }
        i = _cls15BE.zf;
        yW = Integer.valueOf(i);
        return yW.intValue();
    }

    public void _mth02CA(Context context, String s, String s1, Intent intent, int i)
    {
        boolean flag;
        if (!_cls0E42.xF)
        {
            flag = false;
        } else
        if (_mth14A3() == _cls15BE.zf)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag || yV == null)
        {
            return;
        }
        Object obj;
        String s2;
        if (i == 4 || i == 1)
        {
            if (!yV._mth02B4(s))
            {
                return;
            }
            s2 = null;
            intent = null;
            obj = null;
        } else
        {
            obj = _mth02CB(context, intent);
            if (obj == null)
            {
                Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[] {
                    s1, intent.toUri(0)
                }));
                return;
            }
            s2 = ((ServiceInfo) (obj)).processName;
            intent = ((ServiceInfo) (obj)).name;
            obj = _cls141D.if._mth02CA(context);
            if (!_mth02CA(((String) (obj)), s1, s2, ((String) (intent))))
            {
                return;
            }
            yV._mth02B3(s);
        }
        _mth02CA(context, s, i, ((String) (obj)), s1, s2, ((String) (intent)));
    }

    public final boolean _mth02CA(Context context, String s, Intent intent, _cls14B0._cls02CA.if if1, int i)
    {
        if (_mth02CA(context, intent))
        {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean flag = context.bindService(intent, if1, 129);
        if (flag)
        {
            _mth02CA(context, String.valueOf((long)Process.myPid() << 32 | (long)System.identityHashCode(if1)), s, intent, 2);
        }
        return flag;
    }

}
