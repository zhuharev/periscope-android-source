// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.ArrayList;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            aji, zc, aos, zw, 
//            ajf, atn, ato, yv, 
//            ajb

class aje
{

    protected final ApiManager bcW;
    protected final zc bmU;
    protected final yv boW;
    protected final long boX;
    protected aji boY;
    protected Runnable boZ;
    boolean bpa;

    public aje(ApiManager apimanager, yv yv, zc zc1, long l)
    {
        bcW = apimanager;
        boW = yv;
        bmU = zc1;
        boX = l;
    }

    final void cK()
    {
        if (boY != null)
        {
            boY.cR();
        }
    }

    final void cL()
    {
        bpa = false;
        if (boY != null)
        {
            boY.cS();
        }
    }

    public void cM()
    {
        bcW.megaBroadcastCall();
    }

    public final void cN()
    {
        aos._mth1D0A(bmU.id());
    }

    public void onEventMainThread(zw zw1)
    {
        static final class _cls1
        {

            static final int bcB[];

            static 
            {
                bcB = new int[zw.values().length];
                try
                {
                    bcB[zw.aYI.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
                try
                {
                    bcB[zw.aYH.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
            }
        }

        switch (_cls1.bcB[zw1.ordinal()])
        {
        case 1: // '\001'
            if (boY != null)
            {
                boY.cG();
                return;
            }
            break;

        default:
            _mth02CA(bpa, zw1);
            break;
        }
    }

    public void _mth02C6(long l)
    {
        if (boZ == null)
        {
            boZ = new ajf(this, l);
        }
        aos._mth02CA(bmU.id(), boZ, boX + l);
    }

    protected final ArrayList _mth02C7(long l)
    {
        ArrayList arraylist = new ArrayList();
        int j = bmU.v();
        int i = 0;
        do
        {
            if (i >= j)
            {
                break;
            }
            atn atn1 = bmU._mth1D49(i);
            if (atn1 != null)
            {
                boolean flag;
                if (atn1.bDW == ato.bEd)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag && System.currentTimeMillis() - atn1.bDZ > l)
                {
                    arraylist.add(atn1.id());
                }
            }
            if (arraylist.size() >= 100)
            {
                break;
            }
            i++;
        } while (true);
        return arraylist;
    }

    public final void _mth02CA(ajb ajb)
    {
        boY = ajb;
    }

    protected void _mth02CA(boolean flag, zw zw1)
    {
        switch (_cls1.bcB[zw1.ordinal()])
        {
        default:
            return;

        case 2: // '\002'
            break;
        }
        if (flag)
        {
            bpa = false;
            if (boY != null)
            {
                boY.cS();
            }
            return;
        }
        if (boY != null)
        {
            boY.cR();
        }
    }
}
