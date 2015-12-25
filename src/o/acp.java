// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.app.Activity;
import android.os.Bundle;

// Referenced classes of package o:
//            _cls0675, qb, qh, qe

public abstract class acp extends Activity
{

    public qh bdr;

    public acp()
    {
    }

    public String aI()
    {
        return "";
    }

    public boolean aJ()
    {
        return false;
    }

    public void onCreate(Bundle bundle)
    {
        _cls0675.setString("activity", aI());
        super.onCreate(bundle);
    }

    public void onPause()
    {
        super.onPause();
        if (bdr != null && aJ())
        {
            qb._mth01AC()._mth02CA(bdr);
        }
    }

    public void onResume()
    {
        super.onResume();
        String s = qb._mth01AC()._mth02B2(aI());
        if (aJ() || bdr == null || bdr._mth03BF())
        {
            bdr = _mth207F(s);
        }
    }

    public qh _mth207F(String s)
    {
        return new qe();
    }
}
