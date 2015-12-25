// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            acp, xf, xd, ql, 
//            _cls1D3C, _cls06BA, _cls14FD, aco, 
//            zv

public abstract class ada extends acp
{
    final class if
    {

        private ada bdT;

        public final void onEventMainThread(zv zv1)
        {
            static final class _cls1
            {

                static final int bdS[];

                static 
                {
                    bdS = new int[zv.values().length];
                    try
                    {
                        bdS[zv.aYt.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                    try
                    {
                        bdS[zv.aYv.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        bdS[zv.aYq.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        bdS[zv.aYr.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        bdS[zv.aYs.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                }
            }

            switch (_cls1.bdS[zv1.ordinal()])
            {
            default:
                return;

            case 2: // '\002'
                ada.FE74(false);
                return;

            case 3: // '\003'
                if (!ada.bdQ)
                {
                    ada.FE74(true);
                    Toast.makeText(bdT, 0x7f0600d8, 0).show();
                    aco._mth02BB(bdT);
                    return;
                }
                break;

            case 4: // '\004'
                if (!ada.bdQ)
                {
                    ada.FE74(true);
                    Toast.makeText(bdT, 0x7f060046, 1).show();
                    aco._mth02BB(bdT);
                    return;
                }
                break;

            case 5: // '\005'
                if (!ada.bdQ)
                {
                    ada.FE74(true);
                    Toast.makeText(bdT, 0x7f060181, 1).show();
                    aco._mth02BB(bdT);
                }
                break;
            }
        }

        private if()
        {
            bdT = ada.this;
            super();
        }

        if(byte byte0)
        {
            this();
        }
    }

    /* member class not found */
    class _cls02CA {}


    private static boolean bdP = false;
    private static boolean bdQ = false;
    private static boolean bdR = false;
    private final if bdN = new if((byte)0);
    private final _cls02CA bdO = new _cls02CA((byte)0);

    public ada()
    {
    }

    static boolean aP()
    {
        return bdP;
    }

    public static boolean isVisible()
    {
        return bdR;
    }

    static boolean FBE8(boolean flag)
    {
        bdP = flag;
        return flag;
    }

    static boolean FE74(boolean flag)
    {
        bdQ = flag;
        return flag;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("e_from_push", false))
        {
            xf._mth1D54("Push Notification", null);
        }
        ApiManager.get(this).bind();
    }

    public void onDestroy()
    {
        ApiManager.get(this).unbind();
        super.onDestroy();
    }

    public void onEventMainThread(zv zv)
    {
    }

    public void onPause()
    {
        super.onPause();
        bdR = false;
    }

    public void onResume()
    {
        super.onResume();
        bdR = true;
    }

    public void onStart()
    {
        super.onStart();
        ql ql1 = xd.getEventBus();
        ql1._mth02CA(bdN, false, 0);
        ql1._mth02CA(bdO, false, 0);
        ql1._mth02CA(this, false, 0);
    }

    public void onStop()
    {
        ql ql1 = xd.getEventBus();
        ql1.unregister(this);
        ql1.unregister(bdN);
        ql1.unregister(bdO);
        super.onStop();
    }

    public void onTrimMemory(int i)
    {
        super.onTrimMemory(i);
        _cls1D3C _lcls1d3c = _cls1D3C._mth0640(this);
        _lcls1d3c.je._mth14A1(i);
        _lcls1d3c.jL._mth14A1(i);
    }

    public final void _mth02CA(zv zv)
    {
        ApiManager.get(this).doLogout(zv);
        aco._mth02BB(this);
    }


}
