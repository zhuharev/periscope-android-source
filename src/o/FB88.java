// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package o:
//            FB4D, _cls1D5A, FEE4, _cls1D42, 
//            _cls1E97, _cls1427, _cls0645, _cls02C9, 
//            _cls1D4E

public final class FB88
    implements android.os.Handler.Callback
{

    private static final FB88 qT = new FB88();
    private final Handler handler = new Handler(Looper.getMainLooper(), this);
    private volatile _cls1D5A qU;
    private HashMap qV;
    private HashMap qW;

    FB88()
    {
        qV = new HashMap();
        qW = new HashMap();
    }

    private _cls1D5A _mth02CA(Activity activity, FragmentManager fragmentmanager)
    {
        FB4D fb4d = _mth02CA(fragmentmanager);
        _cls1D5A _lcls1d5a = fb4d.qP;
        fragmentmanager = _lcls1d5a;
        if (_lcls1d5a == null)
        {
            fragmentmanager = new _cls1D5A(activity, fb4d.qN, fb4d.qO);
            fb4d.qP = fragmentmanager;
        }
        return fragmentmanager;
    }

    private _cls1D5A _mth02CA(_cls02C9 _pcls02c9, _cls1427 _pcls1427)
    {
        FEE4 fee4 = _mth02CA(_pcls1427);
        _cls1D5A _lcls1d5a = fee4.qP;
        _pcls1427 = _lcls1d5a;
        if (_lcls1d5a == null)
        {
            _pcls1427 = new _cls1D5A(_pcls02c9, fee4.qN, fee4.ra);
            fee4.qP = _pcls1427;
        }
        return _pcls1427;
    }

    public static FB88 FF89()
    {
        return qT;
    }

    private _cls1D5A FF9E(Context context)
    {
        if (qU != null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        this;
        JVM INSTR monitorenter ;
        if (qU == null)
        {
            qU = new _cls1D5A(context.getApplicationContext(), new _cls1D42(), new _cls1E97());
        }
        this;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_55;
        context;
        throw context;
        return qU;
    }

    public final boolean handleMessage(Message message)
    {
        boolean flag = true;
        Object obj1 = null;
        Object obj = null;
        switch (message.what)
        {
        case 1: // '\001'
            obj = (FragmentManager)message.obj;
            message = ((Message) (qV.remove(obj)));
            break;

        case 2: // '\002'
            obj = (_cls1427)message.obj;
            message = ((Message) (qW.remove(obj)));
            break;

        default:
            flag = false;
            message = obj1;
            break;
        }
        if (flag && message == null && Log.isLoggable("RMRetriever", 5))
        {
            Log.w("RMRetriever", (new StringBuilder("Failed to remove expected request manager fragment, manager: ")).append(obj).toString());
        }
        return flag;
    }

    public final _cls1D5A _mth02B9(Context context)
    {
        do
        {
            if (context == null)
            {
                throw new IllegalArgumentException("You cannot start a load on a null Context");
            }
            if (!_cls0645._mth068E() || (context instanceof Application))
            {
                break;
            }
            if (context instanceof _cls02C9)
            {
                context = (_cls02C9)context;
                if (_cls0645._mth068F())
                {
                    return _mth02B9(context.getApplicationContext());
                }
                if (android.os.Build.VERSION.SDK_INT >= 17 && context.isDestroyed())
                {
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                } else
                {
                    return _mth02CA(context, context.getSupportFragmentManager());
                }
            }
            if (context instanceof Activity)
            {
                return _mth037A((Activity)context);
            }
            if (!(context instanceof ContextWrapper))
            {
                break;
            }
            context = ((ContextWrapper)context).getBaseContext();
        } while (true);
        return FF9E(context);
    }

    final FB4D _mth02CA(FragmentManager fragmentmanager)
    {
        FB4D fb4d1 = (FB4D)fragmentmanager.findFragmentByTag("com.bumptech.glide.manager");
        FB4D fb4d = fb4d1;
        if (fb4d1 == null)
        {
            FB4D fb4d2 = (FB4D)qV.get(fragmentmanager);
            fb4d = fb4d2;
            if (fb4d2 == null)
            {
                fb4d = new FB4D();
                qV.put(fragmentmanager, fb4d);
                fragmentmanager.beginTransaction().add(fb4d, "com.bumptech.glide.manager").commitAllowingStateLoss();
                handler.obtainMessage(1, fragmentmanager).sendToTarget();
            }
        }
        return fb4d;
    }

    final FEE4 _mth02CA(_cls1427 _pcls1427)
    {
        FEE4 fee4_1 = (FEE4)_pcls1427.findFragmentByTag("com.bumptech.glide.manager");
        FEE4 fee4 = fee4_1;
        if (fee4_1 == null)
        {
            FEE4 fee4_2 = (FEE4)qW.get(_pcls1427);
            fee4 = fee4_2;
            if (fee4_2 == null)
            {
                fee4 = new FEE4();
                qW.put(_pcls1427, fee4);
                _pcls1427._mth02BB()._mth02CA(fee4, "com.bumptech.glide.manager").commitAllowingStateLoss();
                handler.obtainMessage(2, _pcls1427).sendToTarget();
            }
        }
        return fee4;
    }

    public final _cls1D5A _mth037A(Activity activity)
    {
        if (_cls0645._mth068F() || android.os.Build.VERSION.SDK_INT < 11)
        {
            return _mth02B9(activity.getApplicationContext());
        }
        if (android.os.Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())
        {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        } else
        {
            return _mth02CA(activity, activity.getFragmentManager());
        }
    }

}
