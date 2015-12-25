// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;

// Referenced classes of package o:
//            _cls072B, cm

abstract class ck extends BroadcastReceiver
{

    private Context mContext;

    ck()
    {
    }

    public static ck _mth02CA(Context context, ck ck1, _cls072B _pcls072b)
    {
        _pcls072b = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        _pcls072b.addDataScheme("package");
        context.registerReceiver(ck1, _pcls072b);
        ck1.mContext = context;
        if (!_cls072B._mth02BB(context, "com.google.android.gms"))
        {
            ck1.FF67();
            ck1.unregister();
            return null;
        } else
        {
            return ck1;
        }
    }

    public static ck _mth02CA(Context context, cm cm)
    {
        return _mth02CA(context, ((ck) (cm)), _cls072B._mth026D());
    }

    public void onReceive(Context context, Intent intent)
    {
        intent = intent.getData();
        context = null;
        if (intent != null)
        {
            context = intent.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(context))
        {
            FF67();
            unregister();
        }
    }

    public final void unregister()
    {
        this;
        JVM INSTR monitorenter ;
        if (mContext != null)
        {
            mContext.unregisterReceiver(this);
        }
        mContext = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract void FF67();
}
