// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package o:
//            _cls5196, FE93, _cls1E6B, _cls1D3C, 
//            _cls1E2C, _cls1E6D, FB34, _cls0645, 
//            _cls1D5D, _cls2148, FF90, _cls1D27

public class _cls1D5A
    implements _cls5196
{
    /* member class not found */
    class if {}

    /* member class not found */
    class if.if {}

    /* member class not found */
    class _cls02CA {}


    public final Context context;
    public final _cls1D3C jl;
    public final _cls02CA jm;
    public final FE93 jp;
    public final _cls2148 jq;
    private final _cls141F.if ke;

    public _cls1D5A()
    {
    }

    public _cls1D5A(Context context1, _cls2148 _pcls2148, _cls141F.if if1)
    {
        this(context1, _pcls2148, if1, new FE93(), new _cls1E6B());
    }

    private _cls1D5A(Context context1, _cls2148 _pcls2148, _cls141F.if if1, FE93 fe93, _cls1E6B _pcls1e6b)
    {
        context = context1.getApplicationContext();
        jq = _pcls2148;
        ke = if1;
        jp = fe93;
        jl = _cls1D3C._mth0640(context1);
        jm = new _cls02CA();
        if1 = new _cls1E2C(fe93);
        boolean flag;
        if (context1.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            context1 = new _cls1E6D(context1, if1);
        } else
        {
            context1 = new FB34();
        }
        if (_cls0645._mth068F())
        {
            (new Handler(Looper.getMainLooper())).post(new _cls1D5D(this, _pcls2148));
        } else
        {
            _pcls2148._mth02CA(this);
        }
        _pcls2148._mth02CA(context1);
    }

    public final void onDestroy()
    {
        FE93 fe93 = jp;
        for (Iterator iterator = _cls0645._mth02CA(fe93.qX).iterator(); iterator.hasNext(); ((FF90)iterator.next()).clear()) { }
        fe93.qY.clear();
    }

    public final void onStart()
    {
        _cls0645._mth0631();
        FE93 fe93 = jp;
        fe93.qZ = false;
        Iterator iterator = _cls0645._mth02CA(fe93.qX).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FF90 ff90 = (FF90)iterator.next();
            if (!ff90._mth027C() && !ff90.isCancelled() && !ff90.isRunning())
            {
                ff90.begin();
            }
        } while (true);
        fe93.qY.clear();
    }

    public final void onStop()
    {
        _cls0645._mth0631();
        FE93 fe93 = jp;
        fe93.qZ = true;
        Iterator iterator = _cls0645._mth02CA(fe93.qX).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FF90 ff90 = (FF90)iterator.next();
            if (ff90.isRunning())
            {
                ff90.pause();
                fe93.qY.add(ff90);
            }
        } while (true);
    }

    public _cls1D27 _mth02CA(Class class1)
    {
        _cls2110 _lcls2110 = _cls1D3C._mth02CA(class1, context);
        _cls2110 _lcls2110_1 = _cls1D3C._mth02CB(class1, context);
        if (_lcls2110 == null && _lcls2110_1 == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown type ")).append(class1).append(". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call").append(" Glide#register with a ModelLoaderFactory for your custom model class").toString());
        } else
        {
            _cls02CA _lcls02ca = jm;
            return (_cls1D27)new _cls1D27(class1, _lcls2110, _lcls2110_1, context, jl, jp, jq, jm);
        }
    }
}
