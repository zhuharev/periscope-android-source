// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

// Referenced classes of package o:
//            _cls09AA, cr, _cls072B, cx, 
//            dc, _cls0E44

public static final class Class.getName
{

    public final Context mContext;
    public final HashSet wT = new HashSet();
    private String wU;
    private String wV;
    private final cr wW = new cr();
    public final cr wX = new cr();
    public int wY;
    public Looper wZ;
    public _cls072B xa;
    public .Looper xb;
    public final ArrayList xc = new ArrayList();
    public final ArrayList xd = new ArrayList();
    private dc xe;

    public final _cls0E44 _mth0296()
    {
        if (wX.containsKey(cx.Ck))
        {
            boolean flag;
            if (xe == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                throw new IllegalStateException(String.valueOf("SignIn.API can't be used in conjunction with requestServerAuthCode."));
            }
            xe = (dc)wX.get(cx.Ck);
        }
        HashSet hashset = wT;
        cr cr1 = wW;
        String s = wU;
        String s1 = wV;
        dc dc1;
        if (xe != null)
        {
            dc1 = xe;
        } else
        {
            dc1 = dc.Cl;
        }
        return new _cls0E44(null, hashset, cr1, 0, null, s, s1, dc1);
    }

    public p.Activity(Activity activity)
    {
        wY = -1;
        xa = _cls072B._mth026D();
        xb = cx.Ci;
        mContext = activity;
        wZ = activity.getMainLooper();
        wU = activity.getPackageName();
        wV = activity.getClass().getName();
    }
}
