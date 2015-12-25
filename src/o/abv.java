// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;

// Referenced classes of package o:
//            abs, aby, _cls0993, abw, 
//            ack, acj, aca, ql, 
//            xd

public final class abv
{

    private final SharedPreferences aQC;
    private final abs bcD;
    public final aby bcE;
    private final Context mContext;
    final ql mEventBus;
    public final ack mSessionManager;

    public abv(xd xd, ql ql, ack ack1)
    {
        mContext = xd.getApplicationContext();
        aQC = xd.getApplicationContext().getSharedPreferences("push", 0);
        mEventBus = ql;
        mSessionManager = ack1;
        bcD = new abs(mContext, ql, aQC);
        bcE = new aby(xd);
    }

    public final void aD()
    {
        boolean flag;
        if (_cls0993._mth1D4E(mContext) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new abw(_cls0993._mth1D4E(mContext));
        }
        String s = bcD.aC();
        if (TextUtils.isEmpty(s))
        {
            Object obj = mSessionManager;
            if (((ack) (obj)).bde == null)
            {
                ((ack) (obj)).aG();
            }
            obj = ((ack) (obj)).bde;
            if (obj != null)
            {
                obj = ((acj) (obj)).bcY;
            } else
            {
                obj = null;
            }
            _mth02BB("register", ((String) (obj)), null);
            return;
        }
        Object obj1 = mSessionManager;
        if (((ack) (obj1)).bde == null)
        {
            ((ack) (obj1)).aG();
        }
        obj1 = ((ack) (obj1)).bde;
        if (obj1 != null)
        {
            obj1 = ((acj) (obj1)).bcY;
        } else
        {
            obj1 = null;
        }
        _mth02BB("register_token", ((String) (obj1)), s);
    }

    public void _mth02BB(String s, String s1, String s2)
    {
        ComponentName componentname = new ComponentName(mContext.getPackageName(), o/aca.getName());
        s = (new Intent(s, null)).setComponent(componentname).putExtra("cookie", s1);
        if (s2 != null)
        {
            s.putExtra("registration_id", s2);
        }
        mContext.startService(s);
    }
}
