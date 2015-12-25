// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package o;

import java.util.Map;
import tv.periscope.android.api.ApiManager;

// Referenced classes of package o:
//            ahi, zu, atp, atn, 
//            yv, atr, ato, agp, 
//            ql, ahl

final class agh extends ahi
{

    public agh(agp agp, ApiManager apimanager, ql ql, String s, yv yv1, ahl ahl)
    {
        super(agp, apimanager, ql, s, yv1, ahl, ahi.if.blx);
    }

    public final void bM()
    {
        bcW.getBroadcastSummary(bei);
    }

    final void bN()
    {
    }

    final float bO()
    {
        return 0.0F;
    }

    public final void bn()
    {
    }

    public final void bo()
    {
    }

    public final void bp()
    {
    }

    public final void bq()
    {
    }

    public final void onError(Exception exception)
    {
    }

    public final void onEventMainThread(zu zu1)
    {
        static final class _cls1
        {

            static final int $SwitchMap$tv$periscope$android$event$ApiEvent$Type[];

            static 
            {
                $SwitchMap$tv$periscope$android$event$ApiEvent$Type = new int[zu.if.values().length];
                try
                {
                    $SwitchMap$tv$periscope$android$event$ApiEvent$Type[zu.if.aYc.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1..SwitchMap.tv.periscope.android.event.ApiEvent.Type[zu1.aXk.ordinal()])
        {
        case 1: // '\001'
            boolean flag;
            if (zu1.aXl == null && zu1.mU == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                Object obj = (atp)zu1.data;
                zu1 = ((atp) (obj)).fo();
                blq._mth02CA(((atp) (obj)));
                obj = mBroadcastCacheManager;
                zu1 = zu1.id();
                _mth02BC((atn)((yv) (obj)).aWg.get(zu1));
                _mth1483(bei);
                return;
            }
            break;

        default:
            super.onEventMainThread(zu1);
            break;
        }
    }

    public final void _mth02B3(long l)
    {
    }

    final void _mth02CA(agp agp)
    {
    }

    public final void _mth02CA(atr atr1)
    {
        atr1 = atr1.fo();
        boolean flag;
        if (((atn) (atr1)).bDW == ato.bEd)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && ((atn) (atr1)).bDX)
        {
            blq._mth02CB(ahi.if.blv);
        }
    }

    public final void FE7E(boolean flag)
    {
    }
}
